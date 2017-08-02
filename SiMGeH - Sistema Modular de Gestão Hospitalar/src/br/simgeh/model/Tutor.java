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
public class Tutor extends Pessoa{
    
    public Tutor(String nome, String sobrenome, String CPF, Date dta_nascto, int tel_fixo, int tel_celular) {
        super(nome, sobrenome, CPF, dta_nascto, tel_fixo, tel_celular);
    }
    
}
