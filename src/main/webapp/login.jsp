<%-- 
    Document   : login
    Created on : 7 de out. de 2026, 22:51:58
    Author     : giovannaflo
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head><meta charset="UTF-8">
        <title>Login - Reserva de Salas</title>
        <style>
            body{font-family:Arial;max-width:420px;margin:60px auto;padding:20px}
            input,button{box-sizing:border-box;width:100%;padding:10px;margin:7px 0} 
            .erro{color:#b00020}
        </style>
    </head>
    <body>
        <h1>Reserva de Salas</h1>
        <h2>Login do professor</h2>
        <% if ("ok".equals(request.getParameter("cadastro"))) { %>
            <p>Cadastro realizado! Entre com seus dados.</p>
        <% } %>
        <% if (request.getAttribute("erro") != null) { %>
            <p class="erro"><%= request.getAttribute("erro") %></p>
        <% } %>
        <form method="post" action="<%= request.getContextPath() %>/Login">
            <label>SIAPE</label><input type="number" name="siape" required>
            <label>Senha</label><input type="password" name="senha" required>
            <button type="submit">Entrar</button>
        </form>
        <p><a href="<%= request.getContextPath() %>/ProfessorCadastro">Cadastrar novo professor</a></p>
        <p>Teste: SIAPE <b>123</b> / senha <b>123</b></p>
    </body>
</html>
