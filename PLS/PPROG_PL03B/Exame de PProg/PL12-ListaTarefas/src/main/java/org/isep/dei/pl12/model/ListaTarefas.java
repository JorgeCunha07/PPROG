package org.isep.dei.pl12.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaTarefas implements Serializable {

    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }
    // Creating a list of tasks.
    private List<Tarefa> listaTarefas;

    // The constructor of the class.
    public ListaTarefas() {
        listaTarefas = new ArrayList<>();
    }

    public List<Tarefa> getListaTarefas() {
    /**
     * This function returns the list of tasks.
     *
     * @return The list of tasks.
     */
        return listaTarefas;
    }

    public void setListaTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public boolean addTarefaToList(Tarefa tarefa) {
        if (!listaTarefas.contains(tarefa)){
           return listaTarefas.add(tarefa);
        }
        return false;
    }

    public boolean RemoveTarefaOfList(Tarefa tarefa) {
        if (listaTarefas.contains(tarefa)){
            return listaTarefas.remove(tarefa);
        }
        return true;
    }

    public boolean estaVazia() {
        return listaTarefas.isEmpty();
    }

    public void eliminarTarefas() {
             listaTarefas.clear();
    }

}
