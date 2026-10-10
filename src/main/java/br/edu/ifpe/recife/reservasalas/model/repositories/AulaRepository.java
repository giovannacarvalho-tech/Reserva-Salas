/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpe.recife.reservasalas.model.repositories;

/**
 *
 * @author giovannaflo
 */
import br.edu.ifpe.recife.reservasalas.model.entities.Aula;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AulaRepository {
    private static final List<Aula> aulas = new ArrayList<>();
    private static int proximoId = 1;

    public static synchronized Aula create(Aula aula) {
        aula.setId(proximoId++);
        aulas.add(aula);
        return aula;
    }
    public static synchronized List<Aula> findAll() { return new ArrayList<>(aulas); }
    public static synchronized List<Aula> findByProfessor(int siape) {
        List<Aula> resultado = new ArrayList<>();
        for (Aula a : aulas) if (a.getProfessor().getSiape() == siape) resultado.add(a);
        return resultado;
    }
    public static synchronized boolean temConflito(Aula nova) {
        LocalDateTime inicioNovo = LocalDateTime.of(nova.getData(), nova.getHora());
        LocalDateTime fimNovo = inicioNovo.plusMinutes(nova.getDuracao());
        for (Aula a : aulas) {
            if (a.getSala().getId() != nova.getSala().getId() || !a.getData().equals(nova.getData())) continue;
            LocalDateTime inicioExistente = LocalDateTime.of(a.getData(), a.getHora());
            LocalDateTime fimExistente = inicioExistente.plusMinutes(a.getDuracao());
            if (inicioNovo.isBefore(fimExistente) && fimNovo.isAfter(inicioExistente)) return true;
        }
        return false;
    }
    public static void delete(int id) {
            aulas.removeIf(aula -> aula.getId() == id);
        } 
}
