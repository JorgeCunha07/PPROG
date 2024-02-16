package Impostos;

public class Reformado extends Trabalhador {
    private static double taxaRT = 0.01;
    private static double taxaOT = 0.03;

    public Reformado(String nome, String morada, double rendimentoTrabalho, double outroRendimentos) {
        super(nome, morada, rendimentoTrabalho, outroRendimentos);
    }

    public Reformado() {
    }

    public static double getTaxaRT() {
        return taxaRT;
    }

    public static void setTaxaRT(double taxaRT) {
        Reformado.taxaRT = taxaRT;
    }

    public static double getTaxaOT() {
        return taxaOT;
    }

    public static void setTaxaOT(double taxaOT) {
        Reformado.taxaOT = taxaOT;
    }

    @Override
    public String toString() {
        return String.format("Nome : %s ;"
                        + "%nMorada: %s ;"
                        + "%nRendimento do trabalho: %.2f Euros;"
                        + "%nOutros Rendimentos: %.2f Euros;"
                        + "%nValor do imposto a ser pago: %.2f Euros.",
                getNome(), getMorada(), getRendimentoTrabalho(), getOutroRendimentos(), calcularImposto());
    }


    @Override
    public double calcularImposto() {

        return (getOutroRendimentos() * taxaRT) + (getOutroRendimentos() * taxaOT);
    }
}
