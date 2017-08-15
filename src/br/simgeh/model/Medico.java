/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.model;

import java.util.Date;

/**
 *
 * @author BARTOLOMEU.DIAS
 */
public class Medico extends Usuario {
    
    private String MATRICULA;
    private String Especialidade;
    private int crmv;
    
    
    public Medico(String Especialidade, int crmv, int MATRICULA, String login, String senha, Boolean admin, String pNome, String uNome, String CPF, Date dta_nascto, int tel_fixo, int tel_celular) {
        super(MATRICULA, login, senha, admin, pNome, uNome, CPF, dta_nascto, tel_fixo, tel_celular);
        this.Especialidade = Especialidade;
        this.crmv = crmv;
    }

    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCpf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTelefone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
