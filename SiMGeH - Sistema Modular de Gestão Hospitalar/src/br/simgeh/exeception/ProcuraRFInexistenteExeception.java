/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.exeception;

/**
 *
 * @author Raylison
 */
public class ProcuraRFInexistenteExeception extends Exception{
    public ProcuraRFInexistenteExeception(){
		
		super("REQUISIÇÃO NAO EXISTENTE!!!");
		
	}
}
