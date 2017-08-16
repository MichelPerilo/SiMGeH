/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private Produto produto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        carregarInformações();
    }    
    
    
    public Stage getStage() {
        return stage;
    }

    
    public void setStage(Stage stage) {
        this.stage = stage;
        
    }
    
    public void setProduto(Produto p){
        produto = p;
    }
    
//    public void carregarInformações(){
//        
//        TXDescricao.setText(produto.getDescricao());
//        TXID.setText(Integer.toString(produto.getId()));
//        TXNome.setText(produto.getNome());
//        TXTipo.setText(produto.getTipo());
//        TXdata.setText(produto.getDataFormatada());
//        TXQTD.setText(Integer.toString(produto.getQtd()));
//        
//        
//        
//    }
    
    @FXML
    public void debitarProduto(){
        
//        Salva no relatorio o ID da requisição com a qtd.
        if(TXQTDDebitar != null && TXIDRequisixao != null)
          produto.debitarQTD(Integer.parseInt(TXQTDDebitar.getText()));
        
    }
    

    
}
