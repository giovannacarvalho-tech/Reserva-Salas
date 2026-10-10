/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpe.recife.reservasalas.controllers;

/**
 *
 * @author giovannaflo
 */
import br.edu.ifpe.recife.reservasalas.model.entities.Sala;
import br.edu.ifpe.recife.reservasalas.model.repositories.SalaRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/Salas")
public class SalaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if ("excluir".equals(acao)) {
            try { SalaRepository.delete(Integer.parseInt(request.getParameter("id"))); } catch (Exception ignored) {}
            response.sendRedirect(request.getContextPath() + "/Salas");
            return;
        }
        request.setAttribute("salas", SalaRepository.findAll());
        request.getRequestDispatcher("/salas.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String acao = request.getParameter("acao");
            int id = request.getParameter("id") == null || request.getParameter("id").isBlank()
                    ? 0 : Integer.parseInt(request.getParameter("id"));
            Sala s = new Sala(id, request.getParameter("nome"), request.getParameter("localizacao"),
                    Integer.parseInt(request.getParameter("capacidade")), request.getParameter("tipo"));
            if ("editar".equals(acao)) SalaRepository.update(s); else SalaRepository.create(s);
            response.sendRedirect(request.getContextPath() + "/Salas");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Dados inválidos para sala.");
        }
    }
}
