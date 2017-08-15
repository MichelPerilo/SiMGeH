/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.model.Animal;
import java.net.URL;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Michel Perilo
 */
public class AnchorPane_PacientesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    private ListView list;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        listar();
    }    
    
    public void listar(){
        IGerenciadorAnimal_A fachada = ControladorAnimal_A.getInstance();
        fachada.allAnimals();
        ObservableList<Animal> items =FXCollections.observableArrayList (fachada.allAnimals());
        list.setItems(items);
    }

}
