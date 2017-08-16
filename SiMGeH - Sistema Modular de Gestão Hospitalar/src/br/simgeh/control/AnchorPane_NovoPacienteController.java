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
import java.util.logging.Level;
import java.util.logging.Logger;

import br.simgeh.exeception.CadastroAnimalExistenteException;
import br.simgeh.exeception.CadastroEnderecoExistenteException;
import br.simgeh.exeception.CadastroProntuarioExistenteException;
import br.simgeh.exeception.CadastroTutorExistenteException;
import br.simgeh.resources.TextFieldFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
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
    private ComboBox<String> bairroCbbx;
    @FXML
    private ComboBox<String> genderCbbx;
    @FXML
    private ComboBox<String> pelageCbbx;
    @FXML
	private ComboBox<String> porteCbbx;
    @FXML 
    private TextField dtaAtualTxtField;
    @FXML
    private TextField idAnimalTxtField;
    @FXML
    private TextField wheightTxtField;
    @FXML
    private TextField txtfld_nome;
    @FXML
    private TextField txtfld_nometutor;
    @FXML
    private TextField txtfld_cpf;
    @FXML
    private TextField txtfld_foneFixo;
    @FXML
    private TextField txtfld_Celular;
    @FXML 
    private TextField txtfld_Logradouro;
    @FXML 
    private TextField txtfld_No;
    @FXML
    private Button btn_gerarregistro;
            
    private ObservableList<String> listCidadeCbbx = FXCollections.observableArrayList("Recife", "Olinda", "Jaboatão", "Itapissuma");
    private ObservableList<String> listBairro = FXCollections.observableArrayList("Ibura", "Casa Amarela", "Rio Doce", "Cordeiro", "Boa Viagem");
    private ObservableList<String> listEspecieCbbx = FXCollections.observableArrayList("Gato", "Cachorro");
    private ObservableList<String> listGender = FXCollections.observableArrayList("Macho", "Fêmea");
    private ObservableList<String> listPelage = FXCollections.observableArrayList("Malhado Laranja", "Preto", "Branco", "Pêlo Curto", "Pêlo Longo", "Pelagem Média");
    private ObservableList<String> listPorte = FXCollections.observableArrayList("Pequeno Porte", "Médio Porte", "Grande Porte");
    private Calendar dtaAtual = Calendar.getInstance();
    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
	String a = s.format(dtaAtual.getTime());
	IGerenciadorAnimal_A facade = ControladorAnimal_A.getInstance();
    
    
    Integer i=1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	dtaAtualTxtField.setText(a);
    	dtaAtualTxtField.setDisable(true); //desativa o text field para ser somente leitura.
        especieCbbx.setItems(listEspecieCbbx);
        cidadeCbbx.setItems(listCidadeCbbx);
        bairroCbbx.setItems(listBairro);
        idAnimalTxtField.setText(i.toString());
        genderCbbx.setItems(listGender);
        pelageCbbx.setItems(listPelage);
        porteCbbx.setItems(listPorte);
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
    
    //máscara do textField CPF.
    @FXML
    private void tfCPF_KeyReleased() {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("###.###.###-##");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtfld_cpf);
    	tff.formatter();
    }
    
  //máscara do textField Fone Fixo.
    @FXML
    private void tfFoneFixo_KeyReleased() {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("(##)####-####");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtfld_foneFixo);
    	tff.formatter();
    }
    
    //máscara do textField Telefone Celular.
    @FXML
    private void tfCelular_KeyReleased() {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("(##)#####-####");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(txtfld_Celular);
    	tff.formatter();
    }
    
    @FXML
    private void handlerGerarRegistro(){
        /*String id = i.toString();
        String especie = "dog";
        String nome = this.txtfld_nome.getText();
        String sexo = "masc";
        int dta_nascto = 150296;
        float peso = 12;
        String porte = "medio";
        String pelagem = "curto";
        String nome_tutor = this.txtfld_nometutor.getText();
        String cpf = this.txtfld_cpf.getText();
        String foneFixo = this.txtfld_foneFixo.getText();
        String celular = "33254422";
        String cidade = "Recife";
        String bairro = "Ipsep";
        String logradouro = "Rua Manoel Medeiros";
        int numero = 225;*/
        
        //pegando os dados da janela
        String especie = this.especieCbbx.getValue();
        String id = i.toString();
        String nome = this.txtfld_nome.getText();
        String sexo = this.genderCbbx.getValue();
        int dta_nascto = 150296;
        String pesoStr = this.wheightTxtField.getText();
        Float peso = Float.parseFloat(pesoStr);
        String porte = porteCbbx.getValue();
        String pelagem = pelageCbbx.getValue();
        String nome_tutor = this.txtfld_nometutor.getText();
        String cpf = this.txtfld_cpf.getText();
        String foneFixo = this.txtfld_foneFixo.getText();
        String celular = this.txtfld_Celular.getText();
        String cidade = this.cidadeCbbx.getValue();
        String bairro = this.bairroCbbx.getValue();
        String logradouro = this.txtfld_Logradouro.getText();
        String numeroStr = this.txtfld_No.getText();
        int numero = Integer.parseInt(numeroStr);
        
        try {
            facade.cadatrarAnimal(id, especie, nome, sexo, dta_nascto, peso, porte,  pelagem,  nome_tutor,  cpf,  foneFixo,  celular , cidade,  bairro,  logradouro, numero);
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
