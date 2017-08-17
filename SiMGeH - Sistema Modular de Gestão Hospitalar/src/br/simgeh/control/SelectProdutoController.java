package br.simgeh.control;

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
}