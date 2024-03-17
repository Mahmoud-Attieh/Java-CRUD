<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Kickball League Dashboard</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<main class="container">
  <div>
  <h1>Welcome, <c:out value="${currentUser.userName}"/> !</h1>
  <h4><a href="/logout">logout</a></h4>
  </div>
  <br>
  <table>
    <tr>
      <th>Team Name</th>
      <th>Skill Level(1-5)</th>
      <th>Game Day </th>
    </tr>

  <c:forEach var="i" items="${allteam}">
    <tr>
      <td><a href="/teams/${i.id}"> ${i.teamName} </a></td>
      <td>${i.skillLevel}</td>
      <td>${i.gameDay}</td>

    </tr>

  </c:forEach>
  </table>
  <a href="/teams/new">Create a new Team</a>
</main>
</body>
</html>