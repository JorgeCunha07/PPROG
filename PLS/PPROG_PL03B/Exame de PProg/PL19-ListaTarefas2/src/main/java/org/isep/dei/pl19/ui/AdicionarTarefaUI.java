package org.isep.dei.pl19.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.isep.dei.pl19.controller.AplicacaoController;
import org.isep.dei.pl19.model.Prioridade;

public class AdicionarTarefaUI implements Initializable {

    @FXML
    private Button btnCriarTarefa;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblTarefa;
    @FXML
    private Label lblPrioridade;
    @FXML
    private TextField txtTarefa;
    @FXML
    private ComboBox<Prioridade> cmbPrioridade;

    private static final String LABEL_PRIORIDADE = "Prioridade";
    private static final String LABEL_TAREFA = "Tarefa";
    
    private static final String BOTAO_ADICIONAR_TAREFA = "Adicionar Tarefa";
    private static final String BOTAO_CANCELAR = "Cancelar";
    
    private static final String TITULO_ALERTA_NOVA_TAREFA = "Nova Tarefa";
    
    private static final String CABECALHO_VALORES_INVALIDOS = "Valores Inválidos";
    
    private static final String CABECALHO_ADICIONAR_TAREFA = "Adicionar Tarefa";
    private static final String MENSAGEM_TAREFA_ADICIONADA = "Tarefa adicionada com sucesso!";
    private static final String MENSAGEM_TAREFA_NAO_ADICIONADA = "Não foi possível adicionar a tarefa!";

//    private static final String LABEL_PRIORIDADE = "Priority";
//    private static final String LABEL_TAREFA = "Task";
//    private static final String BOTAO_ADICIONAR_TAREFA = "Add Task";
//    private static final String BOTAO_CANCELAR = "Cancel";
//    private static final String TITULO_ALERTA = "New Task";
//    private static final String CABECALHO_VALORES_INVALIDOS = "Invalido Values";
//    private static final String CABECALHO_ADICIONAR_TAREFA = "Add Task";
//    private static final String MENSAGEM_TAREFA_ADICIONADA = "Task successfully added!";
//    private static final String MENSAGEM_TAREFA_NAO_ADICIONADA = "The task could not be added!!";
    private JanelaPrincipalUI janelaPrincipalUI;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarControlos();
    }

    public void associarParentUI(JanelaPrincipalUI janelaPrincipalUI) {
        this.janelaPrincipalUI = janelaPrincipalUI;

        preencherPrioridades();
    }

    public void limparGUI() {
        txtTarefa.clear();
        cmbPrioridade.getSelectionModel().selectFirst();
    }

    @FXML
    private void criarTarefaAction(ActionEvent event) {
        try {
            AplicacaoController appController = janelaPrincipalUI.getAplicacaoControler();
            
            boolean adicionou = appController.adicionarTarefa(txtTarefa.getText().trim(), cmbPrioridade.getValue());

            if (adicionou) {
                janelaPrincipalUI.atualizarListaTarefas();
            }
            AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, TITULO_ALERTA_NOVA_TAREFA, 
                    CABECALHO_ADICIONAR_TAREFA,
                    adicionou ? MENSAGEM_TAREFA_ADICIONADA
                            : MENSAGEM_TAREFA_NAO_ADICIONADA).show();

            cancelarAction(event);

        } catch (IllegalArgumentException iae) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR,  TITULO_ALERTA_NOVA_TAREFA,
                    CABECALHO_VALORES_INVALIDOS, iae.getMessage()).show();
        }
    }

    @FXML
    private void cancelarAction(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
//        ((Stage) btnCancelar.getScene().getWindow()).hide();
    }

    private void iniciarControlos() {
        lblPrioridade.setText(LABEL_PRIORIDADE);
        lblTarefa.setText(LABEL_TAREFA);

        btnCriarTarefa.setText(BOTAO_ADICIONAR_TAREFA);
        btnCancelar.setText(BOTAO_CANCELAR);
    }

    private void preencherPrioridades() {
        cmbPrioridade.getItems().setAll(janelaPrincipalUI.getAplicacaoControler().getPrioridades());
        cmbPrioridade.getSelectionModel().selectFirst();
    }
}
