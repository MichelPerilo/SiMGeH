/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.data.IRepositorioEndereco;
import br.simgeh.data.RepositorioEndereco;
import br.simgeh.exeception.CadastroEnderecoExistenteException;
import br.simgeh.exeception.ProcuraEnderecoInexistenteException;
import br.simgeh.model.Endereco;
import br.simgeh.model.Tutor;
import java.io.IOException;

/**
 *
 * @author Michel Perilo
 */
public class CadastroEndereco {
    private IRepositorioEndereco repositorio;

	public CadastroEndereco() {

		try {
			this.repositorio = RepositorioEndereco.getInstance();
		} catch (IOException e) {
                }

	}

	public void cadastrar(Endereco e) throws IOException,
			CadastroEnderecoExistenteException {
		this.repositorio.cadastra(e);

	}

	public void descadatrar(Tutor t) throws IOException,
			ProcuraEnderecoInexistenteException {

		this.repositorio.remover(t);

	}

	public void exibiEndereco() throws IOException {

		this.repositorio.imprimiEndereco();
	}

	public Endereco acharProntuario(Tutor t)
			throws ProcuraEnderecoInexistenteException {

		Endereco p = this.repositorio.procurar(t);
		return p;
	}
    
}
