/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.data.IRepositorioAgendamento;
import br.simgeh.data.RepositorioAgendamento;
import br.simgeh.exeception.CadastroAgendamentoExistenteException;
import br.simgeh.exeception.ProcuraAgendamentoInexistenteException;
import br.simgeh.model.Agendamento;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michel Perilo
 */
public class CadastroAgendamento {
     private IRepositorioAgendamento repositorio;

	public CadastroAgendamento() {

		try {
			this.repositorio = RepositorioAgendamento.getInstance();
		} catch (IOException e) {
                }

	}

	public void cadatrar(Agendamento a) throws IOException,
			CadastroAgendamentoExistenteException {
		this.repositorio.cadastra(a);

	}

	public void descadatrar(Agendamento a) throws IOException,
			ProcuraAgendamentoInexistenteException {

		this.repositorio.remover(a);

	}

	public void exibiAgendamento() throws IOException {

		this.repositorio.imprimiAgendamento();
	}

        public ArrayList<Agendamento> agendamentosPorProntuario(int prontuario_id){
            return this.repositorio.agendamentosPorProntuario(prontuario_id);
        }
        
	public Agendamento acharAgendamento(Agendamento a)
			throws ProcuraAgendamentoInexistenteException {

		Agendamento u = this.repositorio.procurar(a);
		return u;
	}
}
