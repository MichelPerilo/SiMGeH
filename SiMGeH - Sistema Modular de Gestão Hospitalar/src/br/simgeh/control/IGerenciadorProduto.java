package br.simgeh.control;

import br.simgeh.exeception.CadatroProdutoExistenteExeception;
import br.simgeh.exeception.ProcuraProdutoInexistenteExeception;
import br.simgeh.model.Produto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Raylison
 */
public interface IGerenciadorProduto {
    
    public void cadatrarProduto(String nome, String tipo, String descricao,int id, int qtd) throws IOException,
            CadatroProdutoExistenteExeception;

    public List<Produto> exibiProduto() throws IOException;

    public void excluirProduto(String nome) throws IOException,
            ProcuraProdutoInexistenteExeception;

    public Produto pesquisarProduto(String nome)
            throws ProcuraProdutoInexistenteExeception;



    
}
