package br.simgeh.control;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Raylison
 */
public class SelectRequisicaoController implements Initializable {

    @FXML
    private TextArea TADescricao;
    @FXML
    private TextArea TAJustificativa;
    @FXML
    private TextField TFid;
    @FXML
    private TextField TFQTDSolicitada;
    @FXML
    private TextField TFSetor;
    @FXML
    private ComboBox <String> cbStatus;
    @FXML
    private ComboBox <String> cbStatusFinal;
    @FXML
    private Button btEncerrar;
    @FXML
    private Stage stage;
    
     private List<String> listStatus = new ArrayList<>();

    private ObservableList<String> observableListStatus;
    
    private List<String> listStatusFinal = new ArrayList<>();

    private ObservableList<String> observableListStatusFinal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        carregarComboBoxStatus();
        carregarComboBoxStatusFinal();
    }    
     public Stage getStage() {
        return stage;
    }

    
    public void setStage(Stage stage) {
        this.stage = stage;
        
    }

    public void setTADescricao(String TADescricao) {
        this.TADescricao.setText(TADescricao);
    }

    

    public void setTFid(String TFid) {
        this.TFid.setText(TFid);
    }

    public void setTFQTDSolicitada(String TFQTDSolicitada) {
        this.TFQTDSolicitada.setText(TFQTDSolicitada);
    }

    public void setTFSetor(String TFSetor) {
        this.TFSetor.setText(TFSetor);
    }

    

    public void setBtEncerrar(Button btEncerrar) {
        this.btEncerrar = btEncerrar;
    }

    public TextArea getTAJustificativa() {
        return TAJustificativa;
    }

    public String getCbStatus() {
        return selecionarItemComboBoxStatus();
    }

    public String getCbStatusFinal() {
        return selecionarItemComboBoxStatusFinal();
    }
    
    
    
    
    public void carregarComboBoxStatus() {
        

        listStatus.add("Aberto");
        listStatus.add("Indevido");
        listStatus.add("Fechado");
        

        observableListStatus = FXCollections.observableArrayList(listStatus);

        cbStatus.setItems(observableListStatus);
    }

       
    public void carregarComboBoxStatusFinal() {
        

        listStatusFinal.add("Com sucesso");
        listStatusFinal.add("Sem sucesso");
      
        

        observableListStatusFinal = FXCollections.observableArrayList(listStatusFinal);

        cbStatusFinal.setItems(observableListStatusFinal);
    }

    @FXML
    public String selecionarItemComboBoxStatusFinal() {
        return  cbStatusFinal.getSelectionModel().getSelectedItem();
    }
        
    @FXML
    public String selecionarItemComboBoxStatus() {
        return  cbStatus.getSelectionModel().getSelectedItem();
    }
    
    
}
