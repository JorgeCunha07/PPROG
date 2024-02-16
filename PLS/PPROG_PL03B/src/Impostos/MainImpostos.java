package Impostos;

public class MainImpostos {

    public static void main(String[] args) {

        Desempregado tra1 = new Desempregado("Jorge", "Rua estado da India", 550, 12);
//        System.out.println(tra1);
//        System.out.println();
        Reformado ref1 = new Reformado("Tiago", "Rua de avintes", 35000, 25000);
//        System.out.println(ref1);
//        System.out.println();
        TrabalhadorOutraOrdem trpoutraOR1 = new TrabalhadorOutraOrdem("Catarina", "Rua dos Bombeiros Voluntarios", 400, 70, "PingoDoce");
//        System.out.println(trpoutraOR1);
//        System.out.println();
        TrabalhadorPropriaOrdem trpOR1 = new TrabalhadorPropriaOrdem("Alvaro", "Rua estado da india", 1200, 3000, "Taxista");
//        System.out.println(trpOR1);
//        System.out.println();


        Contribuinte[] arrayTrabalhador = new Contribuinte[6];
        arrayTrabalhador[0]= tra1;
        arrayTrabalhador[1]= ref1;
        arrayTrabalhador[2]= trpoutraOR1;
        arrayTrabalhador[3]=trpOR1;

        System.out.println("### Listagem de Contribuintes e os seus respetivos impostos ###");
        for(Contribuinte index : arrayTrabalhador){
            if (index != null){
                System.out.println(index);
                System.out.println();
            }
        }

        System.out.println("### Listagem de Desempregados e os seus respetivos impostos extraordinarios ###");
        for(Contribuinte index : arrayTrabalhador){
            if (index instanceof Desempregado){
                System.out.println("Nome :" + index.getNome() + "\n" + "e os impostos extraordinarios são:" + index.calcularImposto());
                System.out.println();
            }
        }
        Desempregado.setOt(0.04);

        System.out.println("### Listagem de Desempregados e os seus respetivos impostos extraordinarios ###");
        for(Contribuinte index : arrayTrabalhador){
            if (index instanceof Desempregado){
                System.out.println("Nome :" + index.getNome() + "\n" + "e os impostos extraordinarios são:" + index.calcularImposto());
                System.out.println();
            }
        }

    }
}
