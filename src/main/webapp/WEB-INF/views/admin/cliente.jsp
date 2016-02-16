
<%@include file="../../includes/includes_admin.jsp" %>
<%@page session="true"%>

<!DOCTYPE html>
<template_admin:template_admin>

    <jsp:body>        
        <!-- /#page-wrapper -->
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Cadastro de Cliente
                        </div>
                        <div class="panel-body">                            
                            <div class="row">
                                <div class="col-lg-6">                                    
                                    <form role="form">
                                        <div class="form-group">
                                            <label>CNPJ:</label>
                                            <input class="form-control">
                                            <p class="help-block">Insire um CNPJ válido.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Razão Social:</label>
                                            <input class="form-control">
                                            <p class="help-block">Campo obrigatório.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Email do Cliente:</label>
                                            <input class="form-control">
                                            <p class="help-block">Insire um CNPJ válido.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Data da Instalação do Sistema:</label>
                                            <input class="form-control">
                                            <p class="help-block">Insire um CNPJ válido.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Dia de Vencimento de Contrato:</label>
                                            <input class="form-control">
                                            <p class="help-block">Insire um CNPJ válido.</p>
                                        </div>

                                        <!-- CONTRATO -->
                                        <div class="form-group">
                                            <label>Dia de Vencimento de Contrato:</label>
                                            <input class="form-control">
                                            <p class="help-block">Insire um CNPJ válido.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Valor do Contrato:</label>
                                            <input class="form-control">
                                            <p class="help-block">Insire um CNPJ válido.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Tipos de Sistemas</label>
                                            <select class="form-control">
                                                <option>HostPDV Simples 1</option>
                                                <option>HostPDV Simples 2</option>
                                                <option>HostPDV Simples 3</option>
                                                <option>HostPDV Simples 4</option>
                                                <option>HostPDV Simples 5</option>
                                            </select>
                                        </div>
                                        <!-- CONTRATO-FIM -->
                                        
                                        <!-- LICENÇA -->
                                        <div class="form-group">
                                            <label>Data de Vencimento da Senha:</label>
                                            <input class="form-control">
                                            <p class="help-block">Insire um CNPJ válido.</p>
                                        </div>
                                        <!-- FIM-LICENÇA -->
                                        
                                        Grid de Registro de ECFs vinculadas ao cliente


                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
        <!-- /#page-wrapper -->

    </jsp:body>
</template_admin:template_admin>
