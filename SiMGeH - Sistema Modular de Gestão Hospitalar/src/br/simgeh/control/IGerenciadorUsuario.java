/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.exeception.CadastroUsuarioExistenteException;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Michel Perilo
 */
public interface IGerenciadorUsuario {
    public void cadatrarUsuario(String Especialidade, int crmv, int MATRICULA, String login, String senha, Boolean admin, String pNome, String uNome, String CPF, Date dta_nascto, int tel_fixo, int tel_celular) throws IOException, CadastroUsuarioExistenteException;
}
