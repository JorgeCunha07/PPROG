package APP;

public class Quadro implements Comparable<Quadro>{

    private String nomeAutor;
    private float designacao;
    private Data anoCriacao;

    private final String NOME_AUTOR_POR_OMISSAO = "Sem Nome";
    private final float DESIGNACAO_POR_OMISSAO = 0;
    private final Data ANOCRIACAO_POR_OMISSAO = null;

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public float getDesignacao() {
        return designacao;
    }

    public void setDesignacao(float designacao) {
        this.designacao = designacao;
    }

    public Data getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(Data anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Quadro)) {
            return false;
        }
        if (this.nomeAutor.compareTo(nomeAutor) == 0) {
            if (Float.compare(this.designacao, designacao) == 0) {
                return this.anoCriacao.compareTo(anoCriacao) == 0;
            }
        }
        return false;
    }
    @Override
    public int compareTo(Quadro o) {

        String nome1= this.getNomeAutor();
        String nome2 =  o.getNomeAutor();

        return nome1.compareTo(nome2);
    }
}
