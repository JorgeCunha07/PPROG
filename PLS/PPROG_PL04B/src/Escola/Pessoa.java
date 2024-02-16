package Escola;

public abstract class Pessoa {

    private String nome;
    private String identificacaoCivil;
    private double salarioBase;

    private static final double SALARIO_POR_OMISSAO = 0;

    public Pessoa(String nome, String identificacaoCivil) {
        this.nome = nome;
        this.identificacaoCivil = identificacaoCivil;
        this.salarioBase = SALARIO_POR_OMISSAO;
    }

    public Pessoa(String nome, String identificacaoCivil, double salarioBase) {
        this.nome = nome;
        this.identificacaoCivil = identificacaoCivil;
        this.salarioBase = salarioBase;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificacaoCivil() {
        return identificacaoCivil;
    }
    public void setIdentificacaoCivil(String identificacaoCivil) {
        this.identificacaoCivil = identificacaoCivil;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalarioaPagar();

    @Override
    public String toString() {
        return "nome: " + nome + '\n' +
                "identificacaoCivil: " + identificacaoCivil + '\n' +
                "salarioTotal:" + salarioBase + '\n';
    }
}
