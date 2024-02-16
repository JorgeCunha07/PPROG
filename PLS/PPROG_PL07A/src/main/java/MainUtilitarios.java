import java.util.ArrayList;
import java.util.List;

public class MainUtilitarios {

    public static void main(String[] args) {
        Data dataAtual = new Data(Data.dataAtual());

        Data contrato = new Data(2000, 11, 27);
        Tempo horaEntrada = new Tempo(7, 50, 10);
        Tempo horaSaida = new Tempo(18, 30, 10);

        //a
        System.out.println("Data do dia de hoje:");
        System.out.println(dataAtual);
        System.out.println();

        System.out.println("Data do Contrato:");
        System.out.println(contrato);
        System.out.println();
        //b
        System.out.println("Hora de Entrada:");
        System.out.println(horaEntrada);
        System.out.println();

        System.out.println("Hora de Saida:");
        System.out.println(horaSaida);
        System.out.println();

        //c

        Empregados empregado1 = new Empregados("Jorge", "Cunha", contrato, horaEntrada, horaSaida);
        Empregados empregado2 = new Empregados("Tiago", "Oliveira", contrato, horaEntrada, horaSaida);
        System.out.println(empregado1);
        System.out.println(empregado2);
        System.out.println();

        //d
        System.out.println("Verificaçao de data se tem referencias partilhadas.");
        empregado1.setDataContrato(new Data(2000, 9, 30));
        System.out.println(empregado1);
        System.out.println(empregado2);
        System.out.println();

        //e
        System.out.println("Verificaçao se o tempo tem referencias partilhadas.");
        empregado1.setHoraEntrada(new Tempo(8, 50, 10));
        System.out.println(empregado1);
        System.out.println(empregado2);
        System.out.println();

        System.out.println("Listagem dos Empregados");
        List<Empregados> tab = new ArrayList<>();
        tab.add(empregado1);
        tab.add(empregado2);
        listar(tab);
        System.out.println();

        System.out.println("Listagem dos Empregados,nome,horas,antiguidade");
        System.out.println();

        for (Empregados index : tab) {
            System.out.println("Primeiro Nome: " + index.getPrimeiroNome());
            System.out.println("Ultimo Nome: " + index.getUltimoNome());
            System.out.println("Tempo Empregado: " + index.tempoDeEmpregadoContratado());
            System.out.println("Horas Semanais: " + index.calcularHorasSemanais() + "\n");

        }

    }

    private static void listar(List<Empregados> tab) {
        for (Empregados index : tab) {
            System.out.println();
            if (index != null) {
                System.out.print(index);
                System.out.println();
            }
        }
    }
}