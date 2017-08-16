/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.simgeh.control;

import br.simgeh.data.IRepositorioProntuario;
import br.simgeh.data.RepositorioProntuario;
import br.simgeh.exeception.CadastroProntuarioExistenteException;
import br.simgeh.exeception.ProcuraProntuarioInexistenteException;
import br.simgeh.model.Animal;
import br.simgeh.model.Prontuario;
import java.io.IOException;

/**
 *
 * @author Michel Perilo
 */
public class CadastroProntuario {
    private IRepositorioProntuario repositorio;

	public CadastroProntuario() {

		try {
			this.repositorio = RepositorioProntuario.getInstance();
		} catch (IOException e) {
        }

	}

	public void cadatrar(Prontuario p) throws IOException, CadastroProntuarioExistenteException {
		this.repositorio.cadastra(p);
	}

	public void descadatrar(Animal a) throws IOException, ProcuraProntuarioInexistenteException {
		this.repositorio.remover(a);
	}

	public void exibiProntuario() throws IOException {

		this.repositorio.imprimiProntuario();
	}

	public Prontuario acharProntuario(Animal a)
			throws ProcuraProntuarioInexistenteException {

		Prontuario p = this.repositorio.procurar(a);
		return p;
	}

}
