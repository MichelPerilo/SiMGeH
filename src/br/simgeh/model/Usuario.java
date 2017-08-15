package br.simgeh.model;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bartô
 */
public abstract class Usuario extends Pessoa {
    private int MATRICULA;
    private String login;
    private String senha;
    private Boolean admin;
    
    
    public Usuario(int MATRICULA, String login, String senha, Boolean admin, String pNome, String uNome, String CPF, Date dta_nascto, int tel_fixo, int tel_celular) {
        super(pNome, uNome, CPF, dta_nascto, tel_fixo, tel_celular);
        this.MATRICULA = MATRICULA;
        this.login = login;
        this.senha = senha;
        this.admin = admin;
    }
    
    public int getMATRICULA() {
        return MATRICULA;
    }

    public void setMATRICULA(int MATRICULA) {
        this.MATRICULA = MATRICULA;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
 
}
