/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.run;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;

/**
 *
 * @author Michel Perilo
 */
public class Main extends Application {
    
    Stage window;
    
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("SiMGeH");
        Parent root = FXMLLoader.load(getClass().getResource("gui/Vbox_Logon.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("qms_v2_h_rgb.png")));
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
