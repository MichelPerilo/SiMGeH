/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.exeception.CadastroAnimalExistenteException;
import br.simgeh.exeception.CadastroEnderecoExistenteException;
import br.simgeh.exeception.CadastroProntuarioExistenteException;
import br.simgeh.exeception.CadastroTutorExistenteException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.ToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michel Perilo
 */
public class AnchorPane_NovoPacienteController implements Initializable {

    private Stage stage; 
    @FXML 
    private ComboBox<String> especieCbbx;
    @FXML 
    private ComboBox<String> cidadeCbbx;
    @FXML
    private ToggleButton rdBtnSexM = new RadioButton();
    @FXML
    private ToggleButton rdBtnSexF = new RadioButton();
    @FXML 
    private TextField dtaAtualLbl;
    
            
    private ObservableList<String> listCidadeCbbx = FXCollections.observableArrayList("Recife", "Olinda", "Jaboatão", "Itapissuma");
    private ObservableList<String> listEspecieCbbx = FXCollections.observableArrayList("Gato", "Cachorro");
    private Calendar dtaAtual = Calendar.getInstance();
    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
	String a = s.format(dtaAtual.getTime());
    
    @FXML
    private TextField txtfld_nome;
    @FXML
    private TextField txtfld_nometutor;
    @FXML
    private TextField txtfld_cpf;
    @FXML
    private TextField txtfld_fone1;
    @FXML
    private Button btn_gerarregistro;
    
    Integer i=1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        especieCbbx.setItems(listEspecieCbbx);
        cidadeCbbx.setItems(listCidadeCbbx);
        dtaAtualLbl.setText(a);
        dtaAtualLbl.setDisable(true); //desativa o text field para ser somente leitura.
        
        if(rdBtnSexF.isSelected()) {
            rdBtnSexM.setVisible(false);
        }    
        else if(rdBtnSexM.isSelected()) {
        	rdBtnSexF.setVisible(false);
        }
        	
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
    
    @FXML
    private void handlerGerarRegistro(){
       
        IGerenciadorAnimal_A fachada = ControladorAnimal_A.getInstance();
         i++;
        String id = i.toString();
        String especie = "dog";
        String nome = this.txtfld_nome.getText();
        String sexo = "masc";
        int dta_nascto = 150296;
        float peso = 12;
        String porte = "medio";
        String pelagem = "curto";
        String nome_tutor = this.txtfld_nometutor.getText();
        String cpf = this.txtfld_cpf.getText();
        String fone_1 = this.txtfld_fone1.getText();
        String fone_2 = "33254422";
        String cidade = "Recife";
        String bairro = "Ipsep";
        String logradouro = "Rua Manoel Medeiros";
        int numero = 225;
        
   
  
        try {
            fachada.cadatrarAnimal(id, especie, nome, sexo, dta_nascto, peso, porte,  pelagem,  nome_tutor,  cpf,  fone_1,  fone_2 , cidade,  bairro,  logradouro, numero);
        } catch (IOException ex) {
            Logger.getLogger(AnchorPane_NovoPacienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CadastroAnimalExistenteException ex) {
            Logger.getLogger(AnchorPane_NovoPacienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CadastroProntuarioExistenteException ex) {
            Logger.getLogger(AnchorPane_NovoPacienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CadastroEnderecoExistenteException ex) {
            Logger.getLogger(AnchorPane_NovoPacienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CadastroTutorExistenteException ex) {
            Logger.getLogger(AnchorPane_NovoPacienteController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            handlerConfirmacao();
             
        }

      
        
   }
   
    private void handlerConfirmacao(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setHeaderText("NOVO PACIENTE CADASTRADO COM SUCESSO");
        alert.setTitle("Paciente Cadastrado");
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    	    // ... user chose OK
    		stage.close();
    		
    	} else {
    	    // ... user chose CANCEL or closed the dialog
    	}
    }
    
}
