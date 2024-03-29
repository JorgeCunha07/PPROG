package org.isep.dei.pl19.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ListaTarefas implements Serializable {

    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }

    private List<Tarefa> listaTarefas;

    public ListaTarefas() {
        listaTarefas = new ArrayList<>();
    }

    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        Tarefa tarefa = new Tarefa(descricao, prioridade);
        return listaTarefas.contains(tarefa) ? false
                : listaTarefas.add(tarefa);
    }

    public boolean estaVazia() {
        return listaTarefas.isEmpty();
    }

    public void eliminarTarefas() {
        listaTarefas.clear();
    }

    public boolean eliminarTarefa(int pos) {
        return listaTarefas.remove(listaTarefas.get(pos));
    }

    public boolean eliminarTarefa(String tarefa) {
        Iterator<Tarefa> iteradorTarefa = listaTarefas.iterator();
        int i = 0;

        while (iteradorTarefa.hasNext() && !iteradorTarefa.next().toString().equalsIgnoreCase(tarefa)) {
            i++;
        }

        if (iteradorTarefa.hasNext()) {
            return eliminarTarefa(i);
        }

        return false;
    }

    public int tamanho() {
        return listaTarefas.size();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Iterator<Tarefa> iteradorTarefa = listaTarefas.iterator(); iteradorTarefa.hasNext();) {
            s.append(iteradorTarefa.next());
            s.append("\n");
        }

        return s.toString().trim();
    }

    public String toStringOrdemPrioridades() {
        List<Tarefa> copia = new ArrayList<>(listaTarefas);

        Collections.sort(copia, Collections.reverseOrder());
        StringBuilder s = new StringBuilder();

        for (Iterator<Tarefa> iteradorTarefa = copia.iterator(); iteradorTarefa.hasNext();) {
            s.append(iteradorTarefa.next());
            s.append("\n");
        }

        return s.toString().trim();
    }

    public void preencherLista(int tam) {
        int numberItems = listaTarefas.size();
        for (int i = 0; i < tam; i++) {
            adicionarTarefa(String.format("t%03d", numberItems + i),
                    Prioridade.values()[new Random().nextInt(Prioridade.values().length)]);
        }
    }
}
