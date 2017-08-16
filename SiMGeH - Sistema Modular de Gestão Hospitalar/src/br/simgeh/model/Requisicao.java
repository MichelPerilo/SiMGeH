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
    int prontuario_id;
    static int IDcont = 0;
    int ID;
    
    String status;              /*
                                        1 - Não avaliada 
                                        3 - Rejeitada 
                                        4 - Finalizada
                                                        */
    String justificativa; //Caso Rejeitada
  
    
  
}
