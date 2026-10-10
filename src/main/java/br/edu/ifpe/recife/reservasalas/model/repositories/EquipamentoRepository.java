/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpe.recife.reservasalas.model.repositories;

/**
 *
 * @author giovannaflo
 */
import br.edu.ifpe.recife.reservasalas.model.entities.Equipamento;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoRepository {
    private static final List<Equipamento> equipamentos = new ArrayList<>();
    private static int proximoId = 3;
    static {
        equipamentos.add(new Equipamento(1, "Projetor", "Epson", "Audiovisual", "Apresentar slides"));
        equipamentos.add(new Equipamento(2, "Notebook", "Dell", "Informática", "Aulas"));
    }
    public static synchronized void create(Equipamento e) { e.setId(proximoId++); equipamentos.add(e); }
    public static synchronized List<Equipamento> findAll() { return new ArrayList<>(equipamentos); }
    public static synchronized Equipamento findById(int id) {
        for (Equipamento e : equipamentos) if (e.getId() == id) return e;
        return null;
    }
    public static synchronized void update(Equipamento novo) {
        Equipamento antigo = findById(novo.getId());
        if (antigo != null) {
            antigo.setNome(novo.getNome()); antigo.setMarca(novo.getMarca());
            antigo.setTipo(novo.getTipo()); antigo.setUtilidade(novo.getUtilidade());
        }
    }
    public static synchronized void delete(int id) { equipamentos.removeIf(e -> e.getId() == id); }
}
