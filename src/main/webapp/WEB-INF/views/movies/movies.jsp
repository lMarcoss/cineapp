<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<spring:url value="/resources" var="urlPublic"/>
<c:set var="context" value="${fn:replace(urlPublic, '/resources', '')}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Movies</title>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

<!-- Fixed navbar -->
<jsp:include page="../includes/menu.jsp"/>

<div class="container theme-showcase" role="main">

    <h3>Movies</h3>

    <a href="${context}/movies/create" class="btn btn-success" role="button" title="New Movie">New movie</a><br><br>

    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Title</th>
                <th>Genre</th>
                <th>Clasification</th>
                <th>Duration</th>
                <th>Date</th>
                <th>Status</th>
                <th>Options</th>
            </tr>
            <c:forEach items="${listMovies}" var="movie">
                <tr>
                    <td>${movie.title}</td>
                    <td>${movie.genre}</td>
                    <td>${movie.clasification}</td>
                    <td>${movie.duration}</td>
                    <td><fmt:formatDate value="${movie.date}" pattern="dd-MM-yyyy"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${movie.status eq 'Active'}">
                                <span class="label label-success">${movie.status}</span>
                            </c:when>
                            <c:otherwise>
                                <span class="label label-danger">${movie.status}</span>
                            </c:otherwise>
                        </c:choose>

                    </td>
                    <td>
                        <a href="#" class="btn btn-success btn-sm" role="button" title="Edit"><span
                                class="glyphicon glyphicon-pencil"></span></a>
                        <a href="#" class="btn btn-danger btn-sm" role="button" title="Eliminar"><span
                                class="glyphicon glyphicon-trash"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <hr class="featurette-divider">

    <!-- FOOTER -->
    <jsp:include page="../includes/footer.jsp"/>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
