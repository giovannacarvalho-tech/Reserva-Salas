/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpe.recife.reservasalas.controllers;

/**
 *
 * @author giovannaflo
 */
import br.edu.ifpe.recife.reservasalas.model.entities.Equipamento;
import br.edu.ifpe.recife.reservasalas.model.repositories.EquipamentoRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/Equipamentos")
public class EquipamentoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if ("excluir".equals(acao)) {
            try { EquipamentoRepository.delete(Integer.parseInt(request.getParameter("id"))); } catch (Exception ignored) {}
            response.sendRedirect(request.getContextPath() + "/Equipamentos");
            return;
        }
        request.setAttribute("equipamentos", EquipamentoRepository.findAll());
        request.getRequestDispatcher("/equipamentos.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String acao = request.getParameter("acao");
            int id = request.getParameter("id") == null || request.getParameter("id").isBlank()
                    ? 0 : Integer.parseInt(request.getParameter("id"));
            Equipamento e = new Equipamento(id, request.getParameter("nome"), request.getParameter("marca"),
                    request.getParameter("tipo"), request.getParameter("utilidade"));
            if ("editar".equals(acao)) EquipamentoRepository.update(e); else EquipamentoRepository.create(e);
            response.sendRedirect(request.getContextPath() + "/Equipamentos");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Dados inválidos para equipamento.");
        }
    }
}
