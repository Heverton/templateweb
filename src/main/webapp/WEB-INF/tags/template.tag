<%@tag description="template" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ attribute name="title" fragment="true" %>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="footer" fragment="true" %>

<jsp:useBean id="data" class="java.util.Date"/>
<jsp:useBean id="appinfo" class="br.com.templateweb.spring.util.AppInfo"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Heverton da Silva Cruz">

        <title>::  <jsp:invoke fragment="title"/> ::</title>

        <!-- CSS Padrão -->
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

    </head>
    <body>
        <div id="container">
            <div id="header">
                <jsp:invoke fragment="header"/>
            </div>
            <div id="body">
                <jsp:doBody/>
            </div>
            <div id="footer">
                <jsp:invoke fragment="footer"/>
                <hr/>
                <div style="text-align:center;">
                    <spring:message code="label.idioma"/>: <a href="?lang=en"><spring:message code="label.ingles"/></a> | <a
                        href="?lang=pt_BR"><spring:message code="label.portugues"/></a>
                    <br/>
                    <br/>
                    &#169; <fmt:formatDate pattern="yyyy" value="${data}"/> Heverton Cruz
                    <br/>
                    <code>
                        ${appinfo.bundle.getString("app.nome")} - ${appinfo.bundle.getString("app.desc")} - ${appinfo.bundle.getString("app.versao")}
                    </code>
                </div>
            </div>
        </div>

    </body>
</html>