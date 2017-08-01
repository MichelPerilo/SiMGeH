/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.model;

/**
 *
 * @author Bartô
 */
public class Tutor  {            //TUTOR NÃO ESTENDE PESSOA
    private String nome;
    private String cpf;
    private Endereco endereco;
    private String fone_1;
    private String fone_2;
    
   public Tutor(String nome, String cpf, Endereco endereco, String fone_1, String fone_2){
       this.nome = nome;
       this.cpf = cpf;
       this.endereco = endereco;
       this.fone_1 = fone_1;
       this.fone_2 = fone_2;
   }
   
   
}
