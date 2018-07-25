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
    <title>Create movie</title>

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

    <form action="${context}/movies/save" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" class="form-control" name="title" id="title" required="required" />
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="duration">Duration</label>
                    <input type="text" class="form-control" name="duration" id="duration" required="required" />
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="clasification" class="control-label">Clasification</label>
                    <select id="clasification" name="clasification" class="form-control">
                        <option value="A">Clasification A</option>
                        <option value="B">Clasification B</option>
                        <option value="C">Clasification C</option>
                    </select>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="genre" class="control-label">Genre</label>
                    <select id="genre" name="genre" class="form-control">
                        <option value="Action">Action</option>
                        <option value="Aventure">Aventure</option>
                        <option value="Classical">Classical</option>
                        <option value="Romantic">Romantic</option>
                        <option value="Drama">Drama</option>
                        <option value="Terror">Terror</option>
                        <option value="Childish">Childish</option>
                        <option value="Action and aventure">Action and aventure</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="status" class="control-label">Status</label>
                    <select id="status" name="status" class="form-control">
                        <option value="Active">Active</option>
                        <option value="Inactive">Inactive</option>
                    </select>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="date">Date</label>
                    <input type="text" class="form-control" name="date" id="date" required="required" />
                </div>
            </div>

            <div class="col-sm-3">
                <div class="form-group">
                    <label for="picture">Imagen</label>
                    <input type="file" id="picture" name="picture" />
                    <p class="help-block">Imagen de la pelicula</p>
                </div>
            </div>
        </div>

        <!--
        <div class="page-header">
            <h3 class="blog-title"><span class="label label-success">Detalles</span></h3>
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="director">Director</label>
              <input type="text" class="form-control" name="director" id="director" required="required" />
            </div>
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="actores">Actores</label>
              <input type="text" class="form-control" name="actores" id="actores" required="required" />
            </div>
          </div>

          <div class="col-sm-6">
            <div class="form-group">
              <label for="trailer">URL del Trailer (Youtube)</label>
              <input type="text" class="form-control" name="trailer" id="trailer" placeholder="URL completa del video de YOUTUBE" required="required" />
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-sm-6">
            <div class="form-group">
              <label for="sinopsis">Sinopsis</label>
              <textarea class="form-control" rows="5" name="sinopsis" id="sinopsis"></textarea>
            </div>
          </div>
        </div>
        -->

        <button type="submit" class="btn btn-danger" >Save</button>
    </form>

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
