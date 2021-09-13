<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" 
			prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>CRUD JPA BBDD</title>
</head>
<style>
header{
    height: 100px; display: flex; justify-content: center; align-items: center;   background: beige;
    }
h1{color:orangered;}
 .contenedor{    height:500px;   }
 .contenedor h2{   margin: 0 auto;   text-align: center;   }
 .fila{       display: flex;    justify-content: center;    margin-top: 3%;    }
 footer{    display: flex;    justify-content: center;   height: 100px;    align-items: center;    background: currentColor;}
 footer h2{   color:white;}
 th, td {text-align:center;}
 .encabezadoTabla{background: beige; color:black;}
</style>
<body>
<!-- Enlaces -->
 <spring:url value="/concesionario/create" var="create"></spring:url>
	<header>
		<h1>CONCESIONARIO BILBAO</h1>
	</header>
	<div class="container contenedor">
		<h2>LISTADO DE COCHES</h2>
		<div class="row fila">
			<div class="col-8 columna">
				<table class="table table-hover table-dark">
					  <thead class="encabezadoTabla">
					    <tr>
					      <th scope="col">Matricula</th>
					      <th scope="col">Marca</th>
					      <th scope="col">Modelo</th>
					      <th scope="col">PvP</th>
					      <th scope="col">Operaciones</th>
					    </tr>
					  </thead>					  
					  <tbody>
					    <c:forEach items="${coches}" var="coche">
					    	<tr>
						      <th scope="row">${coche.matricula}</th>
						      <td>${coche.marca}</td>
						      <td>${coche.modelo}</td>
						      <td>${coche.precio}</td>
						      <td>
						      	<a href="coche?matricula=${coche.matricula }" class="btn btn-info">Ver</a>
						      	<a href="edit?matricula=${coche.matricula }" class="btn btn-warning">Editar</a>
						      	<a href="destroy?matricula=${coche.matricula }" class="btn btn-danger">X</a>
						      </td>
						    </tr>
					    </c:forEach>
					  </tbody>
					</table>
					<a href="${create}" class="btn btn-success">Nuevo Coche</a>
			</div>
		</div>
	</div>
	
	
	<footer class="footer">
		<h2>ORDOÑO - CURSO TWT BILBAO 2021</h2>
	</footer>
</body>
</html>