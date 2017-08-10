/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroAnimalExistenteException;
import br.simgeh.exeception.ProcuraAnimalInexistenteException;
import br.simgeh.model.Animal;
import java.io.IOException;

/**
 *
 * @author Michel Perilo
 */
public interface IRepositorioAnimal_A {
    
    public void cadastra(Animal a)  throws IOException, CadastroAnimalExistenteException;
    public Animal procurar(String cpf, String nome) throws ProcuraAnimalInexistenteException;
    public boolean existe(String cpf, String nome);
    public void remover(String cpf, String nome) throws IOException, ProcuraAnimalInexistenteException;
    public void  imprimiAnimal() throws IOException;
    
}
