package modelos;

public class Titulo {
    private String nome;
    private int anoDeLancamento;
    private int duracao;

    private String rated;



    public Titulo(TituloOmdb tituloOmdb){
        this.nome = tituloOmdb.title();
        if(tituloOmdb.year().length() > 4){
            throw new RuntimeException("Não foi possivel converter o ano");
        }
        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year());
        this.duracao = Integer.valueOf(tituloOmdb.runtime().substring(0,2));
        this.rated = tituloOmdb.rated();

    }

    public String getRated() {
        return rated;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "Titulo: " + nome + '\'' +
                ", anoDeLancamento: " + anoDeLancamento + '\'' +
                ", duracao: " + duracao +
                ", Rated: " + rated;

    }
}
