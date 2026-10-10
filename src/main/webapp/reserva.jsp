<%-- 
    Document   : reserva
    Created on : 7 de out. de 2026, 22:55:15
    Author     : giovannaflo
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List,br.edu.ifpe.recife.reservasalas.model.entities.Sala" %>
<%
List<Sala> salas = (List<Sala>) request.getAttribute("salas");
%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head><meta charset="UTF-8">
        <title>Reservar sala</title>
        <style>
            body{font-family:Arial;max-width:520px;margin:35px auto}
            input,select,button{box-sizing:border-box;width:100%;padding:10px;margin:7px 0}
            .erro{color:#b00020}
        </style>
    </head>
    <body>
        <h1>Reservar sala</h1>
        <% if (request.getAttribute("erro") != null) { %>
            <p class="erro"><%= request.getAttribute("erro") %></p>
        <% } %>
            <form method="post" action="<%= request.getContextPath() %>/AulaCadastro">
                <label>Sala</label>
                <select name="salaId" required>
                    <% if (salas != null) 
                       for (Sala s : salas) { %>
                    <option 
                        value="<%= s.getId() %>"><%= s.getNome() %> - <%= s.getLocalizacao() %> 
                        (capacidade: <%= s.getCapacidade() %>)
                    </option>
                    <% } %>
                </select>
                <label>Data</label><input type="date" name="data" required>
                <label>Horário</label><input type="time" name="hora" required>
                <label>Duração em minutos</label><input type="number" name="duracao" min="1" value="60" required>
                <button type="submit">Confirmar reserva</button>
            </form>
        <a href="<%= request.getContextPath() %>/Inicio">Voltar</a>
    </body>
</html>