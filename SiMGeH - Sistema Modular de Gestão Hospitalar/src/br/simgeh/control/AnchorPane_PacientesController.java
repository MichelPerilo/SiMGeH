/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.model.Animal;
import java.net.URL;
import static java.util.Collections.list;

import java.io.IOException;
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
        
        try {
			listar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }    
    
    public void listar() throws IOException{
        IGerenciadorAnimal_A fachada = ControladorAnimal_A.getInstance();
        ObservableList<Animal> items = FXCollections.observableArrayList (fachada.allAnimals());
        list.setItems(items);
    }

}
