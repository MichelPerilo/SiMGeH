/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;


import br.simgeh.exeception.CadatroProdutoExistenteExeception;
import br.simgeh.exeception.ProcuraProdutoInexistenteExeception;
import br.simgeh.model.Produto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Raylison
 */
public class AnchorPane_FarmacoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane anchorpane_main; 
    @FXML
    private TextField textFieldBusca; 
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldQTD;
    @FXML
    private TextField textFieldTipo;
    @FXML
    private TextField textFieldDescricao;
    @FXML
    private Button ButtonOK;
    @FXML
    private Button ButtonNew;
    @FXML
    private Button ButtonDelete;
    
    private IGerenciadorProduto fachada;

    public AnchorPane_FarmacoController() {
        this.fachada = ControladorProduto.getInstance();
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void handlerBuscarProduto() throws IOException{
       Produto p;
        try {
            p = fachada.pesquisarProduto(textFieldBusca.getText());
        
          textFieldID.setText(Integer.toString(p.getId()));
          textFieldNome.setText(p.getNome());
          textFieldQTD.setText(Integer.toString(p.getQtd()));
          textFieldTipo.setText(p.getTipo());
          textFieldDescricao.setText(p.getDescricao());
       
          textFieldID.setEditable(false);
          textFieldNome.setEditable(false);
          textFieldQTD.setEditable(false);
          textFieldTipo.setEditable(false);
          textFieldDescricao.setEditable(false);
       
          textFieldBusca.setText("");
       

	} catch (ProcuraProdutoInexistenteExeception ppi) {
	    Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText(ppi.getMessage());
            alert.showAndWait();
	}
	     
    }
    
    
    public void handlerDeletarProduto() throws IOException{
       Produto p;
        try {
            fachada.excluirProduto(textFieldNome.getText());
            // colocar msagem de confirmação
        

	} catch (ProcuraProdutoInexistenteExeception ppi) {
	    Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText(ppi.getMessage());
            alert.showAndWait();
	}
	     
    }
    
    
    
    
    public void handlerCadastrarProduto() throws IOException{
       
        try {
        fachada.cadatrarProduto(textFieldNome.getText(),textFieldTipo.getText(),textFieldDescricao.getText(),Integer.parseInt(textFieldID.getText()),Integer.parseInt(textFieldQTD.getText()));
             
       
        textFieldID.setText("");
        textFieldNome.setText("");
        textFieldQTD.setText("");
        textFieldTipo.setText("");
        textFieldDescricao.setText("");
             

	} catch (CadatroProdutoExistenteExeception ppi) {
	    Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText(ppi.getMessage());
            alert.showAndWait();
	}
	 
    }
    
    
    
    
}




