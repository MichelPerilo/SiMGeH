/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.model;

import java.util.Date;

/**
 *
 * @author Bartô
 */
public class Farmaceutico extends Usuario{

    public Farmaceutico(int MATRICULA, String login, String senha, Boolean admin, String pNome, String uNome, String CPF, Date dta_nascto, int tel_fixo, int tel_celular) {
        super(MATRICULA, login, senha, admin, pNome, uNome, CPF, dta_nascto, tel_fixo, tel_celular);
    }
    
    
    
}
