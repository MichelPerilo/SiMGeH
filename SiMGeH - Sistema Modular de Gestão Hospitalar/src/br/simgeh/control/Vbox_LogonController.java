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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private Menu menu_help;

    @FXML
    private Button btn_entrar;
    
    @FXML 
    private ComboBox<String> acctTypeCbbx;
    
    ObservableList<String> listAccts_Type = FXCollections.observableArrayList("Administrador", "Recepcionista", "Técnico Laboratorial", "Médico");
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	acctTypeCbbx.setItems(listAccts_Type);
    }
    
    public void showAnchorPane_Inicio() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AnchorPane_InicioController.class.getResource("../views/AnchorPane_Inicio.fxml"));
        AnchorPane page = (AnchorPane) loader.load(); 
        
        Stage stage = new Stage();
        stage.setTitle("SiMGeH");
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
        stage.setResizable(false);
        
        AnchorPane_InicioController controller = loader.getController();
        controller.setInicioStage(stage);
        
        Stage selfscene = (Stage) btn_entrar.getScene().getWindow();
        selfscene.close();
        
        stage.showAndWait();
    }
}
