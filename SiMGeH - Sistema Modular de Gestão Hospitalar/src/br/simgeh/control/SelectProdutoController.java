package br.simgeh.control;

import br.simgeh.model.Produto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Raylison
 */
public class SelectProdutoController implements Initializable {

    @FXML
    private Button BTLiberarFarmaco;
    @FXML
    private TextField TXdata;
    @FXML
    private TextField TXID;
    @FXML
    private TextField TXNome;
    @FXML
    private TextField TXTipo;
    @FXML
    private TextField TXQTD;
    @FXML
    private TextField TXDescricao;
    @FXML
    private TextField TXIDRequisixao;
    
    @FXML
    private TextField TXQTDDebitar;
    @FXML
    private Stage stage;
    
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
    }    
    
    
    public Stage getStage() {
        return stage;
    }

    
    public void setStage(Stage stage) {
        this.stage = stage;
        
    }
    
    
    
    @FXML
    public void carregarInformações(Produto produto){
    
        
        if(produto != null){
        TXDescricao.setText(produto.getDescricao());
        TXID.setText(Integer.toString(produto.getId()));
        TXNome.setText(produto.getNome());
        TXTipo.setText(produto.getTipo());
        TXdata.setText(produto.getDataFormatada());
        TXQTD.setText(Integer.toString(produto.getQtd()));
        }
        
        
    }

    public void setTXdata(String TXdata) {
        this.TXdata.setText(TXdata);
    }

    public void setTXID(String TXID) {
        this.TXID.setText(TXID);
    }

    public void setTXNome(String TXNome) {
        this.TXNome.setText(TXNome);
    }

    public void setTXTipo(String TXTipo) {
        this.TXTipo.setText(TXTipo);
    }

    public void setTXQTD(String TXQTD) {
        this.TXQTD.setText(TXQTD);
    }

    public void setTXDescricao(String TXDescricao) {
        this.TXDescricao.setText(TXDescricao);
    }
    
    @FXML
    public void debitarProduto(){
        
//        Salva no relatorio o ID da requisição com a qtd.
      //  if(TXQTDDebitar != null && TXIDRequisixao != null)
          //produto.debitarQTD(Integer.parseInt(TXQTDDebitar.getText()));
        
    }
    

    
}
