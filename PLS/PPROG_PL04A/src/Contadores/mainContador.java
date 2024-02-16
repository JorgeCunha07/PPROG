package Contadores;

public class mainContador {

    public static void main(String[] args) {

        Gas gas1 = new Gas("Jorge Cunha",300);
        //System.out.println(gas1);
        EletricidadeHorario elec1 = new EletricidadeHorario("Catarina",300,2.2);
        //System.out.println(elec1);
        EletricidadeBiHorario elec2 = new EletricidadeBiHorario("Ana Cunha",150,150);
        //System.out.println(elec2);

        Contador[] contentorDeContadores = new Contador [10];

        contentorDeContadores[0] = gas1;
        contentorDeContadores[1] = elec1;
        contentorDeContadores[2] = elec2;

        for (Contador index : contentorDeContadores){
            if(index != null) {
                System.out.println(index);
                System.out.println(index.getIdentificador());
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Número de contadores de eletricidade: " + Eletricidade.getNumContador() );
        System.out.println();

        System.out.println("### Identificadores dos contadores de eletricidade com tarifário bi-horário: ###");
        for (Contador index : contentorDeContadores){
            if(index instanceof EletricidadeBiHorario) {
                System.out.println(index.getIdentificador());
            }
        }

        System.out.println("### Identificadores dos contadores, acompanhados do respetivo custo do consumo ###");
        for (Contador index : contentorDeContadores){
            if(index != null) {
                System.out.println("Nome: " + index.getNome() + " ; Identificador: " + index.getIdentificador() + " ; Consumo do Cliebte: " + index.getConsumoCliente() );
                System.out.println();
            }
    }

/*        System.out.println("### Maior valor consumido de gás ###");
        for (Contador index : contentorDeContadores){
            if(index != null) {
                if()
            }
        }
        */

        System.out.println("### Lista de nomes com contadores ###");
        for (Contador index : contentorDeContadores){
            if(index != null) {
                System.out.println("Nome: " + index.getNome());
                System.out.println();
            }
        }
}
}
