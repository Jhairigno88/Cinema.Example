<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="resources/css/miocss.css" />
</head>
<body>
<div class="container" style="padding-top:3%">
<div class="row">
<div class="col-md-2">
<!--semplice redirect -->
<form action="filmjsp" method="post">
	 <input class="btn btn-primary"
			type="submit" value="vai ai film">
	</form>
	</div>
	<!-- Button to Open the Modal   cerca attore con iniziali  
	i modal sono dichiarati a fine pagina-->
	<div class="col-md-2">
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
  cerca attori
</button>
</div>
<div class="col-md-2">
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal2">
  cerca quanti ajax
</button>
</div>
</div> 

  <!-- inizio div form inserimento -->
	<div style=padding-top:30px  >
<h1>
	Add a Person
</h1>



<c:url var="addAction" value="/person/add" ></c:url>

<form:form action="${addAction}" commandName="person">
<table>
	<c:if test="${!empty person.name}">
	<tr>
		<td>
			<form:label path="id_act">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id_act" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id_act" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="lastName">
				<spring:message text="lastName"/>
			</form:label>
		</td>
		<td>
			<form:input path="lastName" />
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty person.name}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty person.name}">
				<input type="submit"
					value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
</div>    <!-- fine div col form inserimento -->
  <!-- fine div row -->
</div>  <!-- fine div container prima riga  -->

<hr>


<br>
<div class="container">
<h3>Persons List</h3>
<c:if test="${!empty listPersons}">
	<table class="table table-dark table-striped">
	<tr>
		<th width="80">Person ID</th>
		<th width="120">Person Name</th>
		<th width="120">Person LastName</th>
		<th width="60">Modifica</th>
		<th width="60">Cancella</th>
	</tr>
	<c:forEach items="${listPersons}" var="person">
		<tr>
			<td>${person.id_act}</td>
			<td>${person.name}</td>
			<td>${person.lastName}</td>
				<td><a href="<c:url value='/edit/${person.id_act}' />" ><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"> MODIFICA </button>
		</a></td>
			<td><a href="<c:url value='/remove/${person.id_act}' />" ><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"> ELIMINA </button></a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</div>


<!-- inizio modal -->

<!-- Modal cerca attori -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">CERCA ATTORI CHE HANNO COME INIZIALI DEL NOME</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      	<!-- nel controller c'è  
      		@RequestMapping(value = "/inizialiNomeAttore", method = RequestMethod.POST)
	public String user(String iniziali, Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.cercaAttoreConIniziali(iniziali));
		return "person";
	}
	-->
        <form action="inizialiNomeAttore" method="post">
		<input type="text" name="iniziali"><br> <input
			type="submit" value="cerca">
	</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">CHIUDI</button>
      </div>

    </div>
  </div>
</div>




<!-- Modal ajax QUANTI ATTORI HANNO IL NOME CHE INIZIA PER ... -->
<div class="modal" id="myModal2">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">QUANTI ATTORI HANNO IL NOME CHE INIZIA PER</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
     <input type="text" class="form-control" id="iniziali2" name="iniziali2">
      <button id="b1" type="button" class="btn btn-primary" >
  cerca quanti sono
</button>
<h2 id="stampa1">a</h2>
      </div>

      <!-- Modal footer     ${pageContext.request.contextPath}/ajax/-->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">CHIUDI</button>
      </div>

    </div>
  </div>
</div>

<form action="ajaxjsp" method="get">
	 <input class="btn btn-primary" type="submit" value="Gioca con Ajax">
</form>

<script type="text/javascript">
$(document).ready(function(){
$('#b1').click(function(){
	var iniziali2 = $('#iniziali2').val();
   $.ajax({
     type:'GET',
     url:'demo2/'+ iniziali2 +'.html',
     success:function(result){
    	 $('#stampa1').html(result);
     }
     
    });
 });
});
</script>
</body>
</html>
