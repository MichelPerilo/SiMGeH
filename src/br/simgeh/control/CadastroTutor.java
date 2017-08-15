/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.data.IRepositorioTutor;
import br.simgeh.data.RepositorioTutor;
import br.simgeh.exeception.CadastroTutorExistenteException;
import br.simgeh.exeception.ProcurarTutorInexistenteException;
import br.simgeh.model.Animal;
import br.simgeh.model.Tutor;
import java.io.IOException;

/**
 *
 * @author Michel Perilo
 */
public class CadastroTutor {
    private IRepositorioTutor repositorio;

	public CadastroTutor() {

		try {
			this.repositorio = RepositorioTutor.getInstance();
		} catch (IOException e) {
                }

	}

	public void cadastrar(Tutor t) throws IOException,
			CadastroTutorExistenteException {
		this.repositorio.cadastra(t);

	}

	public void descadatrar(Animal a) throws IOException,
			ProcurarTutorInexistenteException {

		this.repositorio.remover(a);

	}

	public void exibiProntuario() throws IOException {

		this.repositorio.imprimiTutor();
	}

	public Tutor acharProntuario(Animal a)
			throws ProcurarTutorInexistenteException {

		Tutor p = this.repositorio.procurar(a);
		return p;
	}
}
