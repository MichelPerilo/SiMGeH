/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.exeception.CadastroAgendamentoExistenteException;
import br.simgeh.model.Agendamento;
import br.simgeh.model.Servico;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Michel Perilo
 */
public class ControladorAgendamento implements IGerenciadorAgendamento {
    private  CadastroAgendamento agendamento = new CadastroAgendamento();
   
     
     private static IGerenciadorAgendamento instance;

    public static IGerenciadorAgendamento getInstance() {
        if (instance == null) {
            instance = new ControladorAgendamento();
        }
        return instance;
    }

   
    public void cadatrarAgendamento(int prontuario_id, String data, String hora, Servico servico ) throws IOException, CadastroAgendamentoExistenteException{
    
    
    Agendamento a = new Agendamento( prontuario_id,  data, hora, servico );
    this.agendamento.cadatrar(a);     
    }

    public ArrayList<Agendamento> agendamentosPorProntuario(int prontuario_id){
        return this.agendamento.agendamentosPorProntuario(prontuario_id);
    }
    
    
}
