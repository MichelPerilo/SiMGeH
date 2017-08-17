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
    private Animal animal;
    private String data;
    private String hora;
    private Servico servico;
    
    
    public Agendamento(Animal animal, String data, String hora, Servico servico ){
        this.animal= animal;
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



    
   
  public String toString(){
      String resultado = this.getServico().toString() + " | " + "Data: "  + this.getData() + " | " + "Hora: " + this.getHora() + " | " + "Paciente :" + this.animal.getNome() + " | " + "Tutor: " + this.animal.getTutor().getNome();
      
      return resultado;
  }

    /**
     * @return the animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * @param animal the animal to set
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
   
}
