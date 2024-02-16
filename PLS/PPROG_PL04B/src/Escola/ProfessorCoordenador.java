
package Escola;

public class ProfessorCoordenador extends Professor{

    private double majoramento = 1.5;

    public double getMajoramento() {
        return majoramento;
    }
    public void setMajoramento(double majoramento) {
        this.majoramento = majoramento;
    }

    public ProfessorCoordenador(String nome, String identificacaoCivil) {
        super(nome, identificacaoCivil);
    }

    @Override
    public double calcularSalarioaPagar() {
        return getSalarioBase() * getMajoramento();
    }

    @Override
    public String toString() {
        return "Professor Coordenador: " + super.toString();
    }
}
