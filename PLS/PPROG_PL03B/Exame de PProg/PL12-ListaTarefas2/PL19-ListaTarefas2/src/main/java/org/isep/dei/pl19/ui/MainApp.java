package org.isep.dei.pl19.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.isep.dei.pl19.controller.AplicacaoController;

public class MainApp extends Application {

    private static final String LABEL_TITULO_APLICACAO = "Lista de Tarefas";
//    private static final String LABEL_TITULO_APLICACAO ="Tasks List";

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JanelaPrincipalScene.fxml"));
        Parent root = loader.load();


        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle(LABEL_TITULO_APLICACAO);
        stage.setScene(scene);

        stage.sizeToScene();
        stage.setResizable(false);

        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
