/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.exeception.CadastroUsuarioExistenteException;
import br.simgeh.model.Medico;
import br.simgeh.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Michel Perilo
 */
public class ControladorUsuario implements IGerenciadorUsuario {
     private  CadastroUsuario usuario = new CadastroUsuario();
   
     
     private static IGerenciadorUsuario instance;

    public static IGerenciadorUsuario getInstance() {
        if (instance == null) {
            instance = new ControladorUsuario();
        }
        return instance;
    }

   
    public void cadatrarUsuario(String Especialidade, int crmv, int MATRICULA, String login, String senha, Boolean admin, String pNome, String uNome, String CPF, Date dta_nascto, int tel_fixo, int tel_celular) throws IOException, CadastroUsuarioExistenteException{
    
    
    Medico m = new Medico(Especialidade,  crmv,  MATRICULA,  login,  senha,  admin,  pNome,  uNome,  CPF,  dta_nascto,  tel_fixo,  tel_celular);
    this.usuario.cadatrar(m);     
    }

    public ArrayList<Usuario> allUsers(){
        return this.usuario.allUsers();
    }
    
}
