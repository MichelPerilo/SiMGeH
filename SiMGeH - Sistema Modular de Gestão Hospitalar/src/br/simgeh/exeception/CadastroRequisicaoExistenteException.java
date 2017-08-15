/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.exeception;

/**
 *
 * @author Elal
 */
public class CadastroRequisicaoExistenteException extends Exception{
    
    private String nome;
    public CadastroRequisicaoExistenteException(String nome){
		
	super(nome + " JA ESTA CADASTRADA!!!");
	this.setNome(nome);
    }
		
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
	if(nome!= null)
	this.nome = nome;
    }
    
}
