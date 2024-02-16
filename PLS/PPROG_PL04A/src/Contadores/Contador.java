package Contadores;

public abstract class Contador {

    private String nome;
    private String identificador;
    private float consumoCliente;

    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final String IDENTIFICADOR_POR_OMISSAO = "sem nome";
    private static final float CONSUMOCLIENTE_POR_OMISSAO = 0;

    public Contador(String nome , String identificador, float consumoCliente) {
        this.nome = nome;
        this.identificador = identificador;
        this.consumoCliente = consumoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public float getConsumoCliente() {
        return consumoCliente;
    }

    public void setConsumoCliente(float consumoCliente) {
        this.consumoCliente = consumoCliente;
    }


    @Override
    public String toString() {
        return "Contador{" +
                "identificador='" + identificador + '\'' +
                ", consumoCliente=" + consumoCliente +
                '}';
    }
    public abstract double CalculoDoGasto();
}

