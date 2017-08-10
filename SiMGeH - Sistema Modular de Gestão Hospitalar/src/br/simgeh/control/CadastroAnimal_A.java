package br.simgeh.control;

import br.simgeh.data.IRepositorioAnimal_A;
import br.simgeh.data.RepositorioAnimal_A;
import br.simgeh.exeception.CadastroAnimalExistenteException;
import br.simgeh.exeception.ProcuraAnimalInexistenteException;
import br.simgeh.model.Animal;
import java.io.IOException;

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

	public Animal acharAnimal(String cpf, String nome)
			throws ProcuraAnimalInexistenteException {

		Animal a = this.repositorio.procurar(cpf, nome);
		return a;
	}
}
