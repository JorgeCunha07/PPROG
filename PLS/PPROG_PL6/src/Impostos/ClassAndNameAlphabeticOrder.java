package Impostos;

import java.util.Comparator;

public class ClassAndNameAlphabeticOrder implements Comparator<Contribuinte> {
    public int compare(Contribuinte o1, Contribuinte o2) {
        /*if (o1.getClass().toString().compareTo(o2.getClass().toString()) == 0) {
            return o1.getNome().compareTo(o2.getNome());
        }else return o1.getClass().toString().compareTo(o2.getClass().toString());*/

        int comapareTipoContribuinte = o1.getClass().getName().compareTo(o2.getClass().getName());

        if (comapareTipoContribuinte == 0){
            return o1.getNome().compareTo(o2.getNome());
        } else{
            return comapareTipoContribuinte;
        }
    }
}
