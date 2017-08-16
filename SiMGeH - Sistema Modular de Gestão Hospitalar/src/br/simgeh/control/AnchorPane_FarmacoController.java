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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


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
    @FXML
    private Button ButtonLimpar;
    
    
    @FXML
    private TableView<Produto> tableViewProduto;
    @FXML
    private TableColumn<Produto, String> tableColumnProdutoID;
    @FXML
    private TableColumn<Produto, String> tableColumnProdutoNome;
    @FXML
    private TableColumn<Produto, String> tableColumnProdutoQTD;
    @FXML
    private TableColumn<Produto, String> tableColumnProdutoTipo;
    @FXML
    private TableColumn<Produto, String> tableColumnProdutoDescricao;
            
    private ObservableList<Produto> observableListProduto;
                                    
    
    private IGerenciadorProduto fachada;
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            
            this.fachada = ControladorFarmaco.getInstance();
            carregarTableViewProdutos();
            
        } catch (IOException ex) {
            Logger.getLogger(AnchorPane_FarmacoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    @FXML
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
    
    @FXML
    public void handlerDeletarProduto() throws IOException{
       Produto p;
        try {
            Alert alert = new Alert(AlertType.WARNING);
            fachada.excluirProduto(textFieldNome.getText());
            alert.setHeaderText(textFieldNome.getText() + "   DELETADO COM SUCESSO");
            alert.showAndWait();
        textFieldID.setText("");
        textFieldNome.setText("");
        textFieldQTD.setText("");
        textFieldTipo.setText("");
        textFieldDescricao.setText("");
        carregarTableViewProdutos();

	} catch (ProcuraProdutoInexistenteExeception ppi) {
	    Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText(ppi.getMessage());
            alert.showAndWait();
	}
	     
    }
    
    
    
    @FXML
    public void handlerCadastrarProduto() throws IOException{
       
        try {
        Alert alert = new Alert(AlertType.WARNING);
        fachada.cadatrarProduto(textFieldNome.getText(),textFieldTipo.getText(),textFieldDescricao.getText(),Integer.parseInt(textFieldID.getText()),Integer.parseInt(textFieldQTD.getText()));
        alert.setHeaderText(textFieldNome.getText() + "   CADASTRADO COM SUCESSO");
        alert.showAndWait();   
        textFieldID.setText("");
        textFieldNome.setText("");
        textFieldQTD.setText("");
        textFieldTipo.setText("");
        textFieldDescricao.setText("");       
        carregarTableViewProdutos();

	} catch (CadatroProdutoExistenteExeception ppi) {
	    Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText(ppi.getMessage());
            alert.showAndWait();
	}
	 
    }
     
    
    @FXML
    public void handlerLimparBusca() throws IOException{
       

        textFieldBusca.setText("");
        textFieldID.setText("");
        textFieldNome.setText("");
        textFieldQTD.setText("");
        textFieldTipo.setText("");
        textFieldDescricao.setText(""); 
        

    }
    
    public void carregarTableViewProdutos() throws IOException {

        
        tableColumnProdutoID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnProdutoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnProdutoQTD.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        tableColumnProdutoTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tableColumnProdutoDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        
        observableListProduto = FXCollections.observableArrayList(fachada.exibiProduto());
        tableViewProduto.setItems(observableListProduto);
    }   
    
    
   
    
    public void showAnchorPane_SelectIntem() throws IOException{
        Produto p = tableViewProduto.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SelectProdutoController.class.getResource("../views/SelectProduto.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Stage produtoSelect = new Stage();
        Scene scene = new Scene(page);
        produtoSelect.setScene(scene);
        produtoSelect.setResizable(false);
        
        SelectProdutoController controller = loader.getController();
        controller.setProduto(p);
        controller.setStage(produtoSelect);       
        produtoSelect.showAndWait();
        
        
    }  

}
       
