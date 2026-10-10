/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpe.recife.reservasalas.model.repositories;

/**
 *
 * @author giovannaflo
 */
import br.edu.ifpe.recife.reservasalas.model.entities.Sala;
import java.util.ArrayList;
import java.util.List;

public class SalaRepository {
    private static final List<Sala> salas = new ArrayList<>();
    private static int proximoId = 3;
    static {
        salas.add(new Sala(1, "Sala 101", "Bloco A", 30, "Aula"));
        salas.add(new Sala(2, "Laboratório 02", "Bloco B", 25, "Laboratório"));
    }
    public static synchronized void create(Sala s) { s.setId(proximoId++); salas.add(s); }
    public static synchronized List<Sala> findAll() { return new ArrayList<>(salas); }
    public static synchronized Sala findById(int id) {
        for (Sala s : salas) if (s.getId() == id) return s;
        return null;
    }
    public static synchronized void update(Sala nova) {
        Sala antiga = findById(nova.getId());
        if (antiga != null) {
            antiga.setNome(nova.getNome()); antiga.setLocalizacao(nova.getLocalizacao());
            antiga.setCapacidade(nova.getCapacidade()); antiga.setTipo(nova.getTipo());
        }
    }
   
    public static synchronized void delete(int id) { 
        salas.removeIf(s -> s.getId() == id); 
    }
}