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
public class Prontuario {                                 
    private int ID;
    private Animal animal;
    
                                                             /* A relação do prontuário com as requisições
                                                                e os serviços é estabelecida em 1 p/ n. 
                                                                Logo, toda requisicicao e todo serviço 
                                                                terá um ID de um prontuário associado */
    
    public Prontuario(Animal animal){
        this.animal = animal;
    }

	public Animal getAnimal() {
		return this.animal;
	}

    /**
     * @return the animal

    /**
     * @param animal the animal to set
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
     
    

    
    
}
