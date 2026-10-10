<%-- 
    Document   : inicio
    Created on : 7 de out. de 2026, 22:55:07
    Author     : giovannaflo
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List,br.edu.ifpe.recife.reservasalas.model.entities.Aula,br.edu.ifpe.recife.reservasalas.model.entities.Professor" %>
<%
Professor professor = (Professor) session.getAttribute("professorLogado");
if (professor == null) { response.sendRedirect(request.getContextPath()+"/Login"); return; }
List<Aula> aulas = (List<Aula>) request.getAttribute("aulas");
%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head><meta charset="UTF-8">
        <title>Minhas reservas</title>
        <style>
            body{font-family:Arial;margin:35px}
            table{border-collapse:collapse;width:100%}
            th,td{border:1px solid #ccc;padding:9px;text-align:left}
            nav a{margin-right:15px}
        </style>
    </head>
    <body>
        <h1>Olá, <%= professor.getNome() %>!</h1>
        <nav>
            <a href="<%= request.getContextPath() %>/AulaCadastro">Reservar sala</a>
            <a href="<%= request.getContextPath() %>/Salas">Gerenciar salas</a>
            <a href="<%= request.getContextPath() %>/Equipamentos">Gerenciar equipamentos</a>
            <a href="<%= request.getContextPath() %>/Logout">Sair</a>
        </nav>
        <h2>Minhas reservas</h2>
        <% if (aulas == null || aulas.isEmpty()) { %>
            <p>Você ainda não possui reservas.</p>
        <% } else { %>
        <table>
            <tr>
                <th>Sala</th>
                <th>Localização</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Duração (minutos)</th>
                <th>Ações</th>
            </tr>
            <% for (Aula a : aulas) { %>
            <tr>
                <td><%= a.getSala().getNome() %></td>
                <td><%= a.getSala().getLocalizacao() %></td>
                <td><%= a.getData() %></td>
                <td><%= a.getHora() %></td>
                <td><%= a.getDuracao() %></td>
                <td>
                    <form action="<%= request.getContextPath() %>/AulaExcluir"
                          method="post"
                          onsubmit="return confirm('Deseja excluir esta reserva?');">
                        <input type="hidden" name="id" value="<%= a.getId() %>">
                        <button type="submit">Excluir reserva</button>
                    </form>
                </td>
            </tr>
            <% } %>
        </table>
        <% } %>
    </body>
</html>

