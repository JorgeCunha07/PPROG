package pt.isep.tp9.listatelefonica.ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import pt.isep.tp9.listatelefonica.controller.AplicacaoController;

public class JanelaPrincipalUI implements Initializable {
    private AplicacaoController appController;
    private Stage novoContactoStage;

    @FXML
    private TextArea txtAreaListaTelefonica;

    @FXML
    private MenuItem mnuContactosExportar;
    
    private static final String CABECALHO_IMPORTAR = "Importar Lista.";
    private static final String CABECALHO_EXPORTAR = "Exportar Lista.";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarNovoContactoScene.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            novoContactoStage = new Stage();
            novoContactoStage.initModality(Modality.APPLICATION_MODAL);
            novoContactoStage.setTitle("Novo Contacto");
            novoContactoStage.setResizable(false);
            novoContactoStage.setScene(scene);
            
            appController = new AplicacaoController();
            atualizaTextAreaListaTelefonica();
            
            AdicionarNovoContactoUI novoContactoUI = loader.getController();
            novoContactoUI.associarParentUI(this);
        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro.", ex.getMessage());
        }
    }

    public AplicacaoController getAplicacaoController() {
        return appController;
    }

    public void atualizaTextAreaListaTelefonica() {
        txtAreaListaTelefonica.setText(appController.getListaTelefonica());
    }

    @FXML
    private void mnuContactosNovoAction(ActionEvent event) throws IOException {
        novoContactoStage.show();
    }

    @FXML
    private void mnuListaShowing(Event event) {
        mnuContactosExportar.setDisable(appController.isListaTelefonicaVazia());
    }

    @FXML
    private void mnuContactosImportarAction(ActionEvent event) {
        FileChooser flChooser = FileChooserListaTelefonicaUI.criarFileChooserListaTelefonica();
        File ficheiroImportar = flChooser.showOpenDialog(txtAreaListaTelefonica.getScene().getWindow());

        if (ficheiroImportar != null) {
            int numeroContactosImportados = appController.ler(ficheiroImportar);
            if (numeroContactosImportados > 0) {
                atualizaTextAreaListaTelefonica();

                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                        String.format("%d contacto(s) importado(s).", numeroContactosImportados)).show();
            } else {
                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                        "Ficheiro sem contactos telefónicos para importar!").show();
            }
        } else {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_IMPORTAR,
                    "Não foi seleccionado nenhum ficheiro!").show();
        }
    }

    @FXML
    private void mnuContactosExportarAction(ActionEvent event) {
        FileChooser flChooser = FileChooserListaTelefonicaUI.criarFileChooserListaTelefonica();
        File ficheiroExportar = flChooser.showSaveDialog(txtAreaListaTelefonica.getScene().getWindow());

        if (ficheiroExportar != null) {
            if (appController.guardar(ficheiroExportar)) {
                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                        "Contactos exportados com sucesso.").show();
            } else {
                AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                        "Problema a exportar a lista de contactos!").show();
            }
        } else {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, CABECALHO_EXPORTAR,
                    "Não foi seleccionado nenhum ficheiro!").show();
        }
    }

    @FXML
    private void mnuContactosSairAction(ActionEvent event) {
        Window window = txtAreaListaTelefonica.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private void mnuOpcoesAcercaAction(ActionEvent event) {
        AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, "Acerca.",
                "@Copyright\nPPROG 2019/2020").show();
    }
}