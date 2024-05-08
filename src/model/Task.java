package model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(
            name = "getAllTasks",
            query = "SELECT t FROM Task AS t ORDER BY t.id DESC"
            ),
    @NamedQuery(
            name = "getTasksCount",
            query = "SELECT COUNT(t) FROM Task AS t"
            ),
    @NamedQuery(
            name = "getAllTasksOrderbyStartDate",
            query = "SELECT t FROM Task AS t ORDER BY t.startdate DESC"
            ),
    @NamedQuery(
            name = "getAllTasksOrderbyEndDate",
            query = "SELECT t FROM Task AS t ORDER BY t.endate DESC"
            )
})
@Table(name = "tasks")
public class Task {
	//test message
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "content", length = 255, nullable = false)
    private String content;

    @Column(name = "place", length = 255, nullable = false)
    private String place;

    @Column(name = "startdate", length = 255, nullable = false)
    private String startdate;

    @Column(name = "starttime", length = 255, nullable = false)
    private String starttime;

    @Column(name = "endtime", length = 255, nullable = false)
    private String endtime;

    @Column(name = "endate", length = 255, nullable = false)
    private String endate;
    // enddate or endate?

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEndate() {
		return endate;
	}

	public void setEndate(String endate) {
		this.endate = endate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}


}