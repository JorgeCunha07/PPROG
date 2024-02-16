package Impostos;

public class TrabalhadorOutraOrdem extends Trabalhador {

    private static final String EMPRESA_POR_OMISSAO = "Sem Empresa";
    private static double taxaRTmenor = 0.01;
    private static double taxaRTmaior = 0.02;
    private static double taxaOT = 0.02;
    private static double rtValor = 30000;
    private String nomeEmpresa;


    public TrabalhadorOutraOrdem(String nome, String morada, double rendimentoTrabalho, double outroRendimentos, String nomeEmpresa) {
        super(nome, morada, rendimentoTrabalho, outroRendimentos);
        this.nomeEmpresa = nomeEmpresa;
    }

    public TrabalhadorOutraOrdem() {
        super();
        this.nomeEmpresa = EMPRESA_POR_OMISSAO;
    }

    public static double getTaxaRTmenor() {
        return taxaRTmenor;
    }

    public static void setTaxaRTmenor(double taxaRTmenor) {
        TrabalhadorOutraOrdem.taxaRTmenor = taxaRTmenor;
    }

    public static double getTaxaRTmaior() {
        return taxaRTmaior;
    }

    public static void setTaxaRTmaior(double taxaRTmaior) {
        TrabalhadorOutraOrdem.taxaRTmaior = taxaRTmaior;
    }

    public static double getTaxaOT() {
        return taxaOT;
    }

    public static void setTaxaOT(double taxaOT) {
        TrabalhadorOutraOrdem.taxaOT = taxaOT;
    }

    public static double getRtValor() {
        return rtValor;
    }

    public static void setRtValor(double rtValor) {
        TrabalhadorOutraOrdem.rtValor = rtValor;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    @Override
    public String toString() {
        return String.format("Nome : %s ;"
                        + "%nMorada: %s ;"
                        + "%nEmpresa: %s ;"
                        + "%nRendimento do trabalho: %.2f Euros;"
                        + "%nOutros Rendimentos: %.2f Euros;"
                        + "%nValor do imposto a ser pago: %.2f Euros.",
                getNome(), getMorada(), getNomeEmpresa(), getRendimentoTrabalho(), getOutroRendimentos(), calcularImposto());
    }


    @Override
    public double calcularImposto() {
        if (getRendimentoTrabalho() <= rtValor) {
            return (getRendimentoTrabalho() * taxaRTmenor) + (getOutroRendimentos() * taxaOT);
        } else {
            return (getRendimentoTrabalho() * taxaRTmaior) + (getOutroRendimentos() * taxaOT);
        }
    }

}
