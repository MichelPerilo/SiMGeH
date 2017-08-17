/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.data.IRepositorioUsuario;
import br.simgeh.data.RepositorioUsuario;
import br.simgeh.exeception.CadastroUsuarioExistenteException;
import br.simgeh.exeception.ProcuraUsuarioInexistenteException;
import br.simgeh.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michel Perilo
 */
public class CadastroUsuario {
    private IRepositorioUsuario repositorio;

	public CadastroUsuario() {

		try {
			this.repositorio = RepositorioUsuario.getInstance();
		} catch (IOException e) {
                }

	}

	public void cadatrar(Usuario u) throws IOException, CadastroUsuarioExistenteException {
		this.repositorio.cadastra(u);

	}

	public void descadatrar(String login) throws IOException, ProcuraUsuarioInexistenteException {

		this.repositorio.remover(login);

	}

	public void exibiUsuario() throws IOException {

		this.repositorio.imprimiUsuario();
	}

        public ArrayList<Usuario> allUsers(){
            return this.repositorio.allUsers();
        }
        
	public Usuario acharUsuario(String login)throws ProcuraUsuarioInexistenteException {

		Usuario u = this.repositorio.procurar(login);
		return u;
	}
    
}
