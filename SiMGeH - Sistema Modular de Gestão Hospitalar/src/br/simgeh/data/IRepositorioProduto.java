/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import java.util.List;

/**
 *
 * @author Aluno
 */
public interface IRepositorioProduto {
    //public boolean cadastrarProduto(Animal animal);
    
    public void buscarProduto(int crmv, int MATRICULA, String CPF);
    
   /**
    *
    * @param animal: recebe uma instância de cadastro de animal atualizada(com os novos dados)
    */ 
    //public boolean atualizarCDProduto(Produto prdot);
    
    //public boolean removerCDProduto(Animal animal);
    
    //public List<Produto> listarProduto();
}
