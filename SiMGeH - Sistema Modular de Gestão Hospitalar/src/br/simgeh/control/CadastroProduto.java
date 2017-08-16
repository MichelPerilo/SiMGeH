
package br.simgeh.control;

import br.simgeh.data.IRepositorioProduto;
import br.simgeh.data.RepositorioProduto;
import br.simgeh.exeception.CadatroProdutoExistenteExeception;
import br.simgeh.exeception.ProcuraProdutoInexistenteExeception;
import br.simgeh.model.Produto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Raylison
 */
public class CadastroProduto {
    
    private IRepositorioProduto repositorio;

	public CadastroProduto() {

		try {
			this.repositorio = RepositorioProduto.getInstance();
		} catch (IOException e) {
                }

	}

	public void cadatrar(Produto p) throws IOException,
			CadatroProdutoExistenteExeception {
		this.repositorio.cadastra(p);

	}

	public void descadatrar(String nome) throws IOException,
			ProcuraProdutoInexistenteExeception {

		this.repositorio.remover(nome);

	}

	public List<Produto> exibiProduto() throws IOException {

            return this.repositorio.imprimiProduto();
	}

	public Produto acharProduto(String nome)
			throws ProcuraProdutoInexistenteExeception {

		Produto p = this.repositorio.procurar(nome);
		return p;
	}
	
    
}
