<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<form action="persons" method="get">
	 <input class="btn btn-primary"
			type="submit" value="vai agli attori">
	</form>
	<center>
	<h3>lista attori dato il film... ${titolo}</h3></center>

<c:if test="${!empty listaAttoriDiQuestoTitolo}">
	<table class="table table-dark table-striped">
	<tr>
		<th>id</th>
		<th>nome attore</th>
		<th>cognome attore</th>
	</tr>
	<c:forEach items="${listaAttoriDiQuestoTitolo}" var="j">
		<tr>
			<td>${j.id_film_actor}</td>
				<td>${j.actor.name}</td>
			<td>${j.actor.lastName}</td>
				</tr>
	</c:forEach>
	</table>
</c:if>

	
	</div>
</body>
</html>