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
public class ExameImagem extends Exame {
    
    
    public ExameImagem(Medico medico, Animal animal, Requisicao requisicao){
        super(medico, animal, requisicao);
    }
    
    public void setMedico(Medico m){
        this.medico = m;
    }
    
    public Medico getMedico(){
        return this.medico;
    }
    
    public void setAnimal(Animal a){
        this.animal = a;
    }
    
    public Animal getAnimal(){
        return this.animal;
    }
    
    public void setRequisicao(Requisicao r){
        this.requisicao = r;
    }
    
    public Requisicao getRequisicao(){
        return this.requisicao;
    }
}
