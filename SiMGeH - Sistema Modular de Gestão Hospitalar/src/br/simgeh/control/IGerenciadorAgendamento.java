/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.exeception.CadastroAgendamentoExistenteException;
import br.simgeh.exeception.CadastroServicoExistenteException;
import br.simgeh.model.Agendamento;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michel Perilo
 */
public interface IGerenciadorAgendamento {
    
     public void cadatrarAgendamento(int prontuario_id, String data, String hora , int type) throws IOException, CadastroAgendamentoExistenteException, CadastroServicoExistenteException;
     public ArrayList<Agendamento> agendamentosPorProntuario(int prontuario_id);
    
}
