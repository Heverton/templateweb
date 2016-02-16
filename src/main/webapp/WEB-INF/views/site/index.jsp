
<%@include file="../../includes/includes.jsp" %>

<!DOCTYPE html>
<template:template>

    <jsp:body>

        <h1>Opções de Direcionamento de Pagina</h1>
        <h2>${title}</h2>
        <h2>${message}</h2>  
        <br>
        <br>
        <a href="<c:url value="/site/paginstitucional"/>">Instituciona!</a> 
        <br>
        <br>
        <a href="<c:url value="/site/paggaleria"/>">Galeria!</a> 
        <br>
        <br>
        <a href="<c:url value="/login/"/>">Login!</a> 

    </jsp:body>
</template:template>
