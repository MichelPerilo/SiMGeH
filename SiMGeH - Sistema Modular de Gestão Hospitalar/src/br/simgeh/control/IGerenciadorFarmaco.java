package br.simgeh.control;

import br.simgeh.exeception.CadatroProdutoExistenteExeception;
import br.simgeh.exeception.ProcuraProdutoInexistenteExeception;
import br.simgeh.exeception.ProcuraRFInexistenteExeception;
import br.simgeh.model.Produto;
import br.simgeh.model.RequisicaoProduto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Raylison
 */
public interface IGerenciadorFarmaco {
    
    public void cadatrarProduto(String nome, String tipo, String descricao, int qtd) throws IOException,
            CadatroProdutoExistenteExeception;

    public List<Produto> exibiProduto() throws IOException;

    public void excluirProduto(String nome) throws IOException,
            ProcuraProdutoInexistenteExeception;

    public Produto pesquisarProduto(String nome)
            throws ProcuraProdutoInexistenteExeception;

    public void cadatrarRequisicao(String setor, String status, String justificativa, int qtd)throws IOException;

    public List<RequisicaoProduto> exibiRequisicao() throws IOException;

   
    public RequisicaoProduto pesquisaRequisicaoProduto(int id)
            throws ProcuraRFInexistenteExeception;


    
}
