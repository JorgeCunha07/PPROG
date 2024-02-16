package Escola;

public class AlunoNaoBolseiro extends Aluno{

    public AlunoNaoBolseiro(String nome, String identificacaoCivil, String numeroMecanografico) {
        super(nome, identificacaoCivil, numeroMecanografico);
    }

    @Override
    public double calcularSalarioaPagar() {
        return getSalarioBase();
    }

    @Override
    public String toString() {
        return "Aluno não bolseiro" + super.toString();
    }
}
