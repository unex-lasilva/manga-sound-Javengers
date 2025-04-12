import estruturas.ListaEncadeada;

public class Artista {
    private String nome;
    private ListaEncadeada<Musica> musicas;

    public Artista(String nome) {
        this.nome = nome;
        this.musicas = new ListaEncadeada<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.adicionar(musica);
    }

    public String getNome() {
        return nome;
    }

    public ListaEncadeada<Musica> getMusicas() {
        return musicas;
    }
}
