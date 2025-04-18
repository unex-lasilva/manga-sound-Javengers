public class Musica {
    private String titulo;
    private String path;
    private String artista;

    public Musica(String titulo, String artista, String path) {
        this.titulo = titulo;
        this.artista = artista;
        this.path = path;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista;
    }
}
