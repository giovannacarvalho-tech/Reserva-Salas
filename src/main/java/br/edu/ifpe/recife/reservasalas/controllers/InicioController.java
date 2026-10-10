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
import br.edu.ifpe.recife.reservasalas.model.repositories.AulaRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/Inicio")
public class InicioController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Professor p = (Professor) request.getSession().getAttribute("professorLogado");
        if (p == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }
        request.setAttribute("aulas", AulaRepository.findByProfessor(p.getSiape()));
        request.getRequestDispatcher("/inicio.jsp").forward(request, response);
    }
}
