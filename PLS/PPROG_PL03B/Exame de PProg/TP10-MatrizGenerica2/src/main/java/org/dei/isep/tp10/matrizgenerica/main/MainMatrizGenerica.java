
package org.dei.isep.tp10.matrizgenerica.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.dei.isep.tp10.matrizgenerica.model.MatrizGenerica;
import org.dei.isep.tp10.matrizgenerica.model.TrabalhadorPeca;

public class MainMatrizGenerica {

    public static void main(String[] args) {

        MatrizGenerica<TrabalhadorPeca> matrizGenerica = new MatrizGenerica<>();
        
        // Teste: adicionar linha compatível
        
        List<TrabalhadorPeca> listaTP1 = new ArrayList<>();
        listaTP1.add(new TrabalhadorPeca("Antunes"));
        listaTP1.add(new TrabalhadorPeca("Belmiro"));
        listaTP1.add(new TrabalhadorPeca("Carlos"));
        
        matrizGenerica.adicionarLinha(listaTP1);
        System.out.println("\n#### Linha adicionada de ArrayList:");
        listar(matrizGenerica);
        
        // Teste: adicionar linha compatível com outro tipo de coleção
        
        Queue<TrabalhadorPeca> queueTP = new LinkedList<>();
        queueTP.add(new TrabalhadorPeca("Ana"));
        queueTP.add(new TrabalhadorPeca("Rita"));
        matrizGenerica.adicionarLinha(queueTP);
        System.out.println("\n#### Linha adicionada de LinkedList:");
        listar(matrizGenerica);
        
        // Teste: adicionar linha incompatível
//        List<Trabalhador> listaT = new ArrayList<>();
//        matrizGenerica.adicionarLinha(listaT);    //ilegal - tipos incompatíveis - erro de compilação
              
        // Teste: obter elemento 
        System.out.println("\n#### Obter Elemento (0,0): \n" + matrizGenerica.getElemento(0,0));
//        System.out.println("Elemento (0,5): \n" + matrizGenerica.getElemento(0,5));   // ERRO em tempo de execução
        
        // Teste: verificar elemento contido 
        System.out.println("\n#### Verificar Elemento Contido: ");
        System.out.println("Null:" + matrizGenerica.contem(null));
        System.out.println("Ana:" + matrizGenerica.contem(new TrabalhadorPeca("Ana")));
        
        // Teste: substituir elemento 
        System.out.println("\n#### Substituir elemento (0,0): ");
        matrizGenerica.substituirElemento(0, 0, new TrabalhadorPeca("Rui"));
        listar(matrizGenerica);
        
        // Teste: remover linha 
//        System.out.println("\n#### Remover Linha 2: ");
////        matrizGenerica.removerLinha(-1);    // lançada a exceção
//        matrizGenerica.removerLinha(1);
//        listar(matrizGenerica);
        
        // Teste 1: coluna para Array
        System.out.println("\n#### Coluna para Array 1");
        TrabalhadorPeca[] array1 = new TrabalhadorPeca[2];
        TrabalhadorPeca[] array2 = matrizGenerica.colunaParaArray(2, array1);
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }

        // Teste 2: coluna para Array
        System.out.println("\n#### Coluna para Array 2");
        TrabalhadorPeca[] array3 = new TrabalhadorPeca[1];
        TrabalhadorPeca[] array4 = matrizGenerica.colunaParaArray(1, array3);
        for (int i = 0; i < array4.length; i++) {
            System.out.println(array4[i]);
        }

        // Teste: tipo primitivo
//        MatrizGenerica<int> matriz2 = new ListaLigada<int>();   // erro de compilação
        
        // Teste: tipo interface
        System.out.println("\n#### Parâmetro de Tipo Interface");
        List<String> lista = new ArrayList<>();
        lista.add("teste");
        MatrizGenerica< Comparable<String> > matriz3 = new MatrizGenerica<>();
        matriz3.adicionarLinha(lista);
        listar(matriz3);

        // Teste: parâmetros de tipo relacionados hierarquicamente
        MatrizGenerica<TrabalhadorPeca> matrizTP = new MatrizGenerica<>();
//        MatrizGenerica<Trabalhador> matrizT = matrizTP;  //erro de compilação  - tipos incompatíveis.         

    }

    public static <E> void listar(MatrizGenerica<E> matrizGenerica) {
        System.out.println("\nMatriz - Nº de Linhas = " + matrizGenerica.getNumeroDeLinhas());
        for (int i = 0; i < matrizGenerica.getNumeroDeLinhas(); i++) {
            System.out.println("Linha " + (i+1));
            for (int j = 0; j < matrizGenerica.getNumeroDeColunas(i); j++) {
                System.out.printf("%s %n",matrizGenerica.getElemento(i, j));
            }
            System.out.println();
        }
    }

}

