/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpe.recife.reservasalas.controllers;

/**
 *
 * @author giovannaflo
 */
import br.edu.ifpe.recife.reservasalas.model.entities.*;
import br.edu.ifpe.recife.reservasalas.model.repositories.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/AulaCadastro")
public class AulaCadastroController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("professorLogado") == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }
        request.setAttribute("salas", SalaRepository.findAll());
        request.getRequestDispatcher("/reserva.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Professor professor = (Professor) request.getSession().getAttribute("professorLogado");
        if (professor == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }
        try {
            int salaId = Integer.parseInt(request.getParameter("salaId"));
            LocalDate data = LocalDate.parse(request.getParameter("data"));
            LocalTime hora = LocalTime.parse(request.getParameter("hora"));
            int duracao = Integer.parseInt(request.getParameter("duracao"));
            Sala sala = SalaRepository.findById(salaId);
            if (sala == null || duracao <= 0 || data.isBefore(LocalDate.now())) {
                request.setAttribute("erro", "Confira a sala, a data e a duração.");
            } else {
                Aula aula = new Aula(0, data, hora, duracao, professor, sala);
                if (AulaRepository.temConflito(aula)) {
                    request.setAttribute("erro", "Esta sala já está reservada nesse horário.");
                } else {
                    AulaRepository.create(aula);
                    response.sendRedirect(request.getContextPath() + "/Inicio");
                    return;
                }
            }
        } catch (RuntimeException e) {
            request.setAttribute("erro", "Dados inválidos. Confira o formulário.");
        }
        request.setAttribute("salas", SalaRepository.findAll());
        request.getRequestDispatcher("/reserva.jsp").forward(request, response);
    }
}
