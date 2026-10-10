<%-- 
    Document   : equipamentos
    Created on : 9 de out. de 2026, 13:56:39
    Author     : giovannaflo
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List,br.edu.ifpe.recife.reservasalas.model.entities.Equipamento" %>
<% List<Equipamento> equipamentos = (List<Equipamento>) request.getAttribute("equipamentos"); %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head><meta charset="UTF-8">
        <title>Equipamentos</title>
        <style>
            body{font-family:Arial;margin:30px}
            input{padding:7px;margin:4px}
            table{border-collapse:collapse;width:100%;margin-top:20px}
            td,th{border:1px solid #ccc;padding:8px}
        </style>
    </head>
    <body>
        <h1>Cadastro de equipamentos</h1>
        <form method="post" action="<%=request.getContextPath()%>/Equipamentos">
            <input type="hidden" name="acao" value="criar">
            <input name="nome" placeholder="Nome" required>
            <input name="marca" placeholder="Marca" required>
            <input name="tipo" placeholder="Tipo" required>
            <input name="utilidade" placeholder="Utilidade" required>
            <button type="submit">Cadastrar equipamento</button>
        </form>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Marca</th>
                <th>Tipo</th>
                <th>Utilidade</th>
                <th>Ação</th>
            </tr>
            <% for(Equipamento e: equipamentos){ %>
            <tr>
                <td><%=e.getId()%></td>
                <td><%=e.getNome()%></td>
                <td><%=e.getMarca()%></td>
                <td><%=e.getTipo()%></td>
                <td><%=e.getUtilidade()%></td>
                <td>
                    <form method="post" action="<%=request.getContextPath()%>/Equipamentos">
                        <input type="hidden" name="acao" value="editar">
                        <input type="hidden" name="id" value="<%=e.getId()%>">
                        <input name="nome" value="<%=e.getNome()%>" required>
                        <input name="marca" value="<%=e.getMarca()%>" required>
                        <input name="tipo" value="<%=e.getTipo()%>" required>
                        <input name="utilidade" value="<%=e.getUtilidade()%>" required>
                        <button type="submit">Salvar edição</button>
                    </form>
                    <a href="<%=request.getContextPath()%>/Equipamentos?acao=excluir&id=<%=e.getId()%>" onclick="return confirm('Excluir equipamento?')">Excluir</a>
                </td>
            </tr>
            <% } %>
        </table>
        <a href="<%=request.getContextPath()%>/Inicio">Voltar</a>
    </body>
</html>

