/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.exeception.CadastroAnimalExistenteException;
import br.simgeh.exeception.CadastroEnderecoExistenteException;
import br.simgeh.exeception.CadastroProntuarioExistenteException;
import br.simgeh.exeception.CadastroTutorExistenteException;
import br.simgeh.model.Animal;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michel Perilo
 */
public interface IGerenciadorAnimal_A {
    
    public void cadatrarAnimal(String id, String especie, String nome, String sexo, int dta_nascto, float peso, String porte, String pelagem, String nome_tutor, String cpf, String fone_1, String fone_2 ,String cidade, String bairro, String logradouro, int numero) throws IOException,
            CadastroAnimalExistenteException, CadastroProntuarioExistenteException, CadastroEnderecoExistenteException, CadastroTutorExistenteException;
    
    public ArrayList<Animal> allAnimals();
    
    public void  imprimiAnimal() throws IOException;
}

