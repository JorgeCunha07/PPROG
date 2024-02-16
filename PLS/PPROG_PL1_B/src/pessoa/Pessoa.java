package pessoa;

/**
 * Representa uma data através do dia, mês e ano.
 *
 * @author ISEP-DEI-PPROG
 */
public class Pessoa {
    private static final String NOME_POR_OMISSAO = "Omitido";
    private static final int IDADE_POR_OMISSAO = 0;
    /**
     * O Nome da pessoa.
     */

    private String nome;

    /**
     * Idade da pessoa.
     */

    private int idade;

    /**
     * Constrói uma instância de construtorCumpi com o nome por omissão.
     */


    public Pessoa() {
        nome = NOME_POR_OMISSAO;
        idade = IDADE_POR_OMISSAO;

    }

    /**
     * Constrói uma instância de construtorCumpi recebendo nome.
     *
     * @param nome igual a nome.
     */
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(String nome) {
        this.nome = nome;
        this.idade = IDADE_POR_OMISSAO;
    }

    /**
     * Devolve o nome .
     *
     * @return nome do construtorCumpi.
     */
    public String getnome() {
        return nome;
    }
    /**
     * Devolve a idade .
     *
     * @return idade do construtorCumpi.
     */
    public int getidade() {
        return idade;
    }

    /**
     * Modifica o nome.
     *
     * @param nome para novo nome da construtorCumpi.

     */
    public void setNomepessoa(String nome) {
        this.nome = nome;
    }
    /**
     * Modifica a idade.
     *
     * @param idade para novo idade da construtorCumpi.

     */
    public void setIdadepessoa(int idade) {
        this.idade = idade;
    }
/**
 * Devolve a descrição textual.
 */

    public String toString() {
        return   "O nome é " + nome + " e tem " + idade +" anos.";

    }


}