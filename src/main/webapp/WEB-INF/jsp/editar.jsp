<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
 .contenedor{    height:700px;   }
 .contenedor h2{   margin: 0 auto;   text-align: center;   }
 .fila{       display: flex;    justify-content: center;    margin-top: 3%;    }
 footer{    display: flex;    justify-content: center;   height: 100px;    align-items: center;    background: currentColor;}
 footer h2{   color:white;}
</style>
<body>
<spring:url value="/concesionario/coches" var="coches"></spring:url>
<header><h1>CONCESIONARIO BILBAO</h1></header>
	<div class="container contenedor">
		<h2>EDITAR PRODUCTO</h2>
		<div class="row fila">
			<div class="col-6 columna">
				 <form:form  method="POST" modelAttribute="cocheEditado"  class="form-horizontal"> 
		                
		                	<div class="form-group">			                    	
		                    		<label>Matricula </label>                       	
		                            <form:input id="id" path="matricula"  type="text" class="form-control"/>  			                    		       
		                    		<form:errors path="matricula" cssClass="text-danger" />
		                    </div>
		                    <div class="form-group">                                            		                       
		                         	<label>Marca</label>
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
		                        <input type="submit" id="btnCrear" class="btn btn-success" value ="GUARDAR"/> 
		                    </div> 	              
		            </form:form>
			</div>
			
		</div>
		
	</div>
	<a href="${coches}" class="btn btn-secondary m-5">Volver</a>
	<footer>
		<h2>ORDOÑO - CURSO TWT BILBAO 2021</h2>
	</footer>
</body>
</html>