package pessoa;

import java.util.Calendar;
import java.util.Scanner;

public class Cumprimentar {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        String nome;
        nome = ler.next();
        System.out.println("Olá : " + nome);
        Pessoa pess1 = new Pessoa(nome);
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = 1 + hoje.get(Calendar.MONTH);
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        Data dataAtual = new Data(ano,mes,dia);

        Data dataNascPess1 = new Data(2000,03,9);

        int idade = dataNascPess1.calcularDiferenca(dataAtual);
        idade /= 365;

        pess1.setIdadepessoa(idade);
        System.out.println(pess1);
    }
}
