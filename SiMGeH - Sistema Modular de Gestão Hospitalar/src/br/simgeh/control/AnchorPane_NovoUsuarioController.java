/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michel Perilo 
 */
public class AnchorPane_NovoUsuarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    //private ComboBox<String> acctTypeCbbx;
    
    //ObservableList<String> listAccts_Type = FXCollections.observableArrayList("Administrador", "Recepcionista", "Técnico Laboratorial", "Médico");
    
    
    private Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //acctTypeCbbx.setItems(listAccts_Type);
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
