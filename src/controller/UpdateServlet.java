package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;
import models.validator.TaskValidator;
import utils.DBUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Task t = em.find(Task.class, (Integer)(request.getSession().getAttribute("task_id")));

            String title = request.getParameter("title");
            t.setTitle(title);

            String content = request.getParameter("content");
            t.setContent(content);

            String place = request.getParameter("place");
            t.setPlace(place);

            String sdate = request.getParameter("startdate");
            t.setStartdate(sdate);
            String edate = request.getParameter("endate");
            t.setEndate(edate);

            String stime = request.getParameter("starttime");
            t.setStarttime(stime);
            String etime = request.getParameter("endtime");
            t.setEndtime(etime);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            t.setUpdated_at(currentTime);

            List<String> errors = TaskValidator.validate(t);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("task", t);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                request.getSession().setAttribute("flush", "更新が完了しました。");
                em.close();

                request.getSession().removeAttribute("task_id");
                response.sendRedirect(request.getContextPath() + "/index");
            }
        }
    }
}