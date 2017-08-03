package br.simgeh.control;

import br.simgeh.exeception.CadatroProdutoExistenteExeception;
import br.simgeh.exeception.ProcuraProdutoInexistenteExeception;
import br.simgeh.model.Produto;
import java.io.IOException;

/**
 *
 * @author Raylison
 */

public class ControladorProduto implements IGerenciadorProduto{
    
    
     private  CadastroProduto produto = new CadastroProduto();
     private static IGerenciadorProduto instance;

    public static IGerenciadorProduto getInstance() {
        if (instance == null) {
            instance = new ControladorProduto();
        }
        return instance;
    }

   
    public void cadatrarProduto(String nome, String tipo, String descricao) throws IOException,
            CadatroProdutoExistenteExeception{

    Produto p = new Produto(nome,tipo,descricao);    
    this.produto.cadatrar(p);

    }

    public void exibiProduto() throws IOException {

        this.produto.exibiProduto();
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
}
