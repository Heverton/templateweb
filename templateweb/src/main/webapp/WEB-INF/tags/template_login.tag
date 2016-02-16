<%@tag description="template_login" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ attribute name="title" fragment="true" %>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Heverton da Silva Cruz">

        <title>:: <jsp:invoke fragment="title"/> ::</title>

        <!-- Bootstrap Core CSS -->
        <link href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet" />

        <!-- MetisMenu CSS -->
        <link href="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.css" />" rel="stylesheet" />

        <!-- Timeline CSS -->
        <link href="<c:url value="/resources/bower_components/sb-admin/css/timeline.css" />" rel="stylesheet" />

        <!-- Custom CSS -->
        <link href="<c:url value="/resources/bower_components/sb-admin/css/sb-admin-2.css" />" rel="stylesheet" />

        <!-- Custom Fonts -->
        <link href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

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
            </div>
        </div>

        <!-- /#wrapper -->
        <!-- jQuery -->
        <script src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js" />" type="text/javascript" /></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js" />" type="text/javascript" /></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.js" />" type="text/javascript" /></script>

        <!-- Morris Charts JavaScript -->
        <script src="<c:url value="/resources/bower_components/raphael/raphael-min.js" />" type="text/javascript" /></script>
        <script src="<c:url value="/resources/bower_components/morrisjs/morris.min.js" />" type="text/javascript" /></script>
        <script src="<c:url value="/resources/bower_components/js/morris-data.js" />" type="text/javascript" /></script>

        <!-- Custom Theme JavaScript -->
        <script src="<c:url value="/resources/bower_components/sb-admin/js/sb-admin-2.js" />" type="text/javascript" ></script>

    </body>
</html>