
package br.simgeh.data;

import br.simgeh.exeception.ProcuraRFInexistenteExeception;
import br.simgeh.model.RequisicaoProduto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Raylison
 */
public interface IRepositorioRequisicaoFarmaco {
    
     public void cadastra(RequisicaoProduto RF)throws IOException;
	public RequisicaoProduto procurar(int id) throws ProcuraRFInexistenteExeception;
	public boolean existe(int id);
	public List<RequisicaoProduto>  imprimiRF() throws IOException;
    
}
