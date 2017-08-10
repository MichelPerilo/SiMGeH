/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroEnderecoExistenteException;
import br.simgeh.exeception.ProcuraEnderecoInexistenteException;
import br.simgeh.model.Endereco;
import br.simgeh.model.Tutor;
import java.io.IOException;

/**
 *
 * @author Michel Perilo
 */
public interface IRepositorioEndereco {
    
    public void cadastra(Endereco e) throws IOException, CadastroEnderecoExistenteException;
    public Endereco procurar(Tutor t) throws ProcuraEnderecoInexistenteException;
    public boolean existe(Endereco e);
    public void remover(Tutor t) throws IOException, ProcuraEnderecoInexistenteException;
    public void  imprimiEndereco() throws IOException;
}
