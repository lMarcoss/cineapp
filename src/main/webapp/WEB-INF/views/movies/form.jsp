<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
    <title>Create movie | Cinema</title>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>

<!-- Fixed navbar -->
<jsp:include page="../includes/menu.jsp"/>

<div class="container theme-showcase" role="main">

    <div class="page-header">
        <h3 class="blog-title"><span class="label label-success">Datos de la Pelicula</span></h3>
    </div>

    <spring:hasBindErrors name="movie">
        <div class="alert alert-danger">
            Please! fix de following errors
            <ul>
                <c:forEach items="${errors.allErrors}" var="error">
                    <li><spring:message message="${error}"/></li>
                </c:forEach>
            </ul>
        </div>
    </spring:hasBindErrors>

    <form:form action="${context}/movies/save" method="post" enctype="multipart/form-data" modelAttribute="movie">
        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <img class="img-rounded" src="${urlPublic}/images/${movie.picture}" title="Picture" alt="Generic placeholder image"
                         width="150"
                         height="200">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="title">Title</label>
                    <form:hidden path="id"/>
                    <form:input type="text" class="form-control" path="title" id="title" required="required"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="duration">Duration</label>
                    <form:input type="text" class="form-control" path="duration" id="duration" required="required"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="clasification" class="control-label">Clasification</label>
                    <form:select id="clasification" path="clasification" class="form-control">
                        <form:option value="A">Clasification A</form:option>
                        <form:option value="B">Clasification B</form:option>
                        <form:option value="C">Clasification C</form:option>
                    </form:select>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="genre" class="control-label">Genre</label>
                    <form:select id="genre" path="genre" class="form-control" items="${listGenres}">
                        <%--<form:option value="Action">Action</form:option>
                        <form:option value="Aventure">Aventure</form:option>
                        <form:option value="Classical">Classical</form:option>
                        <form:option value="Romantic">Romantic</form:option>
                        <form:option value="Drama">Drama</form:option>
                        <form:option value="Terror">Terror</form:option>
                        <form:option value="Childish">Childish</form:option>
                        <form:option value="Action and aventure">Action and aventure</form:option>--%>
                    </form:select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="status" class="control-label">Status</label>
                    <form:select id="status" path="status" class="form-control">
                        <form:option value="Active">Active</form:option>
                        <form:option value="Inactive">Inactive</form:option>
                    </form:select>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="date">Date</label>
                    <form:input type="text" class="form-control" path="date" id="date" required="required"/>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="form-group">
                    <label for="picture">Imagen</label>
                    <input type="file" id="picture" name="picture"/>
                    <p class="help-block">Imagen de la pelicula</p>
                </div>
            </div>
        </div>

        <div class="page-header">
            <h3 class="blog-title"><span class="label label-success">Details</span></h3>
        </div>

        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="manager">Manager</label>
                    <form:input type="text" class="form-control" path="detailMovie.manager" id="manager"
                                required="required"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="actors">Actors</label>
                    <form:input type="text" class="form-control" path="detailMovie.actors" id="actors"
                                required="required"/>
                </div>
            </div>

            <div class="col-sm-6">
                <div class="form-group">
                    <label for="trailer">URL del Trailer (Youtube)</label>
                    <input type="text" class="form-control" name="trailer" id="trailer"
                           placeholder="URL completa del video de YOUTUBE" required="required"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="sinopsis">Sinopsis</label>
                    <form:textarea class="form-control" rows="5" path="detailMovie.sinopsis"
                                   id="sinopsis"></form:textarea>
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-danger">Save</button>
    </form:form>

    <hr class="featurette-divider">

    <!-- FOOTER -->
    <jsp:include page="../includes/footer.jsp"/>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $(function () {
            $("#date").datepicker({dateFormat: 'dd-mm-yy'});
        }
    );
</script>
</body>
</html>
