package Escola;

public class ProfessorAssistente extends Professor{

    public ProfessorAssistente(String nome, String identificacaoCivil) {
        super(nome, identificacaoCivil);
    }

    @Override
    public double calcularSalarioaPagar() {
        return getSalarioBase();
    }

    @Override
    public String toString() {
        return "Professor Assistente: " + super.toString();
    }

}
