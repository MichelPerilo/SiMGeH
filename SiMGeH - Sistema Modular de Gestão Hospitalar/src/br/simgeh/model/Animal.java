/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.model;

import java.util.Date;

/**
 *
 * @author Bartô
 */
public class Animal {
    private String id;
    private String nome;
    private String sexo;
    private String especie;
    private String raca;
    private int dta_nascto;
    private float peso;
    private String porte;
    private String pelagem;
    private Tutor tutor;
    private Date criacao;
    
    

    public Animal(String id, String especie, String nome, String sexo, int dta_nascto, float peso, String porte, String pelagem, Tutor tutor) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public void setEspecie(String especie) {
        this.especie = especie;
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
    
    public boolean equals(Animal a) {
    	if(this.getId().equals(a.getId()))
    		return true;
    	
    	return false;
    }
}
