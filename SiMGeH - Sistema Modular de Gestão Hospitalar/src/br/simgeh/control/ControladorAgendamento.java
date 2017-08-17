/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.exeception.CadastroAgendamentoExistenteException;
import br.simgeh.exeception.CadastroServicoExistenteException;
import br.simgeh.model.Agendamento;
import br.simgeh.model.Animal;
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

   
    public void cadatrarAgendamento(Animal animal, String data, String hora , int type) throws IOException, CadastroAgendamentoExistenteException, CadastroServicoExistenteException{
        Servico s = null;
    
        switch(type){
            case 1 : s = new ProcCirurgico();
            case 2 : s = new ExameImagem();
            case 3 : s = new ExameLaboratorial();
            case 4 : s = new Consulta();
        }
        
        Agendamento a = new Agendamento( animal, data, hora, s);
        this.agendamento.cadatrar(a);     
        this.servico.cadatrar(s);
        
    }

    public ArrayList<Agendamento> agendamentosPorProntuario(Animal animal){
        return this.agendamento.agendamentosPorProntuario(animal);
    }
    
     public ArrayList<Agendamento> allAgendamentos(){
         return this.agendamento.allAgendamentos();
     }
    
    
}
