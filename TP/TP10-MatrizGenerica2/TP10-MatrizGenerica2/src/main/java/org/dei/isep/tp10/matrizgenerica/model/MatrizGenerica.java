
package org.dei.isep.tp10.matrizgenerica.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MatrizGenerica<E> {

    private List< List<E>> matrizGenerica;
    private int numeroMaximoColunas;

    public MatrizGenerica() {
        this.matrizGenerica = new ArrayList<>();
        this.numeroMaximoColunas = 0;
    }

    public int getNumeroDeLinhas() {
        return this.matrizGenerica.size();
    }

    public int getNumeroDeColunas(int indiceLinha) {
        verificarIndiceLinha(indiceLinha);
        return this.matrizGenerica.get(indiceLinha).size();
    }

    public E getElemento(int indiceLinha, int indiceColuna) {
        verificarIndices(indiceLinha, indiceColuna);
        return this.matrizGenerica.get(indiceLinha).get(indiceColuna);
    }

    public void adicionarLinha(Collection<? extends E> colecao) {
        this.matrizGenerica.add(new ArrayList<>(colecao));
        if (colecao.size() > this.numeroMaximoColunas) {
            this.numeroMaximoColunas = colecao.size();
        }
    }
    
    public boolean contem(E elemento) {
        for (List<E> linha : this.matrizGenerica) {
            if (linha.contains(elemento)) {
                return true;
            }
        }
        return false;
    }
    
    public E substituirElemento(int indiceLinha, int indiceColuna, E elemento) {
        verificarIndices(indiceLinha, indiceColuna);
        return this.matrizGenerica.get(indiceLinha).set(indiceColuna, elemento);
    }

    public List<E> removerLinha(int indice) {
        verificarIndiceLinha(indice);
        int numCol=getNumeroDeColunas(indice);        
        List<E> listTemp= this.matrizGenerica.remove(indice);
        if (numCol==numeroMaximoColunas) {  
            int max=0;
            for (int i = 0; i < getNumeroDeLinhas(); i++) {
                if (matrizGenerica.get(i).size()> max) {
                    max=matrizGenerica.get(i).size();
                }                
            } 
            numeroMaximoColunas=max;           
        }
        return listTemp;
    }
    
    public <T> T[] colunaParaArray(int indice, T[] array) {
        verificarIndiceColuna(indice);
        int tamanhoColuna = this.tamanhoColuna(indice);
        if (array.length < tamanhoColuna) {
            array = (T[]) Array.newInstance(array.getClass().getComponentType(), tamanhoColuna);
        }
        
        int j=0;
        for (int i = 0; i < getNumeroDeLinhas(); i++) {
            if (indice < matrizGenerica.get(i).size()) {
                array[j] = (T) this.matrizGenerica.get(i).get(indice);
                j++;
            }
        }
        
        if (array.length > tamanhoColuna) {
            array[tamanhoColuna] = null;
        }

        return array;
    }

    public void limpar() {
        this.matrizGenerica.clear();
    }

    private int tamanhoColuna(int indice) {
        verificarIndiceColuna(indice);
        int numeroLinhas = 0;
        for (List<E> linha : this.matrizGenerica) {
            if (indice < linha.size()) {
                numeroLinhas++;
            }
        }
        return numeroLinhas;
    }

    private void verificarIndiceLinha(int indice) {
        if (indice < 0 || indice >= this.matrizGenerica.size()) {
            throw new IndexOutOfBoundsException(mensagemIndiceLinhaInvalido(indice));
        }
    }

    private void verificarIndiceColuna(int indiceColuna) {
        if (indiceColuna < 0 || indiceColuna >= this.numeroMaximoColunas) {
            throw new IndexOutOfBoundsException(
                    " Índice Coluna: " + indiceColuna
                    + ", Tamanho: " + this.numeroMaximoColunas);
        }
    }

    private void verificarIndices(int indiceLinha, int indiceColuna) {
        if (indiceLinha < 0
                || indiceLinha >= this.matrizGenerica.size()
                || indiceColuna < 0
                || indiceColuna >= this.matrizGenerica.get(indiceLinha).size()) {
            String mensagem = mensagemIndiceLinhaInvalido(indiceLinha)
                    + mensagemIndiceColunaInvalido(indiceLinha);
            throw new IndexOutOfBoundsException(mensagem);
        }
    }

    private String mensagemIndiceLinhaInvalido(int indice) {
        return "Índice Linha: " + indice
                + ", Tamanho: " + this.matrizGenerica.size();
    }

    private String mensagemIndiceColunaInvalido(int indice) {
        return " Índice Coluna: " + indice
                + ", Tamanho: " + this.matrizGenerica.get(indice).size();
    }

}
