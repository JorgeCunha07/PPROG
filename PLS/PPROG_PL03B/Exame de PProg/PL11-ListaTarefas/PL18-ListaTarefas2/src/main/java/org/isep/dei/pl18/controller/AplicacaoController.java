package org.isep.dei.pl18.controller;

import java.util.Random;
import org.isep.dei.pl18.model.ListaTarefas;
import org.isep.dei.pl18.model.Prioridade;

public class AplicacaoController {
    private ListaTarefas lista;
    
    public AplicacaoController() {
        lista = new ListaTarefas();
    }
    
    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        return lista.adicionarTarefa(descricao, prioridade);
    }
    
    public void eliminarTarefas() {
        lista.eliminarTarefas();
    }
    
    public boolean eliminarUltimaTarefa() {
        return lista.eliminarTarefa(lista.tamanho()-1);
    }
    
    public boolean listaVazia() {
        return lista.estaVazia();
    }
    
    public String getListaTarefas() {
        return lista.toString();
    }
    
    public String getListaTarefasPorPrioridade() {
        return lista.toStringOrdemPrioridades();
    }

    public void preencher() {
        final int limSuperior = 15;
        lista.preencherLista((new Random()).nextInt(limSuperior)+1);
    }
    
    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }
}
