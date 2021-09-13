<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
 .contenedor{    height:700px;   }
 .contenedor h2{   margin: 0 auto;   text-align: center;   }
 .fila{       display: flex;    justify-content: center;    margin-top: 3%;    }
 footer{    display: flex;    justify-content: center;   height: 100px;    align-items: center;    background: currentColor;}
 footer h2{   color:white;}
</style>
<body>

<header>

		<h1>CONCESIONARIO BILBAO</h1>
</header>
<section>
		<div class="pull-right" style="padding-right: 50px">
			<a href="?language=en">English</a>| <a href="?language=es">Spanish</a>
		</div>
	</section>
	<div class="container contenedor">
		<div class="row fila">
			<div class="col-6 columna">
				 <form:form  method="POST" modelAttribute="nuevoCoche"  class="form-horizontal"> 
		                		<legend>
		                			<spring:message code="coche.alta.titulo" />
		                		</legend>
			                	<div class="form-group">			                    	
			                    		<label> <spring:message code="coche.matricula" /></label>                       	
			                            <form:input id="id" path="matricula"  type="text" class="form-control"/>
			                            <form:errors path="matricula" cssClass="text-danger" />  			                    		       
			                    </div>
			                    <div class="form-group">                                            		                       
			                         	<label><spring:message code="coche.marca" /></label>
			                            <form:input  path="marca" type="text" class="form-control"/> 			                      
			                    </div>		
			                    <div class="form-group"> 		                       			                        
			                         <label >Modelo</label> 
			                            <form:input  path="modelo" type="text" class="form-control"/>			                      
			                    </div> 
			                    <div class="form-group"> 	                        			                       
			                        	<label>Color</label>  
			                            <form:input path="color"   type="text" class="form-control"/> 			                        
			                    </div>				                   
			                    <div class="form-group"> 		                        		                        
			                        	<label>Año </label> 
			                            <form:input path="anio"       type="number" class="form-control"/> 		                       
			                    </div>			                     
			                    <div class="form-group"> 	                         		                        
			                        <label>Precio</label>
			                            <form:input  path="precio"  type="number" class="form-control"/> 		                       
			                    </div>
			               
			                    <div class="form-group mt-3"> 	                         
			                        <input type="submit" id="btnCrear" class="btn btn-success" value ="AÑADIR"/> 
			                    </div> 	              
		            </form:form>
			</div>
		</div>
		<spring:url value="/concesionario/coches" var="coches"></spring:url>
		<a href="${coches}" class="btn btn-warning">VOLVER</a>
	</div>
	<footer>
		<h2>ORDOÑO - CURSO TWT BILBAO 2021</h2>
	</footer>
</body>
</html>