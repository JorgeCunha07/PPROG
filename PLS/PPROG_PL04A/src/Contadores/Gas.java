package Contadores;

public class Gas extends Contador{

    private static int numContador = 0;
    private static String identidade = "GAS-";
    private double custoUnitario = 0.80;


    public Gas(String nome ,float consumoCliente) {
        super(nome,identidade + ++numContador,consumoCliente);

    }

    public int getNumContador() {
        return numContador;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }


    @Override
    public String toString() {
        return "Gas," +
                " nome: " + getNome() +
                " ,numContador=" + numContador +
                " ,Valor Calculado=" + CalculoDoGasto();
    }

    @Override
    public double CalculoDoGasto(){

        return this.getConsumoCliente() *custoUnitario;

    }
}
