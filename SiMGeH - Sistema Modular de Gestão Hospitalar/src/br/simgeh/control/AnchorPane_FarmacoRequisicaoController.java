/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;


import br.simgeh.exeception.ProcuraRFInexistenteExeception;
import br.simgeh.model.RequisicaoProduto;
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
 * @author raylison.santos
 */
public class AnchorPane_FarmacoRequisicaoController implements Initializable {

    @FXML
    private TextField tfBuscar;
    @FXML
    private Button btOK;
    @FXML
    private Button btLimpar;
    @FXML
    private TableView<RequisicaoProduto> tableviewRequisicao;
    @FXML
    private TableColumn<RequisicaoProduto, String> tableviewColunmID;
    @FXML
    private TableColumn<RequisicaoProduto, String> tableviewColunmStatus;
    @FXML
    private TableColumn<RequisicaoProduto, String> tableviewColunmSetor;
    @FXML
    private TableColumn<RequisicaoProduto, String> tableviewColunmDescricao;

    private IGerenciadorFarmaco fachada;
    private ObservableList<RequisicaoProduto>  observableListRequisicaoProduto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
            this.fachada = ControladorFarmaco.getInstance();
            carregarTableViewRequisicoes();
        } catch (IOException ex) {
            Logger.getLogger(AnchorPane_FarmacoRequisicaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    public void handlerLimparBusca() throws IOException{
       

        tfBuscar.setText("");
            

    }
    
    @FXML
    public void handlerBuscarProduto() throws IOException{
       RequisicaoProduto rp;
        
        try {
            rp = fachada.pesquisaRequisicaoProduto(Integer.parseInt(tfBuscar.getText()));
            showAnchorPane_SelectIntemRequisicao(rp);
        } catch (ProcuraRFInexistenteExeception ex) {
            Logger.getLogger(AnchorPane_FarmacoRequisicaoController.class.getName()).log(Level.SEVERE, null, ex);
        }	
	     
    }
    
    
    public void carregarTableViewRequisicoes() throws IOException {

        
        tableviewColunmID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tableviewColunmStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableviewColunmSetor.setCellValueFactory(new PropertyValueFactory<>("setor"));
        tableviewColunmDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
                                                                                                                                                                                                    
        observableListRequisicaoProduto = FXCollections.observableArrayList(fachada.exibiRequisicao());
        tableviewRequisicao.setItems(observableListRequisicaoProduto);
    }
    
    
     @FXML
    public void clicarMouseItemListViewRequisicao() throws IOException {
        RequisicaoProduto r = tableviewRequisicao.getSelectionModel().getSelectedItem();
        showAnchorPane_SelectIntemRequisicao(r);
        
    }
    
    public void showAnchorPane_SelectIntemRequisicao(RequisicaoProduto r) throws IOException{
         
        
        FXMLLoader loader = new FXMLLoader();        
        loader.setLocation(SelectRequisicaoController.class.getResource("../views/SelectRequisicao.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
                 
        Stage requisicaoSelect = new Stage();
        requisicaoSelect.setTitle("Descrição de Requisição");
        Scene scene = new Scene(page);
        requisicaoSelect.setScene(scene);
        requisicaoSelect.setResizable(false);
        
        SelectRequisicaoController controller = loader.getController();
        
        controller.setTADescricao(r.getDescricao());
        controller.setTFid(Integer.toString(r.getID()));
        controller.setTFQTDSolicitada(Integer.toString(r.getQtd()));
        controller.setTFSetor(r.getSetor());
        
        
       
        controller.setStage(requisicaoSelect);       
        requisicaoSelect.showAndWait();
        
        
        
    }                                 
    
}
