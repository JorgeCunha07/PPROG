public class Utente {
    /**
     * peso do utente
     */

    private static String NOME_POR_OMISSAO = "Omitido";
    /**
     * Nome do utente por omissao
     */
    private static String GENERO_POR_OMISSAO = "Omitido Genero";
    /**
     * genero do utente por omissao
     */
    private static int IDADE_POR_OMISSAO = 0;
    /**
     * idade do utente por omissao
     */
    private static double ALTURA_POR_OMISSAO = 0;
    /**
     * altura do utente por omissao
     */
    private static double PESO_POR_OMISSAO = 0;
    /**
     * peso por omissao
     */

    private static int IMC_MAGRO = 18;
    private static int IMC_SAUDAVEL = 25;
    private static int totalUtentes = 0;
    //o nome, género, idade, altura e peso
    private String nome;
    /**
     * Nome do utente
     */
    private String genero;
    /**
     * Genero do utente
     */
    private int idade;
    /**
     * idade do utente
     */
    private double altura;
    /**
     * altura do utente
     */
    private double peso;

    /**
     * Nao recebe nenhum parametro e objeto fica com tudo por omissao
     */

    public Utente() {
        nome = NOME_POR_OMISSAO;
        genero = GENERO_POR_OMISSAO;
        idade = IDADE_POR_OMISSAO;
        altura = ALTURA_POR_OMISSAO;
        peso = PESO_POR_OMISSAO;
        totalUtentes++;
    }

    /**
     * @param nome  recebe o Nome do utente.
     * @param idade recebe a Idade do utente.
     */
    public Utente(String nome, int idade) {
        this.nome = nome;
        genero = GENERO_POR_OMISSAO;
        this.idade = idade;
        altura = ALTURA_POR_OMISSAO;
        peso = PESO_POR_OMISSAO;
        totalUtentes++;
    }

    /**
     * @param nome   recebe o Nome do utente.
     * @param idade  recebe a Idade do utente.
     * @param genero recebe o Genero do utente.
     * @param altura recebe a Altura do utente.
     * @param peso   recebe o Peso do utente.
     */
    public Utente(String nome, String genero, int idade, double altura, double peso) {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        totalUtentes++;
    }

    public static int getImcMagro() {
        return IMC_MAGRO;
    }

    public static void setImcMagro(int imcMagro) {
        IMC_MAGRO = imcMagro;
    }

    public static int getImcSaudavel() {
        return IMC_SAUDAVEL;
    }

    public static void setImcSaudavel(int imcSaudavel) {
        IMC_SAUDAVEL = imcSaudavel;
    }

    public static int getTotalUtentes() {
        return totalUtentes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return String.format("Utente: %s , %s , %d , %.2f , %.2f ", nome, genero, idade, altura, peso);
    }

    public double diferencaDeIdadesUtentes(Utente ut) {
        return Math.abs(this.idade - ut.idade);
    }

    public double indiceMassaCorporal() {
        if (altura != 0 && altura > 0) {
            return peso / (Math.pow(altura, 2));
        }
        return 0;
    }

    public String grauDeIMC() {
        double imc = indiceMassaCorporal();
        String grau;
        if (imc < IMC_MAGRO) {
            grau = "Magro";
        } else if (imc <= IMC_SAUDAVEL) {
            grau = "Saudavel";
        } else {
            grau = "Obeso";
        }
        return grau;
    }

    public boolean isSaudavel() {
        double imc = indiceMassaCorporal();
        return imc <= IMC_SAUDAVEL && imc >= IMC_MAGRO;
    }

    public Utente oMaisNovoUtente(Utente utente) {
        if (this.idade > utente.idade) {
            return utente;
        } else if (this.idade == utente.idade) {
            return null;
        } else {
            return this;
        }
    }
}
