/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.model.Animal;

/**
 *
 * @author Aluno
 */
public interface IRepositorioRecepcionista {
    //public boolean cadastrar( a);
	
	public void atualizar(Animal a);

	public Animal buscaPorID(String ID);

	public Animal buscarPorCPFTutor(String CPF);
	
	void remover(String ID);

	//public List<Animal> listarTodos();
}
