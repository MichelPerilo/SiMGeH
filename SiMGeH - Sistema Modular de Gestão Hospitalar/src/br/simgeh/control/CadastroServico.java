/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.data.IRepositorioServico;
import br.simgeh.data.RepositorioServico;
import br.simgeh.exeception.CadastroServicoExistenteException;
import br.simgeh.exeception.ProcuraServicoInexistenteException;
import br.simgeh.model.Servico;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michel Perilo
 */
public class CadastroServico {
    private IRepositorioServico repositorio;

	public CadastroServico() {

		try {
			this.repositorio = RepositorioServico.getInstance();
		} catch (IOException e) {
                }

	}

	public void cadatrar(Servico a) throws IOException,
			CadastroServicoExistenteException {
		this.repositorio.cadastra(a);

	}

	public void descadatrar(Servico a) throws IOException,
			ProcuraServicoInexistenteException {

		this.repositorio.remover(a);

	}

	public void exibiServico() throws IOException {

		this.repositorio.imprimiServico();
	}

        /*
        public ArrayList<Servico> agendamentosPorProntuario(int prontuario_id){
            return this.repositorio.servicosPorProntuario(prontuario_id);
        }*/
        
	public Servico acharServico(Servico a)
			throws ProcuraServicoInexistenteException {

		Servico u = this.repositorio.procurar(a);
		return u;
	}
    
}
