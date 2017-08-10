/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CREException;
import br.simgeh.exeception.PRIException;
import br.simgeh.model.Requisicao;
import java.io.IOException;

/**
 *
 * @author Elal
 */
public interface IRepositorioRequisicoes {
    
    public void cadastra(Requisicao r)  throws IOException, CREException; //Cadastro de Requisição já Existente
    public Requisicao procurar(String nome) throws PRIException; // Procurar uma Requisiçõa não Existente
    public boolean existe(String nome);
    public void remover (String nome)  throws IOException, PRIException; // //
    public void  exibeRequisicao() throws IOException;
    
}
