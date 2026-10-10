/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpe.recife.reservasalas.controllers;

/**
 *
 * @author giovannaflo
 */
import br.edu.ifpe.recife.reservasalas.model.entities.Professor;
import br.edu.ifpe.recife.reservasalas.model.repositories.ProfessorRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int siape = Integer.parseInt(request.getParameter("siape"));
            String senha = request.getParameter("senha");
            Professor p = ProfessorRepository.findBySiape(siape);
            if (p != null && p.getSenha().equals(senha)) {
                request.getSession(true).setAttribute("professorLogado", p);
                response.sendRedirect(request.getContextPath() + "/Inicio");
            } else {
                request.setAttribute("erro", "SIAPE ou senha inválidos.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("erro", "Informe um SIAPE válido.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
