/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpe.recife.reservasalas.model.repositories;

/**
 *
 * @author giovannaflo
 */
import br.edu.ifpe.recife.reservasalas.model.entities.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private static final List<Professor> professores = new ArrayList<>();
    static { professores.add(new Professor(123, "Professor Teste", "123")); }

    public static synchronized void create(Professor p) { professores.add(p); }
    public static synchronized List<Professor> findAll() { return new ArrayList<>(professores); }
    public static synchronized Professor findBySiape(int siape) {
        for (Professor p : professores) if (p.getSiape() == siape) return p;
        return null;
    }
}
