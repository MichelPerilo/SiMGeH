/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.exeception.CadastroUsuarioExistenteException;
import br.simgeh.resources.TextFieldFormatter;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michel Perilo 
 */
public class AnchorPane_NovoUsuarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tfLogin;
    @FXML
    private TextField tfSenha;
    @FXML
    private TextField tfMat;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfSobrenome;
    @FXML
    private TextField tfDataNacto;
    @FXML
    private TextField tfCPF;
    @FXML
    private TextField tfCidade;
    @FXML
    private TextField tfBairro;
    @FXML
    private TextField tfLogradouro;
    @FXML
    private TextField tfNo;
    @FXML
    private TextField tfFone;
    @FXML 
    private ComboBox<String> acctTypeCbbx;
    ObservableList<String> listAccts_Type = FXCollections.observableArrayList("Administrador", "Recepcionista", "Técnico Laboratorial", "Médico");
    private Stage stage;
    Integer mat = 1; //número da matrícula.
    IGerenciadorUsuario facade = ControladorUsuario.getInstance();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       acctTypeCbbx.setItems(listAccts_Type);
    }

     //máscara do textField CPF.
    @FXML
    private void tfCPF_KeyReleased() {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("###.###.###-##");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(tfCPF);
    	tff.formatter();
    }
    
    //máscara do textField Fone Fixo.
    @FXML
    private void tfFoneFixo_KeyReleased() {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("(##)####-####");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(tfFone);
    	tff.formatter();
    }
    
     //máscara do textField Telefone Celular.
    @FXML
    private void tfDataNacto_KeyReleased() {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("##/##/####");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(tfDataNacto);
    	tff.formatter();
    }
    
    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void cadatrarUsuario(String Especialidade, int crmv, int MATRICULA, String login, String senha, Boolean admin, String pNome, String uNome, String CPF, Date dta_nascto, int tel_fixo, int tel_celular) throws IOException, CadastroUsuarioExistenteException{
        facade.cadatrarUsuario(Especialidade, 0, 0, login, senha, admin, pNome, uNome, CPF, dta_nascto, 0, 0);
    }
}