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
	
	
	
<!-- 	<form action="dammiListaAttori" method="post" >
	<input type="text" name="tit"/>
	 <input class="btn btn-primary"
			type="submit" value="vai agli attori di quel film">
	</form>
	
		<form action="dammiCostoFilmAttore" method="post" >
	<input type="text" name="nome_attore"/>
	 <input class="btn btn-primary"
			type="submit" value="vai agli attori con il costo dei suoi film">
	</form>
	
	-->
	
	
	
	
	
	
	
	<center>
	<h3>Lista Films</h3></center>
	<!-- attributo di public String filmjsp nel controller -->
<c:if test="${!empty listFilms}">
	<table class="table table-dark table-striped">
	<tr>
		<th>Film ID</th>
		<th>titolo</th>
		<th>costo</th>
	</tr>
	<c:forEach items="${listFilms}" var="f">
		<tr>
			<td>${f.id}</td>
			<td>${f.titolo}</td>
			<td>${f.costo}</td>
			<td>
				<form action="dammiListaAttori" method="post" >
						<input type="hidden" name="tit" value="${f.titolo}"/>
	 					<input class="btn btn-primary" type="submit" value="vai agli attori di questo film">
				</form>
		</tr>
	</c:forEach>
	</table>
</c:if>

<br><hr><br>

	<h3>Lista Attori</h3></center>
<c:if test="${!empty listFilmAttori}">
	<table class="table table-dark table-striped">
	<tr>
		<th>id</th>
		<th>nome attore</th>
		<th>titolo film</th>
		<th>costo film</th>
	</tr>
	<c:forEach items="${listFilmAttori}" var="j">
		<tr>
			<td>${j.id_film_actor}</td>
				<td>${j.actor.name}</td>
			<td>${j.film.titolo}</td>
			<td>${j.film.costo}</td>
			<td>
				<form action="dammiCostoFilmAttore" method="post" >
				<input type="hidden" name="nome_attore" value="${j.actor.name}"/>
	 			<input class="btn btn-primary" type="submit" value="vedi i guadagni dell'attore">
				</form>
			</td>
			
				</tr>
	</c:forEach>
	</table>
</c:if>

	
	</div>
</body>
</html>