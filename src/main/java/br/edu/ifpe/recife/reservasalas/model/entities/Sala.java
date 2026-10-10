package br.edu.ifpe.recife.reservasalas.model.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author giovannaflo
 */
public class Sala {
    private int id;
    private String nome;
    private String localizacao;
    private int capacidade;
    private String tipo;

    public Sala() {}
    public Sala(int id, String nome, String localizacao, int capacidade, String tipo) {
        this.id = id; 
        this.nome = nome; 
        this.localizacao = localizacao;
        this.capacidade = capacidade; 
        this.tipo = tipo;
    }
    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }
    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    public String getLocalizacao() { 
        return localizacao; 
    }
    public void setLocalizacao(String localizacao) { 
        this.localizacao = localizacao; 
    }
    public int getCapacidade() { 
        return capacidade; 
    }
    public void setCapacidade(int capacidade) { 
        this.capacidade = capacidade; 
    }
    public String getTipo() { 
        return tipo; 
    }
    public void setTipo(String tipo) { 
        this.tipo = tipo; 
    }
}
