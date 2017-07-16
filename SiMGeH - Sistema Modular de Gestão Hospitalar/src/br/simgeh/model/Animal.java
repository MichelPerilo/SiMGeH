/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.model;

/**
 *
 * @author Bartô
 */
public class Animal {
    private int id;
    private String especie;
    private String nome;
    private String sexo;
    private int dta_nascto;
    private float peso;
    private String porte;
    private String pelagem;
    private Tutor tutor;

    public Animal(int id, String especie, String nome, String sexo, int dta_nascto, float peso, String porte, String pelagem, Tutor tutor) {
        this.id = id;
        this.especie = especie;
        this.nome = nome;
        this.sexo = sexo;
        this.dta_nascto = dta_nascto;
        this.peso = peso;
        this.porte = porte;
        this.pelagem = pelagem;
        this.tutor = tutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getDta_nascto() {
        return dta_nascto;
    }

    public void setDta_nascto(int dta_nascto) {
        this.dta_nascto = dta_nascto;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
    
    
}
