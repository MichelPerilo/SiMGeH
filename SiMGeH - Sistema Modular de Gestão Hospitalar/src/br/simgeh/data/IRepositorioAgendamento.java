/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroAgendamentoExistenteException;
import br.simgeh.exeception.ProcuraAgendamentoInexistenteException;
import br.simgeh.model.Agendamento;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michel Perilo
 */
public interface IRepositorioAgendamento {
    public void  imprimiAgendamento() throws IOException;
     public ArrayList<Agendamento> agendamentosPorProntuario(int prontuario_id);
     public void remover(Agendamento a) throws IOException, ProcuraAgendamentoInexistenteException;
     public Agendamento procurar(Agendamento a) throws ProcuraAgendamentoInexistenteException;
     public void cadastra(Agendamento a) throws IOException,
			CadastroAgendamentoExistenteException;
    
}
