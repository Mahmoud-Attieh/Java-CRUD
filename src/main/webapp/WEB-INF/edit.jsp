
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Team </title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<h1>Edit Team </h1>
<a href="/home">Dashboard</a>
<form:form action="/teams/${team.id}" method="post" modelAttribute="team">
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

    <h3>
        <a href="/delete/${team.id}">Delete</a>
    </h3>


</body>
</html>
