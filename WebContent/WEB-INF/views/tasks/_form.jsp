<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${errors != null}">
	<div id="flush_error">
		入力内容にエラーがあります。<br />
		<c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" />
			<br />
		</c:forEach>

	</div>
</c:if>
<label for="title">タイトル</label>
<br />
<input type="text" name="title" id="title" value="${task.title}" />
<br />
<br />

<label for="content">内容</label>
<br />
<input type="text" name="content" id="content" value="${task.content}" />
<br />
<br />

<label for="place">場所</label>
<br />
<input type="text" name="place" id="place" value="${task.place}" />
<br />
<br />


<label for="startdate">StartDate:</label>
<input type="date" id="startdate" name="startdate"
	value="${task.startdate}" required>

<label for="starttime">StartTime:</label>
<input type="time" id="starttime" name="starttime"
	value="${task.starttime}" required />
<br />
<br />
<label for="endate">EndDate:</label>
<input type="date" id="enddate" name="endate" value="${task.endate}"
	required />

<label for="endtime">EndTime:</label>
<input type="time" id="endtime" name="endtime" value="${task.endtime}"
	required />
<br />
<br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>