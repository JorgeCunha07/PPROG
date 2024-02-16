package data;

import static data.Data.isAnoBissexto;

public class MainData {

    public static void main(String[] args) {

        //A)
        Data data1 = new Data(2022, 3, 8);
        //B)
        System.out.println(data1);
        //C)
        Data data2 = new Data(1974, 4, 25);
        //D)
        System.out.println(data2.getAno() + "/" + data2.getMes() + "/" + data2.getDia());
        //E)
        if (data1.isMaior(data2)) {
            System.out.println(data1 + " é maior que a data " + data2);
        }
        //F)
        System.out.println(data1.calcularDiferenca(data2));
        //G)

        //H
        System.out.println(data2.determinarDiaDaSemana());
        //I
        if(isAnoBissexto(data2.getAno())){
            System.out.println("1974 é ano bissexto");
        }
        else{
            System.out.println("1974 não é ano bissexto");
        }
    }
}
