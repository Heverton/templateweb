
<%@include file="../../includes/includes.jsp" %>

<!DOCTYPE html>
<template:template>

    <jsp:body>

        <h2>${title}</h2>
        <h2>${message}</h2>
        
        <c:forEach items="${paginas}" var="pags">
            <h2><spring:message code="label.id"/> = <c:out value="${pags.id}"/></h2>
            <h2><spring:message code="label.nome"/> = <c:out value="${pags.nome}"/></h2>
        </c:forEach>
            
    </jsp:body>
</template:template>
