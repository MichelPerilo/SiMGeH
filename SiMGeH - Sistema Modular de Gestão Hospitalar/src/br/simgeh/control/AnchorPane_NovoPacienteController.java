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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michel Perilo
 */
public class AnchorPane_NovoPacienteController implements Initializable {

  
    
    private Stage stage;
    
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
    
 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        String id = "1";
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
        }

        System.out.println("CADASTRO REALIZADO");
   }
   
    
}
