import estruturas.ListaEncadeada;

public class ListaReproducao {
    private String titulo;
    private ListaEncadeada<Musica> musicas;

    public ListaReproducao(String titulo) {
        this.titulo = titulo;
        this.musicas = new ListaEncadeada<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public ListaEncadeada<Musica> getMusicas() {
        return musicas;
    }

    public void adicionarMusica(Musica musica) {
        musicas.adicionar(musica);
    }

    public void adicionarMusicaEmPosicao(Musica musica, int posicao) {
        musicas.adicionarNaPosicao(musica, posicao);
    }

    public void removerMusicaPorTitulo(String tituloMusica) {
        for (int i = 0; i < musicas.getTamanho(); i++) {
            if (musicas.get(i).getTitulo().equalsIgnoreCase(tituloMusica)) {
                musicas.remover(i);
                break;
            }
        }
    }

    public void removerMusicaPorPosicao(int posicao) {
        musicas.remover(posicao);
    }
}
