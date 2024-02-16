package pt.isep.tp9.listatelefonica.ui;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserListaTelefonicaUI {
    private FileChooser fileChooser;

    private FileChooserListaTelefonicaUI() {
        fileChooser = new FileChooser();
        associarFiltro("Ficheiros Lista Telefónica", "*.ltf");
    }

    public static FileChooser criarFileChooserListaTelefonica() {
        FileChooserListaTelefonicaUI fcListaTelefonica = new FileChooserListaTelefonicaUI();
        return fcListaTelefonica.fileChooser;
    }

    private void associarFiltro(String descricao, String extensao) {
        ExtensionFilter filtro = new ExtensionFilter(descricao, extensao);
        fileChooser.getExtensionFilters().add(filtro);
    }
}