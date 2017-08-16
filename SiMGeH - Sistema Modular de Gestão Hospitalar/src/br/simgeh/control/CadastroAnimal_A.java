package br.simgeh.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import br.simgeh.data.IRepositorioAnimal_A;
import br.simgeh.data.RepositorioAnimal_A;
import br.simgeh.exeception.CadastroAnimalExistenteException;
import br.simgeh.exeception.ProcuraAnimalInexistenteException;
import br.simgeh.model.Animal;

/**
 *
 * @author Michel Perilo
 */

public class CadastroAnimal_A {
	private IRepositorioAnimal_A repositorio;

	public CadastroAnimal_A() {

		try {
			this.repositorio = RepositorioAnimal_A.getInstance();
		} catch (IOException e) {
                }

	}

	public void cadatrar(Animal a) throws IOException,
			CadastroAnimalExistenteException {
		this.repositorio.cadastra(a);

	}

	public void descadatrar(String cpf, String nome) throws IOException,
			ProcuraAnimalInexistenteException {

		this.repositorio.remover(cpf, nome);

	}

	public void exibiAnimal() throws IOException {

		this.repositorio.imprimiAnimal();
	}

        public ArrayList<Animal> allAnimals() throws IOException{
            return this.repositorio.allAnimals();
        }
        
	public Animal acharAnimal(String cpf, String nome)
			throws ProcuraAnimalInexistenteException {

		Animal a = this.repositorio.procurar(cpf, nome);
		return a;
	}
	
}
