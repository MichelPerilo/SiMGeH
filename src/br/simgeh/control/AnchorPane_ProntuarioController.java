/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Michel Perilo
 */
public class AnchorPane_ProntuarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
   @FXML
    private AnchorPane anchorpane_prontuario;
    
    @FXML
    private Button btn_consulta;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void handlerListaAtendimentos() throws IOException{
        AnchorPane anchorpane_dadosconsulta = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/AnchorPane_DadosConsulta.fxml"));
       anchorpane_prontuario.getChildren().setAll(anchorpane_dadosconsulta);
    }
    
    
}
