/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpe.recife.reservasalas.model.entities;

/**
 *
 * @author giovannaflo
 */

public class Professor {

    private int siape;
    private String nome;
    private String senha;

    public Professor() {
    }
    public Professor(int siape, String nome, String senha) {
        this.siape = siape;
        this.nome = nome;
        this.senha = senha;
    }
    public int getSiape() {
        return siape;
    }
    public void setSiape(int siape) {
        this.siape = siape;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}