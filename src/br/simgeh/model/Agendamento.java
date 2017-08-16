/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.model;

import java.util.Date;


/**
 *
 * @author Michel Perilo
 */
public class Agendamento {
    private int prontuario_id;
    private String data;
    private String hora;
    private Servico servico;
    
    
    public Agendamento(int prontuario_id, String data, String hora, Servico servico ){
        this.prontuario_id = prontuario_id;
        this.data = data;
        this.hora = hora;
        this.servico = servico;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the servico
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    /**
     * @return the prontuario_id
     */
    public int getProntuario_id() {
        return prontuario_id;
    }

    /**
     * @param prontuario_id the prontuario_id to set
     */
    public void setProntuario_id(int prontuario_id) {
        this.prontuario_id = prontuario_id;
    }
   
     /**
     * @return the medico
     */
   
}
