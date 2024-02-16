package VencimentosComComparator;

import java.util.Comparator;

public class Comparacao1 implements Comparator<Trabalhador> {
        public int compare(Trabalhador o1, Trabalhador o2) {
            double vencimento1 = o1.calcularVencimento();
            double vencimento2 = o2.calcularVencimento();
            if(vencimento1<vencimento2){
                return -1;
            }else if(vencimento1>vencimento2){
                return 1;
            }return 0;
        }
}
