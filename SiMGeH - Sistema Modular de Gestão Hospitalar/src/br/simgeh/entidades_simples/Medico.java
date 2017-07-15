/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.entidades_simples;

import java.util.Date;

/**
 *
 * @author BARTOLOMEU.DIAS
 */
public class Medico extends Usuario {
    private String Especialidade;
    private int crmv;

    public Medico(int MATRICULA, String login, String senha, Boolean admin, String pNome, String uNome, String CPF, Date dta_nascto, int tel_fixo, int tel_celular, Endereco endereco) {
        super(MATRICULA, login, senha, admin, pNome, uNome, CPF, dta_nascto, tel_fixo, tel_celular, endereco);
    }
    
    
}
