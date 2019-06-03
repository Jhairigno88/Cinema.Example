<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<div>
			<input type="text" class="form-control" id="parola" name="parola">
				<button id="cambiaParola" type="button" class="btn btn-primary" >
			  		Cambia parola con Ajax
				</button>
			<h2 id="stampa">Parola da cambiare</h2>
		
		</div>
		
		<div>
		
			<table id = "tabella" border = "1">
				<tr>
					<th width="120">Nome</th>
				</tr>	
					<c:forEach items="${listPersons}" var="person">
						<tr>
							<td>${person.name}</td>
						</tr>
					</c:forEach>
			</table>
			
			<button id="cambiaTabella" type="button" class="btn btn-primary" >
			  		Cancella tabella con Ajax
			</button>
		
		</div>
		
		<div>
			<br>
			
				<select class='form-control' style = 'width:150px; display:inline;' id = "scegli" name = 'scegli'>
					<option value = 'blank'></option>
					<option value = 'persone'>Persone</option>
				</select>
				<select class='form-control' style = 'width:150px; display:inline;' id = "persone" name = 'persone'>
					<option value = 'blank'></option>
				</select>
				<br>

		</div>
		
		<div>
			<br>
			
			<table id = "tabellaAjax" border = "1">
				<tr>
					<th width="120">ID</th>
					<th width="120">Nome</th>
				</tr>				
			</table>
			
			<br>
			
			<button id="creaTabella" type="button" class="btn btn-primary" >
			  	Riempi tabella con Ajax
			</button>

		</div>		
	
		<script type="text/javascript">
		
			$(document).ready(function() {
				
			$('#cambiaParola').click(function(){
				var parola = $('#parola').val();
			   $.ajax({
			     type:'GET',
			     url:'cambia/'+ parola +'',
			     success:function(result){
			    	 $('#stampa').html(result);
			     }			     
			    });
			 });
			
			$('#cambiaTabella').click(function(){
			   $.ajax({
			     type:'GET',
			     success:function(result){
			    	 $('#tabella').empty();			     
			    }
			 });
			});
			
			$("#scegli").change(function(){
				scelta = $("#scegli").val();
				$.ajax({
						url : "riempiSelect",
						type:"POST",
						data : {scelta : scelta},
						success: function(data){
							if (data!="vuoto"){
								var myObj = JSON.parse(data);
									myObj.forEach(function(value) {
										var $option=$("<option></option>").val(value).text(value);
										$("#persone").append($option);
									});
							}
							else
							{
								$("#persone").empty();
								var $option=$("<option></option>").val("blank");
								$("#persone").append($option);	
							}
						}
				});
			});
			
			$("#creaTabella").click(function(){
				$.ajax({
						url : "creaTabella",
						type:"POST",
						success: function(data){
								var myObj = JSON.parse(data);
									myObj.forEach(function(value) {
										$("#tabellaAjax").append("<tr><td>" + value.id_persona + "</td><td>" + value.nome_persona +"</td></tr>");
									});
						}
				});
			});			
		  });
		</script>
	</body>
</html>