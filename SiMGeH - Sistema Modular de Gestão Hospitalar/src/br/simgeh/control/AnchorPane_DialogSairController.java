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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author miche
 */
public class AnchorPane_DialogSairController implements Initializable {

   
    @FXML
    private Button btn_dialogsair_sim;
    @FXML
    private Button btn_dialogsair_cancelar;
    
    private Stage dialogStage;
    private Boolean buttonconfirmar_clicked;
    
    
   
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void handlerButtonSim() throws IOException{
        buttonconfirmar_clicked = true;
        getDialogStage().close();
    }
    
    public void handlerButtonCancelar() throws IOException{
        getDialogStage().close();
    }
    
    public boolean isButtonSimClicked(){
    return buttonconfirmar_clicked;
    }

    /**
     * @return the dialogStage
     */
    public Stage getDialogStage() {
        return dialogStage;
    }

    /**
     * @param dialogStage the dialogStage to set
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
}
