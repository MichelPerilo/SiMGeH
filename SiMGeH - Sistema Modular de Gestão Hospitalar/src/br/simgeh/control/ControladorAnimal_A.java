/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import java.io.IOException;
import java.util.ArrayList;

import br.simgeh.data.IRepositorioAnimal_A;
import br.simgeh.data.RepositorioAnimal_A;
import br.simgeh.exeception.CadastroAnimalExistenteException;
import br.simgeh.exeception.CadastroEnderecoExistenteException;
import br.simgeh.exeception.CadastroProntuarioExistenteException;
import br.simgeh.exeception.CadastroTutorExistenteException;
import br.simgeh.model.Animal;
import br.simgeh.model.Endereco;
import br.simgeh.model.Prontuario;
import br.simgeh.model.Tutor;

/**
 *
 * @author Michel Perilo
 */
public class ControladorAnimal_A implements IGerenciadorAnimal_A{

	private IRepositorioAnimal_A repoAnimal = null;
	private  CadastroAnimal_A animal = new CadastroAnimal_A();
	private CadastroProntuario prontuario = new CadastroProntuario();
	private CadastroTutor tutor = new CadastroTutor();
	private CadastroEndereco endereco = new CadastroEndereco();
	
	public ControladorAnimal_A() throws IOException {
		this.repoAnimal = RepositorioAnimal_A.getInstance();
	}

	
	private static IGerenciadorAnimal_A instance;

	public static IGerenciadorAnimal_A getInstance() throws IOException {
		if (instance == null) {
			instance = new ControladorAnimal_A();
		}
		return instance;
	}


	public void cadatrarAnimal(String id, String especie, String nome, String sexo, int dta_nascto, float peso, String porte, String pelagem, String nome_tutor, String cpf, String fone_1, String fone_2 ,String cidade, String bairro, String logradouro, int numero) throws IOException,
	CadastroAnimalExistenteException, CadastroProntuarioExistenteException, CadastroEnderecoExistenteException, CadastroTutorExistenteException{

		Endereco e = new Endereco(cidade, bairro, logradouro, numero);    
		Tutor t = new Tutor(nome_tutor, cpf, e, fone_1, fone_2);       
		Animal a = new Animal(id, especie, nome, sexo, dta_nascto, peso, porte, pelagem, t);    
		this.animal.cadatrar(a);
		this.tutor.cadastrar(t);   
		this.endereco.cadastrar(e);
		Prontuario p = new Prontuario(a);
		this.prontuario.cadatrar(p);     
	}

	public ArrayList<Animal> allAnimals(){
		ArrayList<Animal> listaAnimal = null;
		try {
			listaAnimal = this.animal.allAnimals();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaAnimal;
	}

	public void  imprimiAnimal() throws IOException{
		this.repoAnimal.imprimiAnimal();
	}
	

}




