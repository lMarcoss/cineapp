<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome to cineapp</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
          integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
</head>
<body>
<div>
    <h3 class="panel-title">Movies</h3>
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
                <td>${movie.picture}</td>
                <td>${movie.date}</td>
                <td>${movie.status}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>