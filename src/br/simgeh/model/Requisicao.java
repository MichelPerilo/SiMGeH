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
public abstract class Requisicao {
    private int prontuario_id;
    private int ID;
    private int status;              /*
                                        1 - Não avaliada 
                                        2 - Em andamento
                                        3 - Rejeitada 
                                        4 - Finalizada
                                                        */
    private String justificativa; //Caso Rejeitada
  
}
