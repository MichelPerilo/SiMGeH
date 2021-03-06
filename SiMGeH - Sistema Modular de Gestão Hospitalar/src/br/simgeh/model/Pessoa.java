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
 public abstract class Pessoa {
    private String CPF;
    private String nome;
    private String sobrenome;
    private Date dta_nascto;
    private int tel_fixo;
    private int tel_celular;
    private String Endereco;

    public Pessoa(String pNome, String uNome, String CPF, Date dta_nascto, int tel_fixo, int tel_celular) {
        this.nome = pNome;
        this.sobrenome = uNome;
        this.CPF = CPF;
        this.dta_nascto = dta_nascto;
        this.tel_fixo = tel_fixo;
        this.tel_celular = tel_celular;
    }

    public String getpNome() {
        return nome;
    }

    public void setpNome(String pNome) {
        this.nome = pNome;
    }

    public String getuNome() {
        return sobrenome;
    }

    public void setuNome(String uNome) {
        this.sobrenome = uNome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDta_nascto() {
        return dta_nascto;
    }

    public void setDta_nascto(Date dta_nascto) {
        this.dta_nascto = dta_nascto;
    }

    public int getTel_fixo() {
        return tel_fixo;
    }

    public void setTel_fixo(int tel_fixo) {
        this.tel_fixo = tel_fixo;
    }

    public int getTel_celular() {
        return tel_celular;
    }

    public void setTel_celular(int tel_celular) {
        this.tel_celular = tel_celular;
    }
    
    
}
