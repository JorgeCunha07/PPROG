package VencimentosComComparator;

import java.util.Comparator;

public class Comparacao2 implements Comparator<Trabalhador> {
    public int compare(Trabalhador o1, Trabalhador o2) {

       String nome1= o1.getNome();
       String nome2 = o2.getNome();

       return nome1.compareTo(nome2);
    }
}
