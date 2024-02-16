package Escola;

public abstract class Aluno extends Pessoa {
    private String numeroMecanografico;

    public Aluno(String nome, String identificacaoCivil, String numeroMecanografico) {
        super(nome, identificacaoCivil);
        this.numeroMecanografico = numeroMecanografico;
    }

    public Aluno(String nome, String identificacaoCivil, double salarioBase, String numeroMecanografico) {
        super(nome, identificacaoCivil, salarioBase);
        this.numeroMecanografico = numeroMecanografico;
    }

    public String getNumeroMecanografico() {
        return numeroMecanografico;
    }
    public void setNumeroMecanografico(String numeroMecanografico) {
        this.numeroMecanografico = numeroMecanografico;
    }


    @Override
    public String toString() {
        return super.toString() + "Número Mecanografico: " + getNumeroMecanografico() + '\n';
    }
}
