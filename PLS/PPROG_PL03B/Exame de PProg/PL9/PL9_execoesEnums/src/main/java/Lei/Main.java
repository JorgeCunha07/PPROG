package Lei;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true,flag2 = true;
        String location,nome = "",dataS = "";
        Data data = new Data();
        PrintWriter printWriter = null;
        ArrayList<String> listaNome = new ArrayList<>();
        ArrayList<Data> listaData = new ArrayList<>();

        do {
        System.out.print("Nome do ficheiro:");
        location = read.next();

        try{
            printWriter = new PrintWriter(location);
        } catch (FileNotFoundException e) {
            flag = false;
            System.out.println("Impossivel criar ficheiro!!");
            System.out.println(location + "(acesso negado)");
        }
    }while (!flag);
            do{

            System.out.println("Nome (Enter para terminar)");
            nome = read.next();

            System.out.println("Lei.Data de aniversário (ano/mes/dia)");
        dataS = read.next();
           if( !dataS.contains("/")){
               System.out.println("Formato Invalido");
               flag2 = false;
           }
        String[] dataAuxiliar = dataS.split("/");
           try {
               data.checkAno(Integer.parseInt(dataAuxiliar[0]));
               data.checkMes(Integer.parseInt(dataAuxiliar[1]),Integer.parseInt(dataAuxiliar[0]));
               data.checkDia(Integer.parseInt(dataAuxiliar[2]),Integer.parseInt(dataAuxiliar[1]),Integer.parseInt(dataAuxiliar[0]));
           }catch (RuntimeException e){
               System.out.println(e.getMessage());
               flag2 = false;
           }
           data = new Data(Integer.parseInt(dataAuxiliar[0]), Integer.parseInt(dataAuxiliar[1]), Integer.parseInt(dataAuxiliar[2]));
           printWriter.println("Nome: " + nome + "Data: " + data);

            }while (flag2 && !nome.isBlank());

            System.out.println("Aplicação Terminada");
            printWriter.close();

    }




}