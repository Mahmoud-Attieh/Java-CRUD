
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Create a New Team</title>
</head>
<body>
<h1>New Team </h1>
<a href="/home">Dashboard</a>
<form:form action="/teams/new" method="post" modelAttribute="team">
    <form:input type="hidden" path="teamCreator" value="${user.id}"/>
    <p>
        <form:label path="teamName">teamName</form:label>
    <p class="error" style="color: red;"><form:errors path="teamName"/></p>
    <form:input path="teamName"/>
    </p>
    <p>
        <form:label path="skillLevel">Skill Level</form:label>
    <p class="error" style="color: red;"><form:errors path="skillLevel"/></p>
    <form:input type="number" path="skillLevel"/>
    </p>

    <p>
        <form:label path="gameDay">Game Day</form:label>
    <p class="error" style="color: red;"><form:errors path="gameDay"/></p>
    <form:input path="gameDay"/>
    </p>


    <input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>
</body>
</body>
</html>

