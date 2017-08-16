package br.simgeh.control;

import br.simgeh.data.IRepositorioRequisicaoFarmaco;
import br.simgeh.data.RepositorioRequisicaoFarmaco;
import br.simgeh.exeception.ProcuraRFInexistenteExeception;
import br.simgeh.model.RequisicaoProduto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Raylison
 */
public class CadastroRequisicaoFarmaco {
    
    private IRepositorioRequisicaoFarmaco repositorio;

	public CadastroRequisicaoFarmaco() {

		try {
			this.repositorio = RepositorioRequisicaoFarmaco.getInstance();
		} catch (IOException e) {
                }

	}
    public void cadatrar(RequisicaoProduto rp) throws IOException{
		this.repositorio.cadastra(rp);

	}
    public List<RequisicaoProduto> exibiRequisicao() throws IOException {

            return this.repositorio.imprimiRF();
	}

	public RequisicaoProduto acharProduto(int id)
			throws ProcuraRFInexistenteExeception {

		RequisicaoProduto rf = this.repositorio.procurar(id);
		return rf;
	}    
        
    
    
}
