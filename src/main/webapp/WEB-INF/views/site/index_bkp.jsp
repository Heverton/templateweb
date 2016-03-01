
<%@include file="../../includes/includes.jsp" %>

<!DOCTYPE html>
<template:template>

    <jsp:body>

        <h1>Opções de Direcionamento de Pagina</h1>
        <h2>${title}</h2>
        <h2>${message}</h2>  
        
        <!-- Controle de Pagina -->
        <br><br>
        <a href="<c:url value="/site/institucional"/>">Instituciona!</a> 
        <br><br>
        <a href="<c:url value="/site/galeria"/>">Galeria!</a> 
        
        <!-- Crud Básico -->
        <br><br>
        <a href="<c:url value="/login/"/>">Login!</a> 
        <br><br>
        <a href="<c:url value="/usuario/listar"/>">Listar Usuario</a> 
        
    </jsp:body>
</template:template>
