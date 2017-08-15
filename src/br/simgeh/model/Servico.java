/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.model;

/**
 *
 * @author Michel Perilo
 */
public abstract class Servico {
    private int protuario_id;
    private Medico medico; 
    

    public Servico(){
        
    }
    

    /**
     * @return the protuario_id
     */
    public int getProtuario_id() {
        return protuario_id;
    }

    /**
     * @param protuario_id the protuario_id to set
     */
    public void setProtuario_id(int protuario_id) {
        this.protuario_id = protuario_id;
    }
    
}
