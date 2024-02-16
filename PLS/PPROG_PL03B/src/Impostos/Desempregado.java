package Impostos;

public class Desempregado extends Contribuinte {

    private static final int MESESPARADOS_POR_OMISSAO = 0;

    public static double getOt() {
        return ot;
    }

    public static void setOt(double ot) {
        Desempregado.ot = ot;
    }

    private static double ot = 0.02;
    private int mesesParados;

    public Desempregado(String nome, String morada, double outroRendimentos, int mesesParados) {
        super(nome, morada, outroRendimentos);
        this.mesesParados = mesesParados;
    }

    public Desempregado() {
        super();
        this.mesesParados = MESESPARADOS_POR_OMISSAO;
    }

    public int getMesesParados() {
        return mesesParados;
    }

    public void setMesesParados(int mesesParados) {
        this.mesesParados = mesesParados;
    }


    @Override
    public String toString() {
        return String.format("Nome : %s ;"
                        + "%nMorada: %s ;"
                        + "%nRendimento do trabalho: 0 Euros;"
                        + "%nMeses Desempregado: %d meses;"
                        + "%nOutros Rendimentos: %.2f Euros;"
                        + "%nValor do imposto a ser pago: %.2f Euros.",
                getNome(), getMorada(), getMesesParados(), getOutroRendimentos(), calcularImposto());
    }


    @Override
    public double calcularImposto() {

        return getOutroRendimentos() * ot;
    }

}
