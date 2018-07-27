<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
    <meta name="author" content="">
    <title>Creacion de Horarios</title>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script>
        function validateInputOff() {
            var inputFields = document.getElementsByTagName("input");
            for (var i = 0; i < inputFields.length; i++) {
                var field = inputFields[i];
                if (field.type === "text") {
                    field.autocomplete = "off";
                }
            }
        }
    </script>
</head>

<body onload="validateInputOff()">

<!-- Fixed navbar -->
<jsp:include page="../includes/menu.jsp"/>

<div class="container theme-showcase" role="main">

    <h3 class="blog-title"><span class="label label-success">Data Schedule</span></h3>
    <spring:hasBindErrors name="schedule">
        <div class="alert alert-danger">
            Please! fix de following errors
            <ul>
                <c:forEach items="${errors.allErrors}" var="error">
                    <li><spring:message message="${error}"/></li>
                </c:forEach>
            </ul>
        </div>
    </spring:hasBindErrors>

    <form:form method="post" action="${context}/schedules/schedule" autocomplete="false" modelAttribute="schedule">
        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="movie" class="control-label">Movie</label>
                    <form:select path="movie.id" id="movie" items="${listMovies}" itemValue="id" itemLabel="title"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="date">Date</label>
                    <form:input type="text" class="form-control" path="date" id="date" required="required"
                                autocomplete="false"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="hour">Hour</label>
                    <form:input type="text" class="form-control" path="hour" id="hour"
                                placeholder="Formato: HH:mm Ejemplo 21:30" required="required"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="room" class="control-label">Sala</label>
                    <form:select id="room" path="room" class="form-control" items="${listRooms}"/>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="form-group">
                    <label for="price">Price</label>
                    <form:input type="text" class="form-control" path="price" id="price" required="required"/>
                </div>
            </div>

        </div>

        <button type="submit" class="btn btn-danger">Guardar</button>
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
