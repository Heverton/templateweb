<%@include file="../../includes/includes_login.jsp" %>
<%@page session="true"%>

<!DOCTYPE html>
<template_login:template_login>
    <jsp:body>
       
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        
                        <div class="panel-heading">
                            <h3 class="panel-title"><h2>${title}</h2></h3>
                        </div>
                        
                        <div class="panel-body">
                            <form role="form" name='loginForm' action="<c:url value='/login/efetuarlogin' />" method='POST'>
                                <fieldset>

                                    <c:if test="${not empty error}">
                                        <div class="error">${error}</div>
                                    </c:if>
                                    <c:if test="${not empty msg}">
                                        <div class="msg">${msg}</div>
                                    </c:if>

                                    <div class="form-group">
                                        <input class="form-control" placeholder="User" name="username" type="text" autofocus>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                        </label>
                                    </div>

                                    <!-- Change this to a button or input when using this as a form -->
                                    <input class="btn btn-lg btn-success btn-block" name="submit" type="submit"  value="Login" />


                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</template_login:template_login>