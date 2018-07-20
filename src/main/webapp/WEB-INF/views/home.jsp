<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome to cineapp</title>
    <spring:url value="/resources" var="urlPublic"/>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">

</head>
<body>
<div>
    <div class="panel panel-default">
        <div class="panel-heading">Movies</div>
        <div class="panel-body">
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <td>Id</td>
                    <td>Title</td>
                    <td>Duration</td>
                    <td>Clasification</td>
                    <td>Genre</td>
                    <td>Image</td>
                    <td>Date</td>
                    <td>Status</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listMovies}" var="movie">
                    <tr>
                        <td>${movie.id}</td>
                        <td>${movie.title}</td>
                        <td>${movie.duration} min</td>
                        <td>${movie.clasification}</td>
                        <td>${movie.genre}</td>
                        <td><img src="${urlPublic}/images/${movie.picture}" width="80" height="100"></td>
                        <td><fmt:formatDate value="${movie.date}" pattern="dd-MM-yyyy"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${movie.status == 'Active'}">
                                    <span class="label label-success">${movie.status}</span>
                                </c:when>
                                <c:when test="${movie.status == 'Inactive'}">
                                    <span class="label label-danger">${movie.status}</span>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>