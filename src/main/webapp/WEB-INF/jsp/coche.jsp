<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
 .fila{          display: flex;
    
    justify-content: center;
   
    margin-top: 3%    }
 footer{    display: flex;    justify-content: center;   height: 100px;    align-items: center;    background: currentColor;}
 footer h2{   color:white;}
 .columna div{ padding:5px;}
</style>
<body>
<spring:url value="/concesionario/coches" var="coches"></spring:url>
<header>
		<h1>CONCESIONARIO BILBAO</h1>
</header>
<div class="container contenedor">
		<h2>Detalles del Coche</h2>
		<div class="row fila">
			<div class="col-6 columna">
				<div>
					<h5>Coche Matricula: ${coche.matricula}</h5>
					<h6>${coche.marca}</h6>
					<p>${coche.modelo }</p>
					<p>${coche.color }</p>
					<p>Stock: ${coche.stock }</p>
					<p class="btn btn-warning w-100">${coche.precio } Euros</p>
				</div>
			</div>
		</div>
		<a href="${coches}" class="btn btn-secondary">Volver</a>
</div>

<footer>
<h2>ORDOÑO - CURSO TWT BILBAO 2021</h2>
</footer>
</body>
</html>