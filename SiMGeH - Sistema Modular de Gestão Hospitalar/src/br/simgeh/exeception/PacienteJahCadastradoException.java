package br.simgeh.exeception;

import br.simgeh.model.Animal;
import br.simgeh.model.Tutor;

public class PacienteJahCadastradoException extends Exception {
	public PacienteJahCadastradoException(Tutor t, Animal a) {
		super("O animal " + a.getNome() + "\n" + "Tutor : " +  t.getNome() + "\n" + "Já está cadastrado no sistema!");
	}
}
