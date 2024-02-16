package Escola;

public class AlunoBolseiro extends Aluno{

    public AlunoBolseiro(String nome, String identificacaoCivil, double salarioBase, String numeroMecanografico) {
        super(nome, identificacaoCivil, salarioBase, numeroMecanografico);
    }

    @Override
    public double calcularSalarioaPagar() {
        return getSalarioBase();
    }

    @Override
    public String toString() {
        return "Aluno Bolseiro" + "\n" + super.toString();
    }
}
