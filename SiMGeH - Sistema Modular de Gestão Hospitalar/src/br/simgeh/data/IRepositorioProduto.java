package br.simgeh.data;
import br.simgeh.exeception.CadatroProdutoExistenteExeception;
import br.simgeh.exeception.ProcuraProdutoInexistenteExeception;
import br.simgeh.model.Produto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Raylison
 */


public interface IRepositorioProduto {
    
    public void cadastra(Produto p)  throws IOException, CadatroProdutoExistenteExeception;
	public Produto procurar(String nome) throws ProcuraProdutoInexistenteExeception;
	public boolean existe(String nome);
	public void remover (String nome)  throws IOException, ProcuraProdutoInexistenteExeception;
	public List<Produto>  imprimiProduto() throws IOException;
	
}
