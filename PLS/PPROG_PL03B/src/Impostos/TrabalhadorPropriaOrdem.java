package Impostos;

public class TrabalhadorPropriaOrdem extends Trabalhador {

    private static final String PROFISSAOPROPRIA_POR_OMISSAO = "Sem Profissão";
    private static double taxaRT = 0.03;
    private static double taxaOTMenor = 0.02;
    private static double taxaOTMaior = 0.05;
    private static int orValor = 50000;
    private String profissaoPropria;

    public TrabalhadorPropriaOrdem(String nome, String morada, double rendimentoTrabalho, double outroRendimentos, String profissaoPropria) {
        super(nome, morada, rendimentoTrabalho, outroRendimentos);
        this.profissaoPropria = profissaoPropria;
    }

    public TrabalhadorPropriaOrdem() {
        this.profissaoPropria = PROFISSAOPROPRIA_POR_OMISSAO;
    }

    public static double getTaxaRT() {
        return taxaRT;
    }

    public static void setTaxaRT(double taxaRT) {
        TrabalhadorPropriaOrdem.taxaRT = taxaRT;
    }

    public static double getTaxaOTMenor() {
        return taxaOTMenor;
    }

    public static void setTaxaOTMenor(double taxaOTMenor) {
        TrabalhadorPropriaOrdem.taxaOTMenor = taxaOTMenor;
    }

    public static double getTaxaOTMaior() {
        return taxaOTMaior;
    }

    public static void setTaxaOTMaior(double taxaOTMaior) {
        TrabalhadorPropriaOrdem.taxaOTMaior = taxaOTMaior;
    }

    public static int getOrValor() {
        return orValor;
    }

    public static void setOrValor(int OR) {
        TrabalhadorPropriaOrdem.orValor = OR;
    }

    public String getProfissaoPropria() {
        return profissaoPropria;
    }

    public void setProfissaoPropria(String profissaoPropria) {
        this.profissaoPropria = profissaoPropria;
    }

    @Override
    public String toString() {
        return String.format("Nome : %s ;"
                        + "%nMorada: %s ;"
                        + "%nProfissão: %s ;"
                        + "%nRendimento do trabalho: %.2f Euros;"
                        + "%nOutros Rendimentos: %.2f Euros;"
                        + "%nValor do imposto a ser pago: %.2f Euros.",
                getNome(), getMorada(), getProfissaoPropria(), getRendimentoTrabalho(), getOutroRendimentos(), calcularImposto());
    }


    @Override
    public double calcularImposto() {
        if (getOutroRendimentos() <= orValor) {
            return (getRendimentoTrabalho() * taxaRT) + (getOutroRendimentos() * taxaOTMenor);
        } else {
            return (getRendimentoTrabalho() * taxaRT) + (getOutroRendimentos() * taxaOTMaior);
        }
    }
}