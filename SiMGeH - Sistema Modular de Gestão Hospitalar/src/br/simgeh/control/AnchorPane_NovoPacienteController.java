/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michel Perilo
 */
public class AnchorPane_NovoPacienteController implements Initializable {

    private Stage stage; 
    @FXML 
    private ComboBox<String> especieCbbx;
    @FXML 
    private ComboBox<String> cidadeCbbx;
    @FXML
    private ToggleButton rdBtnSexM = new RadioButton();
    @FXML
    private ToggleButton rdBtnSexF = new RadioButton();
   
    
            
    ObservableList<String> listCidadeCbbx = FXCollections.observableArrayList("Recife", "Olinda", "Jaboatão", "Itapissuma");
    ObservableList<String> listEspecieCbbx = FXCollections.observableArrayList("Gato", "Cachorro");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        especieCbbx.setItems(listEspecieCbbx);
        cidadeCbbx.setItems(listCidadeCbbx);
        
        if(rdBtnSexF.isSelected())
            rdBtnSexM.setVisible(false);
    }    

    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
   
    
}
