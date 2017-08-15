/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroRequisicaoExistenteException;
import br.simgeh.exeception.ProcuraRequisicaoInexistenteException;
import br.simgeh.model.Requisicao;
import java.io.IOException;

/**
 *
 * @author Elal
 */
public interface IRepositorioRequisicoes {
    
    public void cadastra(Requisicao r)  throws IOException, CadastroRequisicaoExistenteException; //Cadastro de Requisição já Existente
    public Requisicao procurar(int id) throws ProcuraRequisicaoInexistenteException; // Procurar uma Requisiçõa não Existente
    public boolean existe(int id);
    public void remover (int id)  throws IOException, ProcuraRequisicaoInexistenteException;
    public void exibeListaReq() throws IOException;
    public void exibeReq(int id) throws IOException , ProcuraRequisicaoInexistenteException;
    public void atualizar(int id, int status) throws IOException, ProcuraRequisicaoInexistenteException;
    
}
