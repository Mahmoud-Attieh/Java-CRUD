<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title> Team Details</title>
</head>
<body>

<h1>  ${team.teamName}  </h1>
<a href="/home">Dashboard</a>


<h2> Team Name: ${team.teamName}  </h2>
<h2> Added By : ${team.teamCreator.userName}  </h2>
<h2> Skill Level : ${team.skillLevel}  </h2>
<h2> Game Day: ${team.gameDay}  </h2>

<c:if test="${team.teamCreator.id == userId}">
<h3>
    <a href="/teams/${team.id}/edit">Edit</a>
    <a href="/delete/${team.id}">Delete</a>

</h3>

</c:if>





</body>
</html>
