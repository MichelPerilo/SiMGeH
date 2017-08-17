/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.control;

import br.simgeh.model.Agendamento;
import br.simgeh.model.Consulta;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michel
 */
public class AnchorPane_BuscarAgendamentoController implements Initializable {

    @FXML
    private CheckBox checkbox_consultas;
    @FXML
    private CheckBox checkbox_procirurgico;
    @FXML
    private CheckBox checkbox_exames;
    @FXML
    private Button btn_atualizar;
    @FXML
    private ListView listview_listaagendamentos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    public void handlerAtualizar(){
         IGerenciadorAgendamento fachada = new ControladorAgendamento().getInstance(); 
         fachada.allAgendamentos();
         ArrayList<Agendamento> consultas;
         ArrayList<Agendamento> exames;
         ArrayList<Agendamento> proc_cirurgico;
         
      
         if(checkbox_consultas.isSelected()){
             ObservableList<Agendamento> items = FXCollections.observableArrayList (  filtroServico_Consultas(fachada));
            
             listview_listaagendamentos.setItems(items);
            
         }
    }
    @FXML
    public void handlerClicarAgendamento() throws IOException, ParseException{
        Agendamento a  = (Agendamento) listview_listaagendamentos.getSelectionModel().getSelectedItem();
             showAnchorPane_NovoAgendamento_Consulta(a);
    }
    
    public void showAnchorPane_NovoAgendamento_Consulta(Agendamento a) throws IOException, ParseException{
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(a.getData(),formatter);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AnchorPane_NovoAgendamento_ConsultaController.class.getResource("../views/AnchorPane_NovoAgendamento_Consulta.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Stage novoAgendamentoStage = new Stage();
        novoAgendamentoStage.setTitle("Editar Consulta");
        Scene scene = new Scene(page);
        novoAgendamentoStage.setScene(scene);
        novoAgendamentoStage.setResizable(false);
        
        AnchorPane_NovoAgendamento_ConsultaController controller = loader.getController();
        controller.setStage(novoAgendamentoStage);
        controller.txtfld_hora.setValue(a.getHora());
        controller.input.setText(a.getAnimal().toString());
        controller.datepicker_data.setValue(date);
        controller.btn_agendar.setText("Salvar");
        
        novoAgendamentoStage.showAndWait();
    }
    
    public ArrayList<Agendamento> filtroServico_Consultas(IGerenciadorAgendamento fachada){
        fachada.allAgendamentos();
        ArrayList<Agendamento> consultas = new ArrayList();
         
         for(int i= 0; i< fachada.allAgendamentos().size(); i++){
             if ((fachada.allAgendamentos().get(i).getServico()) instanceof Consulta){
                 consultas.add(fachada.allAgendamentos().get(i));
                 
             }
         }
         
        return consultas;
    }
    
}
