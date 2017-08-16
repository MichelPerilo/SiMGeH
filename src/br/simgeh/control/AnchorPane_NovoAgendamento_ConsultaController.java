/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;



/**
 * FXML Controller class
 *
 * @author Michel Perilo
 */
public class AnchorPane_NovoAgendamento_ConsultaController implements Initializable {

    @FXML
    private TextField input;
    
    
    private Stage stage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        
            // TODO
            inicia();
            
            
        
    }    
    @FXML
    public void inicia(){
        IGerenciadorAnimal_A fachada = ControladorAnimal_A.getInstance();
        fachada.allAnimals();
        TextFields.bindAutoCompletion(input, fachada.allAnimals());
        /*String[] servicos = {"Consullta", "Cirurgia", "Exame"};
        ObservableList<String> items =FXCollections.observableArrayList (servicos);
        chbox_servico.setItems(items);
        */
          
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
