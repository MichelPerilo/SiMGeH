package br.simgeh.control;

import br.simgeh.data.IRepositorioAnimal;
import br.simgeh.data.RepositorioAnimalArrayList;
import br.simgeh.exeception.PacienteJahCadastradoException;
import br.simgeh.model.Animal;


/**
 * Controlador Paciente
 * @author Bartoh
 * */

public class ControladorAnimal {
	private IRepositorioAnimal repositorio;
	
	public ControladorAnimal() {
		this.repositorio = RepositorioAnimalArrayList.getInstance();
	}
	
	public boolean existe(Animal a) {
		boolean resultado = ((RepositorioAnimalArrayList)this.repositorio).existe(a);

		return resultado;
	}

	
	public void cadastrar(Animal a) throws PacienteJahCadastradoException {

		if (this.existe(a)) {
			throw new PacienteJahCadastradoException(a.getTutor(), a);
		}
		
		this.repositorio.cadastrar(a);
	}

}
