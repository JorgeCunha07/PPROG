package org.isep.dei.pl19.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.isep.dei.pl19.model.FicheiroListaTarefas;
import org.isep.dei.pl19.model.ListaTarefas;
import org.isep.dei.pl19.model.Prioridade;

public class AplicacaoController {

    private ListaTarefas lista;
    private FicheiroListaTarefas ficheiroListaTarefas;

    public AplicacaoController() {
        lista = new ListaTarefas();
        ficheiroListaTarefas = new FicheiroListaTarefas();
    }

    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        return lista.adicionarTarefa(descricao, prioridade);
    }

    public void eliminarTarefas() {
        lista.eliminarTarefas();
    }

    public boolean eliminarUltimaTarefa() {
        return lista.eliminarTarefa(lista.tamanho() - 1);
    }

    public boolean eliminarTarefa(String tarefaSelecionada) {
        return lista.eliminarTarefa(tarefaSelecionada);
    }

    public boolean listaVazia() {
        return lista.estaVazia();
    }

    public String getListaTarefas() {
        return lista.toString();
    }

    public List<String> getArrayListTarefas() {
        return Arrays.asList(lista.toString().split("\n"));
    }

    public String getListaTarefasPorPrioridade() {
        return lista.toStringOrdemPrioridades();
    }

    public List<String> getArrayListTarefasPorPrioridade() {
        return Arrays.asList(lista.toStringOrdemPrioridades().split("\n"));
    }
    
    public void preencher() {
        final int LIMITE_SUPERIOR = 15;
        lista.preencherLista((new Random()).nextInt(LIMITE_SUPERIOR) + 1);
    }

    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }
    
    public boolean guardarFicheiroTexto() {
        return ficheiroListaTarefas.guardarFicheiroTexto(lista);
    }
    
    public boolean guardarFicheiroBinario() {
        return ficheiroListaTarefas.guardarFicheiroBinario(lista);
    }

}
