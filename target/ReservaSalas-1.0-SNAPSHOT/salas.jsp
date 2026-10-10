<%-- 
    Document   : salas
    Created on : 8 de out. de 2026, 14:25:13
    Author     : giovannaflo
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List,br.edu.ifpe.recife.reservasalas.model.entities.Sala" %>
<% List<Sala> salas = (List<Sala>) request.getAttribute("salas"); %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head><meta charset="UTF-8">
        <title>Salas</title>
        <style>
            body{font-family:Arial;margin:30px}
            input{padding:7px;margin:4px}
            table{border-collapse:collapse;width:100%;margin-top:20px}
            td,th{border:1px solid #ccc;padding:8px}
        </style>
    </head>
    <body>
        <h1>Cadastro de salas</h1>
        <form method="post" action="<%=request.getContextPath()%>/Salas">
            <input type="hidden" name="acao" value="criar">
            <input name="nome" placeholder="Nome da sala" required>
            <input name="localizacao" placeholder="Localização" required>
            <input type="number" name="capacidade" placeholder="Capacidade" min="1" required>
            <input name="tipo" placeholder="Tipo" required>
            <button type="submit">Cadastrar sala</button>
        </form>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Localização</th>
                <th>Capacidade</th>
                <th>Tipo</th>
                <th>Ação</th>
            </tr>
            <% for(Sala s: salas){ %>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getNome()%></td>
                <td><%=s.getLocalizacao()%></td>
                <td><%=s.getCapacidade()%></td>
                <td><%=s.getTipo()%></td>
                <td>
                    <form method="post" action="<%=request.getContextPath()%>/Salas">
                        <input type="hidden" name="acao" value="editar">
                        <input type="hidden" name="id" value="<%=s.getId()%>">
                        <input name="nome" value="<%=s.getNome()%>" required>
                        <input name="localizacao" value="<%=s.getLocalizacao()%>" required>
                        <input type="number" name="capacidade" value="<%=s.getCapacidade()%>" min="1" required>
                        <input name="tipo" value="<%=s.getTipo()%>" required>
                        <button type="submit">Salvar edição</button>
                    </form>
                    <a href="<%=request.getContextPath()%>/Salas?acao=excluir&id=<%=s.getId()%>" onclick="return confirm('Excluir sala?')">Excluir</a>
                </td>
            </tr>
            <% } %>
        </table>
        <a href="<%=request.getContextPath()%>/Inicio">Voltar</a>
    </body>
</html>

