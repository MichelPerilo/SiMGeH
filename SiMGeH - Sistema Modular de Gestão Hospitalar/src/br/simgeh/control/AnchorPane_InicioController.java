/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
public class AnchorPane_InicioController implements Initializable {
    

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
    private Menu menu_clinica;
    @FXML
    private Menu menu_farmacia;
    @FXML
    private Menu menu_laboratorio; 
    @FXML
    private Menu menu_sair;
    @FXML
    private MenuItem menuitem_sair;
    private Stage inicioStage;
    @FXML
    private MenuItem menuitem_novousuario;
    @FXML
    private MenuItem menuitem_novopaciente;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            handlerInicio();
        } catch (IOException ex) {
            Logger.getLogger(AnchorPane_InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    /**
     * @author Bartoh
     */
    @FXML
    public void sair() throws IOException {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("Sair");
    	alert.setContentText("Deseja sair do sistema?");
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    	    // ... user chose OK
    		inicioStage.close();
    		
    	} else {
    	    // ... user chose CANCEL or closed the dialog
    	}
    }
    
    @FXML
    public void handlerNovoPaciente() throws IOException{
        showAnchorPane_NovoPaciente();
    }
    
    public void showAnchorPane_NovoPaciente() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AnchorPane_NovoPacienteController.class.getResource("../views/AnchorPane_NovoPaciente.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Stage novoPacienteStage = new Stage();
        novoPacienteStage.setTitle("Novo Paciente");
        Scene scene = new Scene(page);
        novoPacienteStage.setScene(scene);
        novoPacienteStage.getIcons().add(new Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
        novoPacienteStage.setResizable(false);
        
        AnchorPane_NovoPacienteController controller = loader.getController();
        controller.setStage(novoPacienteStage);
        
        novoPacienteStage.showAndWait();
    }
    
    
    public void handlerInicio() throws IOException{
        menu_agendamento.setVisible(true);
        menu_administracao.setVisible(true);
        menu_clinica.setVisible(true);
        menu_farmacia.setVisible(true);
        menu_laboratorio.setVisible(true);
        menu_sair.setVisible(true);
        
    }
    
    public void handlerBuscarPaciente() throws IOException{
        AnchorPane anchorpane_iniciar = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/AnchorPane_Pacientes.fxml"));
        anchorpane_main.getChildren().setAll(anchorpane_iniciar);
    }

    @FXML
    public void handlerNovoUsuario() throws IOException{
        showAnchorPane_NovoUsuario();
    }
    
    public void showAnchorPane_NovoUsuario() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AnchorPane_NovoUsuarioController.class.getResource("../views/AnchorPane_NovoUsuario.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Stage novoUsuarioStage = new Stage();
        novoUsuarioStage.setTitle("Novo Usuário");
        Scene scene = new Scene(page);
        novoUsuarioStage.setScene(scene);
        novoUsuarioStage.getIcons().add(new Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
        novoUsuarioStage.setResizable(false);
        
        AnchorPane_NovoUsuarioController controller = loader.getController();
        controller.setStage(novoUsuarioStage);
        
        novoUsuarioStage.showAndWait();
        
        
    }
    
    /**
     * @return the inicioStage
     */
    public Stage getInicioStage() {
        return inicioStage;
    }

    /**
     * @param inicioStage the inicioStage to set
     */
    public void setInicioStage(Stage inicioStage) {
        this.inicioStage = inicioStage;
    }
    
}
