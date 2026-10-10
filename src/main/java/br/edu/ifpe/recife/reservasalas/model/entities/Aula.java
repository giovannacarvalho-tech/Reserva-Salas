/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpe.recife.reservasalas.model.entities;

/**
 *
 * @author giovannaflo
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Aula {
    private int id;
    private LocalDate data;
    private LocalTime hora;
    private int duracao;
    private Professor professor;
    private Sala sala;
    private List<ItemEquipamento> itensEquipamento = new ArrayList<>();

    public Aula() {}
    public Aula(int id, LocalDate data, LocalTime hora, int duracao, Professor professor, Sala sala) {
        this.id = id; 
        this.data = data; 
        this.hora = hora; 
        this.duracao = duracao;
        this.professor = professor; 
        this.sala = sala;
    }
    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }
    public LocalDate getData() { 
        return data; 
    }
    public void setData(LocalDate data) { 
        this.data = data; 
    }
    public LocalTime getHora() { 
        return hora; 
    }
    public void setHora(LocalTime hora) { 
        this.hora = hora; 
    }
    public int getDuracao() { 
        return duracao; 
    }
    public void setDuracao(int duracao) { 
        this.duracao = duracao; 
    }
    public Professor getProfessor() { 
        return professor; 
    }
    public void setProfessor(Professor professor) { 
        this.professor = professor; 
    }
    public Sala getSala() { 
        return sala; 
    }
    public void setSala(Sala sala) { 
        this.sala = sala; 
    }
    public List<ItemEquipamento> getItensEquipamento() { 
        return itensEquipamento; 
    }
    public void setItensEquipamento(List<ItemEquipamento> itensEquipamento) { 
        this.itensEquipamento = itensEquipamento; 
    }
}
