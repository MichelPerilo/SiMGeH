/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.model;

import java.io.Serializable;

/**
 *
 * @author Raylison Santos
 */
public class RequisicaoProduto implements Serializable{
    
    private String setor;
    private int qtd;
    static int IDcont = 0;
    private int ID;
    private String descricao;
    private String status;              /*
                                        1 - Não avaliada 
                                        3 - Rejeitada 
                                        4 - Finalizada
                                                        */
    private String justificativa;

    
   

    public RequisicaoProduto(String setor,String descricao, String justificativa, int qtd) {
        setSetor(setor);
        setID();
        setDescricao(descricao);
        setSetor(setor);
        setQtd(qtd);
        
        
    }

    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    public int getQtd() {
        return qtd;
    }

    private void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    private void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }
    
    

    public int getID() {
        return ID;
    }

    public String getStatus() {
        return status;
    }

    public String getJustificativa() {
        return justificativa;
    }

    private void setID() {
        this.ID = ++RequisicaoProduto.IDcont;
        
        
    }

    private void setStatus(String status) {
        this.status = status;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    @Override
    public String toString() {
        return "RequisicaoProduto" + "\n\nsetor: " + setor + "   ID: " + ID;
    }
    
    
    
    
}
