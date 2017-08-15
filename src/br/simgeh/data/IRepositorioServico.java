/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroServicoExistenteException;
import br.simgeh.exeception.ProcuraServicoInexistenteException;
import br.simgeh.model.Servico;
import java.io.IOException;

/**
 *
 * @author Michel Perilo
 */
public interface IRepositorioServico {
    public void  imprimiServico() throws IOException;
    public void remover(Servico s) throws IOException, ProcuraServicoInexistenteException;
    public Servico procurar(Servico s) throws ProcuraServicoInexistenteException;
    public void cadastra(Servico s) throws IOException, CadastroServicoExistenteException;
}
