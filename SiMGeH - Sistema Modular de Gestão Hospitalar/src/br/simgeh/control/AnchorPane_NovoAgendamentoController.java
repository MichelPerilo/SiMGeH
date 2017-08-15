/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;



/**
 * FXML Controller class
 *
 * @author Michel Perilo
 */
public class AnchorPane_NovoAgendamentoController implements Initializable {

    
    @FXML
    private TextField input;
    @FXML
    private Stage stage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inicia();
    }    
    
    public void inicia(){
        IGerenciadorAnimal_A fachada = ControladorAnimal_A.getInstance();
        fachada.allAnimals();
        TextField.bindAutoCompletion(input, fachada.allAnimals());
        
        
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
