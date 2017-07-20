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
import javafx.scene.control.ChoiceBox;
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
    private AnchorPane anchorpane_main; 
    @FXML
    private Menu menu_agendamento; 
    @FXML
    private MenuItem menuitem_novoagedamento;
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
    @FXML
    private MenuItem menuitem_sair;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
   public void handlerSair() throws IOException {
      boolean buttonconfirmar_clicked = showAnchorPane_DialogSair(); 
      if(buttonconfirmar_clicked){
      
      }
    } 
    
    public boolean showAnchorPane_DialogSair() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AnchorPane_DialogSairController.class.getResource("/br/simgeh/gui/AnchorPane_DialogSair.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Confirmação");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.getIcons().add(new Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
        dialogStage.setResizable(false);
        
        AnchorPane_DialogSairController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        
        dialogStage.showAndWait();
        
        return controller.isButtonSimClicked();
        
    }
    
    public void handlerNovoAgendamento() throws IOException{
      
    }
    
    public void handlerInicio() throws IOException{
      
        
    }
    
}
