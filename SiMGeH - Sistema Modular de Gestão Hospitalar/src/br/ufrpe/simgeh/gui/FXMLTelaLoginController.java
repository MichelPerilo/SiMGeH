/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.simgeh.gui;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Michel Perilo
 */
public class FXMLTelaLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ObservableList<String> chbox_modulo_list = FXCollections.observableArrayList("Agendamento", "Clinica", "Farmácia");
    
    
    @FXML
    private ChoiceBox<String> chbox_modulo;
    @FXML
    private Label lbl_login;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chbox_modulo.setValue("Agendamento");
        chbox_modulo.setItems(chbox_modulo_list);
    }
    
}
