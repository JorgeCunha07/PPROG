package Contadores;

public class Eletricidade extends Contador{

    private static int numContador = 0;
    private static String identidade = "ELECT-";

    public Eletricidade(String nome, float consumoCliente) {
        super(nome, identidade + ++numContador, consumoCliente);
    }


    public static int getNumContador() {
        return numContador;
    }

    public static String getIdentidade() {
        return identidade;
    }

    public static void setIdentidade(String identidade) {
        Eletricidade.identidade = identidade;
    }

    @Override
    public double CalculoDoGasto() {
        return 0;
    }

    @Override
    public String toString() {
        return "Eletricidade{}";
    }
}
