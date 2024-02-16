package Contadores;

public class EletricidadeBiHorario extends Eletricidade{
    private double horasForaVazio ;
    private double tarifarioHorasVazio = 0.066;
    private double tarifarioFHorasForaVazio= 0.14;

    public EletricidadeBiHorario(String nome,float consumoCliente,double horasForaVazio) {
        super(nome,consumoCliente);
        this.horasForaVazio = horasForaVazio;
    }

    public double getHorasForaVazio() {
        return horasForaVazio;
    }

    public void setHorasForaVazio(double horasForaVazio) {
        this.horasForaVazio = horasForaVazio;
    }

    public double getTarifarioHorasVazio() {
        return tarifarioHorasVazio;
    }

    public void setTarifarioHorasVazio(double tarifarioHorasVazio) {
        this.tarifarioHorasVazio = tarifarioHorasVazio;
    }

    public double getTarifarioFHorasForaVazio() {
        return tarifarioFHorasForaVazio;
    }

    public void setTarifarioFHorasForaVazio(double tarifarioFHorasForaVazio) {
        this.tarifarioFHorasForaVazio = tarifarioFHorasForaVazio;
    }


    @Override
    public double CalculoDoGasto() {
        return getConsumoCliente() * getTarifarioHorasVazio() + getHorasForaVazio() * getTarifarioFHorasForaVazio();
    }


    @Override
    public String toString() {
        return "Eletricidade Bi-Horário ," +
                " nome: " + getNome() +
                " ,numContador=" + getNumContador() +
                " ,Valor Calculado=" + CalculoDoGasto();
    }
}
