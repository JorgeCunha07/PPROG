package Escola;

public class ProfessorAdjunto extends Professor{

    private double majoramento = 1.2;

    public double getMajoramento() {
        return majoramento;
    }
    public void setMajoramento(double majoramento) {
        this.majoramento = majoramento;
    }

    public ProfessorAdjunto(String nome, String identificacaoCivil) {
        super(nome, identificacaoCivil);
    }

    @Override
    public double calcularSalarioaPagar() {
        return getSalarioBase() * getMajoramento();
    }

    @Override
    public String toString() {
        return "Professor Adjunto: " + super.toString();
    }

}

