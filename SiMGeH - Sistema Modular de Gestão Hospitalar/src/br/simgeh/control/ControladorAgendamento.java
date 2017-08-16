/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.exeception.CadastroAgendamentoExistenteException;
import br.simgeh.exeception.CadastroServicoExistenteException;
import br.simgeh.model.Agendamento;
import br.simgeh.model.Consulta;
import br.simgeh.model.ExameImagem;
import br.simgeh.model.ExameLaboratorial;
import br.simgeh.model.ProcCirurgico;
import br.simgeh.model.Servico;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michel Perilo
 */
public class ControladorAgendamento implements IGerenciadorAgendamento {
    private  CadastroAgendamento agendamento = new CadastroAgendamento();
    private  CadastroServico servico = new CadastroServico();
   
     
     private static IGerenciadorAgendamento instance;

    public static IGerenciadorAgendamento getInstance() {
        if (instance == null) {
            instance = new ControladorAgendamento();
        }
        return instance;
    }

   
    public void cadatrarAgendamento(int prontuario_id, String data, String hora , int type) throws IOException, CadastroAgendamentoExistenteException, CadastroServicoExistenteException{
        Servico s = null;
    
        switch(type){
            case 1 : s = new Consulta();
            case 2 : s = new ExameImagem();
            case 3 : s = new ExameLaboratorial();
            case 4 : s = new ProcCirurgico();
        }
        
        Agendamento a = new Agendamento( prontuario_id, data, hora, s);
        this.agendamento.cadatrar(a);     
        this.servico.cadatrar(s);
        
    }

    public ArrayList<Agendamento> agendamentosPorProntuario(int prontuario_id){
        return this.agendamento.agendamentosPorProntuario(prontuario_id);
    }
    
    
}
