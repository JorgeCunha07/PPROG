import java.util.Scanner;

public class Main {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        Utente utente1 = new Utente("Joao", "Masculino", 21, 1.81, 82);
        Utente utente2 = new Utente("Joao", "Masculino", 21, 1.81, 82);
        Utente utente3 = new Utente("Joao", 21);
        Utente utente4 = new Utente("Joao", 21);
        Utente utente5 = new Utente();
        Utente utente6 = new Utente();

        Utente[] utentes = new Utente[10];

        utentes[0] = utente1;
        utentes[1] = utente2;
        utentes[2] = utente3;
        utentes[3] = utente4;
        utentes[4] = utente5;
        utentes[5] = utente6;

        System.out.println("###Listagem de Utentes ##");
        System.out.println("--------------------------");
        for (int i = 0; i < utentes.length; i++) {
            if (utentes[i] != null) {
                System.out.println(utentes[i]);
            }
        }

        System.out.println("###Listagem de nome,IMC e Grau de Obesidade ##");
        System.out.println("--------------------------");
        for (int i = 0; i < utentes.length; i++) {
            if (utentes[i] != null) {
                System.out.println(utentes[i].getNome() + " imc " + utentes[i].indiceMassaCorporal() + "  e é " + utentes[i].grauDeIMC());

            }
        }
        System.out.println("###Listagem de nome,IMC e Grau de Obesidade ##");
        System.out.println("--------------------------");
        for (int i = 0; i < utentes.length; i++) {
            if (utentes[i] != null) {
                if (!utentes[i].isSaudavel()) {
                    System.out.println(utentes[i].getNome() + "  e é " + utentes[i].grauDeIMC());
                }
            }


        }

        Utente.setImcMagro(19);
        Utente.setImcSaudavel(27);

        System.out.println("###Listagem de Utentes  com o grau de IMC alterado##");
        System.out.println("--------------------------");
        for (int i = 0; i < utentes.length; i++) {
            if (utentes[i] != null) {
                System.out.println(utentes[i]);
            }
        }

        utentes[1].setIdade(utentes[2].getIdade());


        if(utentes[1].oMaisNovoUtente(utentes[2]) == null){
            System.out.println("Os utentes têm a  mesma idade.");
        }
        else{
            System.out.println(utentes[1].oMaisNovoUtente(utentes[2]));
        }
    }

}
