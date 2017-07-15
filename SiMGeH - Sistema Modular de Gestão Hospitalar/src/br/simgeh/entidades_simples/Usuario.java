package br.simgeh.entidades_simples;
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
public abstract class Usuario {
    private int MATRICULA;
    private String login;
    private String senha;
    private Boolean admin;
    private String pNome;
    private String uNome;
    private String CPF;
    private Date dta_nascto;
    private int tel_fixo;
    private int tel_celular;
    private Endereco endereco;

    public Usuario(int MATRICULA, String login, String senha, Boolean admin, String pNome, String uNome, String CPF, Date dta_nascto, int tel_fixo, int tel_celular, Endereco endereco) {
        this.MATRICULA = MATRICULA;
        this.login = login;
        this.senha = senha;
        this.admin = admin;
        this.pNome = pNome;
        this.uNome = uNome;
        this.CPF = CPF;
        this.dta_nascto = dta_nascto;
        this.tel_fixo = tel_fixo;
        this.tel_celular = tel_celular;
        this.endereco = endereco;
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

    public String getpNome() {
        return pNome;
    }

    public void setpNome(String pNome) {
        this.pNome = pNome;
    }

    public String getuNome() {
        return uNome;
    }

    public void setuNome(String uNome) {
        this.uNome = uNome;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
