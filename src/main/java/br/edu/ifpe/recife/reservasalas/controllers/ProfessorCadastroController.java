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

@WebServlet("/ProfessorCadastro")
public class ProfessorCadastroController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/cadastro-professor.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            int siape = Integer.parseInt(request.getParameter("siape"));
            String nome = request.getParameter("nome").trim();
            String senha = request.getParameter("senha");
            if (nome.isEmpty() || senha == null || senha.isBlank()) {
                request.setAttribute("erro", "Preencha todos os campos.");
                request.getRequestDispatcher("/cadastro-professor.jsp").forward(request, response);
                return;
            }
            if (ProfessorRepository.findBySiape(siape) != null) {
                request.setAttribute("erro", "Já existe um professor com esse SIAPE.");
                request.getRequestDispatcher("/cadastro-professor.jsp").forward(request, response);
                return;
            }
            ProfessorRepository.create(new Professor(siape, nome, senha));
            response.sendRedirect(request.getContextPath() + "/Login?cadastro=ok");
        } catch (NumberFormatException e) {
            request.setAttribute("erro", "O SIAPE deve ser numérico.");
            request.getRequestDispatcher("/cadastro-professor.jsp").forward(request, response);
        }
    }
}

