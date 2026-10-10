<%-- 
    Document   : cadastro-professor
    Created on : 8 de out. de 2026, 22:54:58
    Author     : giovannaflo
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head><meta charset="UTF-8">
        <title>Cadastro de Professor</title>
        <style>
            body{font-family:Arial;max-width:450px;margin:50px auto}
            input,button{box-sizing:border-box;width:100%;padding:10px;margin:7px 0}
            .erro{color:#b00020}
        </style>
    </head>
    <body>
        <h1>Cadastro de Professor</h1>
        <% if (request.getAttribute("erro") != null) { %>
            <p class="erro"><%= request.getAttribute("erro") %></p>
        <% } %>
        <form method="post" action="<%= request.getContextPath() %>/ProfessorCadastro">
            <label>SIAPE</label>
            <input type="number" name="siape" required>
            <label>Nome</label>
            <input type="text" name="nome" required>
            <label>Senha</label>
            <input type="password" name="senha" required>
            <button type="submit">Cadastrar</button>
        </form>
        <a href="<%= request.getContextPath() %>/Login">Voltar ao login</a>
    </body>
</html>
