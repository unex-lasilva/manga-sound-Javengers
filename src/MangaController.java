import estruturas.ListaEncadeada;
import estruturas.No;

public class MangaController {
    private ListaEncadeada<Musica> repositorio;
    private ListaEncadeada<Artista> artistas;

    public MangaController() {
        repositorio = new ListaEncadeada<>();
        artistas = new ListaEncadeada<>();
    }

    public void adicionarMusica(String titulo, String path, String nomeArtista) {
        Musica musica = new Musica(titulo, nomeArtista, path);

        repositorio.adicionar(musica);

        Artista artista = buscarArtista(nomeArtista);
        if (artista == null) {
            artista = new Artista(nomeArtista);
            artistas.adicionar(artista);
        }

        artista.adicionarMusica(musica);
        System.out.println("✅ Música adicionada com sucesso!");
    }

    private Artista buscarArtista(String nome) {
        No<Artista> atual = artistas.getInicio();
        while (atual != null) {
            if (atual.dado.getNome().equalsIgnoreCase(nome)) {
                return atual.dado;
            }
            atual = atual.proximo;
        }
        return null;
    }
}