package org.isep.dei.pl18.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.isep.dei.pl18.controller.AplicacaoController;
import org.isep.dei.pl18.model.ListaTarefas;

public class JanelaPrincipalUI implements Initializable {

    @FXML
    private TextArea txtAreaTarefas;
    @FXML
    private Button btnLimparTarefas;
    @FXML
    private Button btnAdicionarTarefas;

    private static final String BOTAO_ADICIONAR_TAREFA = "Adicionar Tarefa";
    private static final String BOTAO_LIMPAR_TAREFA = "Limpar Tarefas";
    private static final String CABECALHO_ERRO_FATAL = "Erro Fatal";
    private static final String CABECALHO_ERRO_FUNCAO = "Erro Função";
    private static final String TITULO_ALERTA = "Lista de Tarefas";
    private static final String TITULO_PALCO_NOVA_TAREFA = "Nova Tarefa";
    private static final String MENSAGEM_LISTA_VAZIA = "Lista de Tarefas Vazia";

//    private static final String BOTAO_ADICIONAR_TAREFA = "Add Task";
//    private static final String BOTAO_LIMPAR_TAREFA = "Remove Tasks";
//    private static final String CABECALHO_ERRO_FATAL = "Fatal Error";
//    private static final String CABECALHO_ERRO_FUNCAO = "Function Error";
//    private static final String TITULO_ALERTA = "Tasks List";
//    private static final String TITULO_PALCO_NOVA_TAREFA = "New Task";
//    private static final String MENSAGEM_LISTA_VAZIA = "Empty Tasks List";
    private AplicacaoController appController;

    private AdicionarTarefaUI adicionarTarefaUI;

    private Stage novaTarefaStage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarControlos();

        try {
            appController = new AplicacaoController();

            novaTarefaStage = new Stage();
            novaTarefaStage.initModality(Modality.APPLICATION_MODAL);

            novaTarefaStage.setTitle(TITULO_PALCO_NOVA_TAREFA);
            novaTarefaStage.setResizable(false);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarTarefaScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            novaTarefaStage.setScene(scene);
            novaTarefaStage.sizeToScene();

            novaTarefaStage.setOnHiding(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    adicionarTarefaUI.limparGUI();
                }
            });

            adicionarTarefaUI = loader.getController();
            adicionarTarefaUI.associarParentUI(this);

        } catch (Exception ex) {
            criarAlerta(Alert.AlertType.ERROR, CABECALHO_ERRO_FATAL, ex.getLocalizedMessage()).showAndWait();
            Platform.exit();
        }
    }

    public AplicacaoController getAplicacaoControler() {
        return appController;
    }

    public void atualizarListaTarefas() {
        txtAreaTarefas.setText(appController.getListaTarefas());

        btnLimparTarefas.setDisable(appController.listaVazia());
    }

    @FXML
    private void adicionarTarefaAction(ActionEvent event) {
        novaTarefaStage.show();
    }

    @FXML
    private void limparTarefasAction(ActionEvent event) {
        appController.eliminarTarefas();

        atualizarListaTarefas();
    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {
        if (event.isShortcutDown()) {
            if (!appController.listaVazia()) {
                if (event.getCode() == KeyCode.O) {
                    atualizarListaTarefas(ListaTarefas.ORDENACAO.INSERCAO);
                } else {
                    if (event.getCode() == KeyCode.P) {
                        atualizarListaTarefas(ListaTarefas.ORDENACAO.PRIORIDADE);
                    } else {
                        if (event.getCode() == KeyCode.Z) {
                            appController.eliminarUltimaTarefa();
                            atualizarListaTarefas();
                        }
                    }
                }
            } else {
                criarAlerta(Alert.AlertType.ERROR, CABECALHO_ERRO_FUNCAO, MENSAGEM_LISTA_VAZIA).show();
            }
        }
    }
    
    @FXML
    private void teclaRatoLibertadaAction(MouseEvent event) {
        //sim, tenho noção que há muito a melhorar neste código!
        if (event.getButton().equals(MouseButton.SECONDARY)) {
            ContextMenu cmEasterEgg = new ContextMenu();

            MenuItem miAdicionarTarefas = new MenuItem("Adicionar Tarefas com valores aleatorios");
            miAdicionarTarefas.setOnAction(action -> {
                appController.preencher();

                atualizarListaTarefas();
            });
            cmEasterEgg.getItems().add(miAdicionarTarefas);

            cmEasterEgg.show(((Node) event.getSource()).getScene().getWindow(), event.getScreenX(), event.getScreenY());
        }
    }

    private void iniciarControlos() {
        btnAdicionarTarefas.setText(BOTAO_ADICIONAR_TAREFA);
        btnLimparTarefas.setText(BOTAO_LIMPAR_TAREFA);

        btnAdicionarTarefas.setPrefWidth(txtAreaTarefas.getPrefWidth());
        btnLimparTarefas.setPrefWidth(txtAreaTarefas.getPrefWidth());
    }

    private void atualizarListaTarefas(ListaTarefas.ORDENACAO ordem) {
        txtAreaTarefas.setText(ordem == ListaTarefas.ORDENACAO.INSERCAO
                ? appController.getListaTarefas()
                : appController.getListaTarefasPorPrioridade()); //só há dois tipos de ordenação

        btnLimparTarefas.setDisable(appController.listaVazia());
    }

    private Alert criarAlerta(Alert.AlertType tipoAlerta, String cabecalho,
            String mensagem) {
        Alert alerta = new Alert(tipoAlerta);

        alerta.setTitle(TITULO_ALERTA);
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);

        return alerta;
    }
}
