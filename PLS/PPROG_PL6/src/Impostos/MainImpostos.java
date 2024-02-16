package Impostos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainImpostos {

    public static void main(String[] args) {

        List<Contribuinte> contribuintes = new ArrayList<>();
        contribuintes.add(new Desempregado("Lito Vidal", "Lisboa", 230, 1));
        contribuintes.add(new Reformado("Valter Cubilhas", "Olival", 600, 400));
        contribuintes.add(new Desempregado("Paulo Santos", "Braga", 150, 4));
        contribuintes.add(new TrabalhadorOutraOrdem("Ana", "Ovar", 1800, 300, "CMM"));
        contribuintes.add(new Reformado("Jaime Magalhães", "Porto", 1500, 100));
        contribuintes.add(new TrabalhadorOutraOrdem("Salvio", "Seixal", 8000, 1000, "SSB"));
        contribuintes.add(new TrabalhadorPropriaOrdem("Mário", "Guarda", 1500, 300, "Eletricista"));
        contribuintes.add(new Reformado("Aníbal Silva", "Coimbra", 1000, 500));
        contribuintes.add(new TrabalhadorOutraOrdem("João", "Lisboa", 800, 100, "CML"));
        contribuintes.add(new TrabalhadorPropriaOrdem("Carla", "Porto", 15000, 1000, "Advogado"));
        contribuintes.add(new Desempregado("Maria Sá", "Afife", 230, 8));

        System.out.println("\n");

        /* criada nova lista para que tenha os elementos que quero eliminar*/
        List<Contribuinte> newList =  new ArrayList<>();
        for (Contribuinte contrib : contribuintes) {
            if (contrib.getNome().equals("Lito Vidal")) {
                //contribuintes.remove(contrib);
                newList.add(contrib);
            }
        }

        //removo todos os elementos da lista original que estão na lista nova.
        contribuintes.removeAll(newList);


        contribuintes.add(new Desempregado("Lito Vidal", "Lisboa", 230, 2));
        for (int i = 0; i < contribuintes.size(); i++) {
            if (contribuintes != null) {
                System.out.println(contribuintes.get(i));
                System.out.println();

            }
        }
        System.out.println("\n");
        for (Contribuinte contrib : contribuintes) {
            if (contrib.getNome().equals("Lito Vidal")) {
                System.out.println("A eliminação não foi efetuada.");
            }
        }

        System.out.println("\n");
        for (Contribuinte contribs : contribuintes) {
            if (contribs.getNome().equals("Lito Vidal")) {
                //contribuintes.remove(contribs);
            }
        }
        contribuintes.removeAll(newList);
        for (int i = 0; i < contribuintes.size(); i++) {
            if (contribuintes != null) {
                System.out.println(contribuintes.get(i));
                System.out.println();

            }
        }
        System.out.println("\n### Equals ###");
        System.out.println("Instâncias com características iguais: " + contribuintes.get(0).equals(new Reformado("Valter Cubilhas", "Olival", 600, 400)));
        System.out.println("Instâncias do mesmo tipo com características diferentes: " + contribuintes.get(0).equals(contribuintes.get(2)));
        System.out.println("Instâncias de tipos diferentes: " + contribuintes.get(0).equals(contribuintes.get(1)));

        System.out.println("\n### Contribuintes ###");
        listar(contribuintes);

        System.out.println("\n### Ordem alfabética inversa dos Nomes dos contribuintes.###");
        AlphabeticOrder rod1 = new AlphabeticOrder();
        contribuintes.sort(Collections.reverseOrder(rod1));
        listar(contribuintes);

        //como fazer para poder ordenar pelo tipo de instância e de seguida pelo nome do contribuinte.
        System.out.println("\n### Ordem pelo tipo de instância e de seguida pelo nome do contribuinte ###");
        ClassAndNameAlphabeticOrder rod2 = new ClassAndNameAlphabeticOrder();
        contribuintes.sort(Collections.reverseOrder(rod2));
        listar(contribuintes);
    }
    private static void listar(List<Contribuinte> tab) {
        for (Contribuinte index : tab) {
            System.out.println();
            if (index != null) {
                System.out.printf(String.valueOf(index));
                System.out.println();
            }
        }
    }
}
