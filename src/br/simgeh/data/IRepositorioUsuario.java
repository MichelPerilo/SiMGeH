/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroUsuarioExistenteException;
import br.simgeh.exeception.ProcuraUsuarioInexistenteException;
import br.simgeh.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michel Perilo
 */
public interface IRepositorioUsuario {
    
    public void cadastra(Usuario u) throws IOException,
			CadastroUsuarioExistenteException;
    public Usuario procurar(String login) throws ProcuraUsuarioInexistenteException;
    public boolean existe(String login);
    public void remover(String login) throws IOException, ProcuraUsuarioInexistenteException;
    public ArrayList<Usuario> allUsers();
    public void  imprimiUsuario() throws IOException;
}
