package Impostos;

public abstract class Trabalhador extends Contribuinte {
    private static final int RENDIMENTOTRABALHO_POR_OMISSAO = 0;
    private double rendimentoTrabalho;

    public Trabalhador(String nome, String morada, double rendimentoTrabalho, double outroRendimentos) {
        super(nome, morada, outroRendimentos);
        this.rendimentoTrabalho = rendimentoTrabalho;
    }

    public Trabalhador() {
        super();
        this.rendimentoTrabalho = RENDIMENTOTRABALHO_POR_OMISSAO;
    }


    public double getRendimentoTrabalho() {
        return rendimentoTrabalho;
    }

    public void setRendimentoTrabalho(double rendimentoTrabalho) {
        this.rendimentoTrabalho = rendimentoTrabalho;
    }

    @Override
    public abstract double calcularImposto();
}
