/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.model;

import java.io.Serializable;

/**
 *
 * @author BARTOLOMEU.DIAS
 */
public class Endereco implements Serializable{
    private String cidade;
    private String bairro;
    private String logradouro;
    private int numero;
    
    public Endereco(String cidade, String bairro, String logradouro, int numero){
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
