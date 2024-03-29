package org.isep.dei.pl19.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa implements Comparable<Tarefa>, Serializable{

    private static final String MENSAGEM_DESCRICAO_INVALIDA="Descrição inválida.";
    private static final String MENSAGEM_PRIORIDADE_INVALIDA="Prioridade inválida.";
    
//    private static final String MENSAGEM_DESCRICAO_INVALIDA="Invalid description.";
//    private static final String MENSAGEM_PRIORIDADE_INVALIDA="Invalid priority.";
    
    
    private String descricao;
    private LocalDateTime instante;
    private Prioridade prioridade;

    public Tarefa(String descricao, Prioridade prioridade) {
        setDescricao(descricao);
        setPrioridade(prioridade);
        instante = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public final void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException(MENSAGEM_DESCRICAO_INVALIDA);
        }
        this.descricao = descricao;
    }

    public final void setPrioridade(Prioridade prioridade) {
        if (prioridade == null) {
            throw new IllegalArgumentException(MENSAGEM_PRIORIDADE_INVALIDA);
        }
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoInstante = 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM:SS.SSS");
        String stringDataTempoDeRegisto = instante.format(formatoInstante);
        return String.format("%s - %s - %s", descricao, prioridade, 
                stringDataTempoDeRegisto);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Tarefa outraTarefa = (Tarefa) outroObjeto;

        return descricao.equalsIgnoreCase(outraTarefa.descricao) && instante.equals(outraTarefa.instante);
    }

    @Override
    public int compareTo(Tarefa outraTarefa) {
        if(prioridade.equals(outraTarefa.prioridade)) {
            return instante.compareTo(outraTarefa.instante);
        }
        
        return prioridade.compareTo(outraTarefa.prioridade);
    }

}
