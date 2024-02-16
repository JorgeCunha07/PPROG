package pt.isep.tp9.listatelefonica.controller;

import java.io.File;
import pt.isep.tp9.listatelefonica.model.FicheiroListaTelefonica;
import pt.isep.tp9.listatelefonica.model.ListaTelefonica;

public class AplicacaoController {
    private ListaTelefonica listaTelefonica;
    private FicheiroListaTelefonica ficheiroListaTelefonica;
            
    public AplicacaoController() {
        ficheiroListaTelefonica = new FicheiroListaTelefonica();
        ler();
    }

    public String getListaTelefonica() {
        return listaTelefonica.toString();
    }

    public boolean adicionarContactoTelefonico(String titular, int numero) {
        return listaTelefonica.adicionarContactoTelefonico(titular, numero);
    }

    public boolean isListaTelefonicaVazia() {
        return listaTelefonica.isVazia();
    }

    public void ler() {
        listaTelefonica = ficheiroListaTelefonica.ler();        
    }

    public int ler(File ficheiroImportar) {
        ListaTelefonica listaTelefonicaImportada = ficheiroListaTelefonica.ler(ficheiroImportar);
        return listaTelefonica.adicionarListaTelefonica(listaTelefonicaImportada);
    }

    public boolean guardar() {
        return ficheiroListaTelefonica.guardar(listaTelefonica);
    }

    public boolean guardar(File ficheiroExportar) {
        return ficheiroListaTelefonica.guardar(ficheiroExportar, listaTelefonica);
    }
}