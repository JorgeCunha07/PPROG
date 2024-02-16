package Impostos;

import java.util.Comparator;

public class AlphabeticOrder implements Comparator<Contribuinte> {
    public int compare(Contribuinte o1, Contribuinte o2) {

       String nome1= o1.getNome();
       String nome2 = o2.getNome();

       return nome1.compareTo(nome2);
    }
}
