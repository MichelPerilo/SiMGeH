/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.model;

/**
 *
 * @author Michel Perilo
 */
public abstract class Requisicao {
    private int prontuario_id;
    private int ID;
    private int status;              /*
                                        1 - Não avaliada 
                                        2 - Em andamento
                                        3 - Rejeitada 
                                        4 - Finalizada
                                                        */
    private String justificativa; //Caso Rejeitada
    
    public int getPID()
    {
        return this.prontuario_id;
    }
    
    public void setPID(int pid)
    {
        if (pid >= 0)
        {
            this.prontuario_id = pid;
        }
    }
    
    public int getID()
    {
        return this.ID;
    }
    
    public void setID(int id)
    {
        if (id >= 0)
        {
            this.ID = id;
        }
    }
    
    public int getStatus()
    {
        return this.status;
    }
    
    public void setStatus(int s)
    {
        if (s >= 0)
        {
            this.status = s;
        }
    }
    
    public String getJust()
    {
        return this.justificativa;
    }
    
    public void setJust(String s)
    {
        if(s != null)
        {
            this.justificativa = s;
        }
    }
}

