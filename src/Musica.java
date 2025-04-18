import java.io.File;
public class Musica {
    private String titulo;
    private String path;
    private String artista;

    public Musica(String titulo, String artista, String path) {
        if (!path.endsWith(".wav")) {
            throw new IllegalArgumentException("❌ O arquivo precisa estar no formato .wav.");
        }

        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("❌ Arquivo não encontrado no caminho especificado.");

        }


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