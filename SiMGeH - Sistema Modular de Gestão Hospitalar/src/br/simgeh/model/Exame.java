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
public abstract class Exame extends Servico{
    
    Medico medico;
    Animal animal;
    Requisicao requisicao;
    
    public Exame(Medico medico, Animal animal, Requisicao requisicao){
        this.medico = medico;
        this.animal = animal;
        this.requisicao = requisicao;
    }
}
