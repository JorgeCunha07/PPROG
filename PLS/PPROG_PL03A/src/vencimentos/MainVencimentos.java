package vencimentos;

public class MainVencimentos {

    public static void main(String[] args) {

        TrabalhadorPeca trabalhadorp1 = new TrabalhadorPeca("Jorge Silva", 53, 62);
        TrabalhadorComissao trabalhadorc1 = new TrabalhadorComissao("Susana Ferreira", 650, 2731.50f, 4.25f);
        TrabalhadorHora trabalhadorh1 = new TrabalhadorHora("Carlos Miguel", 168, 4.5f);

        Trabalhador[] trabalhadorContentor = new Trabalhador[10];

        trabalhadorContentor[0] = trabalhadorp1;
        trabalhadorContentor[1] = trabalhadorc1;
        trabalhadorContentor[2] = trabalhadorh1;

        System.out.println("###     Listagem de Trabalhadores     ###");
        for (Object index : trabalhadorContentor) {
            if (index != null) {
                System.out.println(index);
                System.out.println();
            }
        }

        System.out.println("###     Listagem de Trabalhadores à hora     ###");
        for (Trabalhador index : trabalhadorContentor) {
            if (index instanceof TrabalhadorHora) {
                System.out.println(index);
                System.out.println();
            }
        }

        System.out.println("###     Listagem de Trabalhadores existentes e os seus respetivos ordenados  ###");
        for (Trabalhador index : trabalhadorContentor) {
            if (index != null) {
                System.out.printf("O trabalhador é o %s e o ordenado é %.2f.", index.getNome(),index.calcularVencimento());
                System.out.println();
            }
        }


    }
}

