package Impostos;

/**
 * Esta classe permite a construção de uma hierarquia de classes para
 * representarem diferentes tipos de contribuintes. Especifica membros
 * comuns a todas as classes da hierarquia.
 *
 * @author ISEP-DEI-PPROG
 */
public abstract class Contribuinte {

    /**
     * O nome por omissão do Contribuinte.
     */
    private static final String NOME_POR_OMISSAO = "sem nome";
    /**
     * A morada por omissão do Contribuinte.
     */
    private static final String MORADA_POR_OMISSAO = "sem morada";
    private static final double OUTROSRENDIMENTOS_POR_OMISSAO = 0;
    /**
     * O nome do Contribuinte.
     */
    private String nome;
    /**
     * O morada do Contribuinte.
     */
    private String morada;
    private double outroRendimentos;

    /**
     * Inicializa o Contribuinte com o nome recebido e a morada.
     *
     * @param nome   o nome do trabalhador
     * @param morada a morada do trabalhador
     */
    public Contribuinte(String nome, String morada, double outroRendimentos) {
        this.nome = nome;
        this.morada = morada;
        this.outroRendimentos = outroRendimentos;
    }

    /**
     * Inicializa o Contribuinte com o nome e a morada por omissão.
     */
    public Contribuinte() {
        nome = NOME_POR_OMISSAO;
        morada = MORADA_POR_OMISSAO;
        outroRendimentos = OUTROSRENDIMENTOS_POR_OMISSAO;
    }

    /**
     * Devolve o nome do trabalhador.
     *
     * @return nome do trabalhador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome do trabalhador.
     *
     * @param nome o novo nome do trabalhador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public double getOutroRendimentos() {
        return outroRendimentos;
    }

    public void setOutroRendimentos(float outroRendimentos) {
        this.outroRendimentos = outroRendimentos;
    }

    /**
     * Devolve o nome do trabalhador.
     *
     * @return nome do trabalhador
     */
    @Override
    public String toString() {
        return nome + morada + outroRendimentos;
    }

    /**
     * Permite o cálculo do vencimento do trabalhador através do polimorfismo.
     *
     * @return vencimento do trabalhador
     */
    public abstract double calcularImposto();
}