/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.exeception.CadastroAgendamentoExistenteException;
import br.simgeh.exeception.CadastroServicoExistenteException;
import br.simgeh.model.Agendamento;
import br.simgeh.model.Animal;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;



/**
 * FXML Controller class
 *
 * @author Michel Perilo
 */
public class AnchorPane_NovoAgendamento_ConsultaController implements Initializable {

    @FXML
    public TextField input;
    @FXML
    public DatePicker datepicker_data;
    @FXML
    public ChoiceBox txtfld_hora;
    @FXML
    public Button btn_agendar;
    @FXML
    public Button btn_salvar;
    @FXML
    private ChoiceBox choicebox_medico;
    
    private Agendamento agendamento;
    
    
    private Stage stage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        
            // TODO
            inicia();
            
            
        
    }    
    @FXML
    public void inicia(){
        IGerenciadorAnimal_A fachada = ControladorAnimal_A.getInstance();
        fachada.allAnimals();
        TextFields.bindAutoCompletion(getInput(), fachada.allAnimals());
        String[] horas = {"8:00", "8:20", "8:40", "9:00", "9:20", "9:40", "10:00", "14:00", "14:20", "14:40","15:00"};
         ObservableList<String> items = FXCollections.observableArrayList (horas);
        getTxtfld_hora().setItems(items);
        String[] medico = {"Clínica/ Dr. José da Silva", "Oftalmologia/ Dra. Suzana Oliveira", "Ortopedia/ Dr. Carlos Bezerra", "Ortopedia/ Dra. Carla Lira", "Clínica/ Dr. Marcos Silva"};
         ObservableList<String> medicos = FXCollections.observableArrayList (medico);
        getChoicebox_medico().setItems(medicos);
         
    }
    
   public void handlerAgendarConsulta() throws IOException, CadastroAgendamentoExistenteException, CadastroServicoExistenteException{
        IGerenciadorAgendamento fachada = new ControladorAgendamento().getInstance();
        getInput().getText();
        String data =  getDatepicker_data().getValue().toString();
        Animal animal = buscarAnimal(getInput().getText());
        String hora = getTxtfld_hora().getValue().toString();
        int tipo = 1;
        fachada.cadatrarAgendamento(animal ,  data , hora , tipo);
   }
   
   public void handlerSalvarConsulta() throws IOException{
       
       agendamento.setData(getDatepicker_data().getValue().toString());
       agendamento.setHora(getTxtfld_hora().getValue().toString());
   

   }
   
   public Animal buscarAnimal(String input){
       Animal resultado = null;
        IGerenciadorAnimal_A fachada = ControladorAnimal_A.getInstance();
         for(int i= 0; i< fachada.allAnimals().size(); i++){
             if (input.equals(fachada.allAnimals().get(i).toString())){
                 resultado =  fachada.allAnimals().get(i);
             }
         }
         return resultado;
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

    /**
     * @return the input
     */
    public TextField getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(TextField input) {
        this.input = input;
    }

    /**
     * @return the datepicker_data
     */
    public DatePicker getDatepicker_data() {
        return datepicker_data;
    }

    /**
     * @param datepicker_data the datepicker_data to set
     */
    public void setDatepicker_data(DatePicker datepicker_data) {
        this.datepicker_data = datepicker_data;
    }

    /**
     * @return the txtfld_hora
     */
    public ChoiceBox getTxtfld_hora() {
        return txtfld_hora;
    }

    /**
     * @param txtfld_hora the txtfld_hora to set
     */
    public void setTxtfld_hora(ChoiceBox txtfld_hora) {
        this.txtfld_hora = txtfld_hora;
    }

    /**
     * @return the agendamento
     */
    public Agendamento getAgendamento() {
        return agendamento;
    }

    /**
     * @param agendamento the agendamento to set
     */
    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    /**
     * @return the choicebox_medico
     */
    public ChoiceBox getChoicebox_medico() {
        return choicebox_medico;
    }

    /**
     * @param choicebox_medico the choicebox_medico to set
     */
    public void setChoicebox_medico(ChoiceBox choicebox_medico) {
        this.choicebox_medico = choicebox_medico;
    }
   
    
}
