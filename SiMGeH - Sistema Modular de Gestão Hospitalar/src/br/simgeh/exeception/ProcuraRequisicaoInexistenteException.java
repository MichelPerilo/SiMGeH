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
public class ProcuraRequisicaoInexistenteException extends Exception{
    
    public ProcuraRequisicaoInexistenteException(){
		
		super("REQUISIÇÃO NAO EXISTENTE!!!");
		
	}
    
}
