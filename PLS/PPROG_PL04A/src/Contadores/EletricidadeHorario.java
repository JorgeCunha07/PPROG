package Contadores;

public class EletricidadeHorario extends Eletricidade{

    private double potenciaContratada ;
    private double potenciaCalulativa = 6.9;
    private double tarifarioInfKVA = 0.13;
    private double tarifarioSupfKVA = 0.16;


    public EletricidadeHorario(String nome, float consumoCliente, double potenciaContratada) {
        super(nome, consumoCliente);
        this.potenciaContratada = potenciaContratada;
    }

    public double getPotenciaContratada() {
        return potenciaContratada;
    }

    public void setPotenciaContratada(double potenciaContratada) {
        this.potenciaContratada = potenciaContratada;
    }

    public double getPotenciaCalulativa() {
        return potenciaCalulativa;
    }

    public void setPotenciaCalulativa(double potenciaCalulativa) {
        this.potenciaCalulativa = potenciaCalulativa;
    }

    public double getTarifarioInfKVA() {
        return tarifarioInfKVA;
    }

    public void setTarifarioInfKVA(double tarifarioInfKVA) {
        this.tarifarioInfKVA = tarifarioInfKVA;
    }

    public double getTarifarioSupfKVA() {
        return tarifarioSupfKVA;
    }

    public void setTarifarioSupfKVA(double tarifarioSupfKVA) {
        this.tarifarioSupfKVA = tarifarioSupfKVA;
    }

    @Override
    public double CalculoDoGasto() {
        double gasto;
        if(this.potenciaContratada >= potenciaCalulativa){
            gasto = getConsumoCliente() * tarifarioSupfKVA;
        }
        else {
            gasto = getConsumoCliente() * tarifarioInfKVA;
        }

        return gasto;
    }


    @Override
    public String toString() {
        return "Eletricidade Horário Normal," +
                " nome: " + getNome() +
                " ,numContador=" + getNumContador() +
                " ,Valor Calculado=" + CalculoDoGasto();
    }
}
