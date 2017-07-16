/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Michel Perilo
 */
public class Vbox_LogonController implements Initializable {
    

    /**
     * Initializes the controller class.
     */

    
    
    @FXML
    private AnchorPane anchorpane_main; 
    @FXML
    private Menu menu_agendamento; 
    @FXML
    private Menu menu_administracao;
    @FXML
    private Menu menu_help;
    @FXML
    private Menu menu_clinica;
    @FXML
    private Menu menu_farmacia;
    @FXML
    private Menu menu_laboratorio; 
    @FXML
    private Menu menu_sair;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    public void handlerInicio() throws IOException{
        AnchorPane anchorpane_iniciar = (AnchorPane) FXMLLoader.load(getClass().getResource("/br/simgeh/gui/AnchorPane_Iniciar.fxml"));
        anchorpane_main.getChildren().setAll(anchorpane_iniciar);
        menu_agendamento.setVisible(true);
        menu_administracao.setVisible(true);
        menu_help.setVisible(false);
        menu_clinica.setVisible(true);
        menu_farmacia.setVisible(true);
        menu_laboratorio.setVisible(true);
        menu_sair.setVisible(true);
        
    }
    
}
