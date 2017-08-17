/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

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
    @FXML
    private MenuItem menuitem_painelatendimentos;
    @FXML
    private MenuItem menuitem_farmaco_painel;
    @FXML
    private MenuItem menuitem_novoagendamento_consulta;
    @FXML
    private MenuItem menuitem_buscaragendamento;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            handlerInicio();
        } catch (IOException ex) {
            Logger.getLogger(AnchorPane_InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
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
    
    @FXML
    public void handlerNovoAgendamento_Consulta() throws IOException{
        showAnchorPane_NovoAgendamento_Consulta();
    }
    
    public void showAnchorPane_NovoAgendamento_Consulta() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AnchorPane_NovoAgendamento_ConsultaController.class.getResource("../views/AnchorPane_NovoAgendamento_Consulta.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Stage novoAgendamentoStage = new Stage();
        novoAgendamentoStage.setTitle("Nova Consulta");
        Scene scene = new Scene(page);
        novoAgendamentoStage.setScene(scene);
        novoAgendamentoStage.getIcons().add(new Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
        novoAgendamentoStage.setResizable(false);
        
        AnchorPane_NovoAgendamento_ConsultaController controller = loader.getController();
        controller.setStage(novoAgendamentoStage);
        
        novoAgendamentoStage.showAndWait();
    }
    
    
    public void handlerInicio() throws IOException{
        menu_agendamento.setVisible(true);
        menu_administracao.setVisible(true);
        menu_clinica.setVisible(true);
        menu_farmacia.setVisible(true);
        menu_laboratorio.setVisible(true);
        menu_sair.setVisible(true);
        
    }
    
    public void handlerBuscarAgendamento() throws IOException{
        AnchorPane anchorpane_buscaragendamento = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/AnchorPane_BuscarAgendamento.fxml"));
        anchorpane_main.getChildren().setAll(anchorpane_buscaragendamento);
    }
    
    public void handlerBuscarPaciente() throws IOException{
        AnchorPane anchorpane_iniciar = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/AnchorPane_Pacientes.fxml"));
        anchorpane_main.getChildren().setAll(anchorpane_iniciar);
    }
    @FXML
    public void handlerPainelAtendimentos() throws IOException{
        AnchorPane anchorpane_painel_medico = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/AnchorPane_PainelAtendimentos.fxml"));
       anchorpane_main.getChildren().setAll(anchorpane_painel_medico);
    }
    @FXML
    public void handlerFarmaco() throws IOException{
        AnchorPane anchorpane_farmaco = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/AnchorPane_Farmaco.fxml"));
       anchorpane_main.getChildren().setAll(anchorpane_farmaco);
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
