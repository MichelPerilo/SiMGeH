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

public class ControladorFarmaco implements IGerenciadorFarmaco{
    
    
     private  CadastroProduto produto = new CadastroProduto();
     private  CadastroRequisicaoFarmaco requisicaoF = new CadastroRequisicaoFarmaco();
     private static IGerenciadorFarmaco instance;
     
    public static IGerenciadorFarmaco getInstance() {
        if (instance == null) {
            instance = new ControladorFarmaco();
        }
        return instance;
    }
    
      
    public void cadatrarProduto(String nome, String tipo, String descricao, int qtd) throws IOException,
            CadatroProdutoExistenteExeception{

    Produto p = new Produto(nome,tipo,descricao,qtd);    
    this.produto.cadatrar(p);

    }

    public List<Produto> exibiProduto() throws IOException {

         return this.produto.exibiProduto();
    }

    

    public void excluirProduto(String nome) throws IOException,
            ProcuraProdutoInexistenteExeception {

        this.produto.descadatrar(nome);
    }

    public Produto pesquisarProduto(String nome)
            throws ProcuraProdutoInexistenteExeception {

        Produto p = this.produto.acharProduto(nome);
        return p;

    }
    
    
    public void cadatrarRequisicao(String setor, String descricao, String justificativa,int qtd)throws IOException{
        
        RequisicaoProduto rf = new RequisicaoProduto(setor,descricao,justificativa,qtd);    
        this.requisicaoF.cadatrar(rf);
        
    }

    public List<RequisicaoProduto> exibiRequisicao() throws IOException{
        return this.requisicaoF.exibiRequisicao();
   
    }
    
    public RequisicaoProduto pesquisaRequisicaoProduto(int id)
            throws ProcuraRFInexistenteExeception{
        RequisicaoProduto rf = this.requisicaoF.acharProduto(id);
        return rf;
    }
        
}
    

