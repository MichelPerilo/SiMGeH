package br.simgeh.control;

import br.simgeh.exeception.CadatroProdutoExistenteExeception;
import br.simgeh.exeception.ProcuraProdutoInexistenteExeception;
import br.simgeh.model.Produto;
import java.io.IOException;

/**
 *
 * @author Raylison
 */
public interface IGerenciadorProduto {
    
    public void cadatrarProduto(String nome, String tipo, String descricao) throws IOException,
            CadatroProdutoExistenteExeception;

    public void exibiProduto() throws IOException;

    public void excluirProduto(String nome) throws IOException,
            ProcuraProdutoInexistenteExeception;

    public Produto pesquisarProduto(String nome)
            throws ProcuraProdutoInexistenteExeception;



    
}
