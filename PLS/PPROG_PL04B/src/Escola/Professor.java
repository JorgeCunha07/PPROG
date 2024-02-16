package Escola;

public abstract class Professor extends Pessoa {

    private static double salarioBaseProfessor = 1500;

    public Professor(String nome, String identificacaoCivil) {
        super(nome, identificacaoCivil,salarioBaseProfessor);
    }

    public double getSalarioBaseProfessor() {
        return salarioBaseProfessor;
    }
    public void setSalarioBaseProfessor(double salarioBaseProfessor) {
        this.salarioBaseProfessor = salarioBaseProfessor;
    }

    @Override
    public double calcularSalarioaPagar() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }



}
