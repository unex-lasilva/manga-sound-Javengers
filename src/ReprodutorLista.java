import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ReprodutorLista {
    private SimpleAudioPlayer player;

    public void reproduzirLista(ListaReproducao lista) {
        for (int i = 0; i < lista.getMusicas().getTamanho(); i++) {
            Musica musica = lista.getMusicas().get(i);
            System.out.println("▶ Tocando: " + musica);
            try {
                player = new SimpleAudioPlayer(musica.getPath());
                player.play();
                Thread.sleep(5000); // Só para simular, melhor com botão
                player.stop();
            } catch (Exception e) {
                System.out.println("Erro ao reproduzir: " + musica.getTitulo());
            }
        }
    }

    public void pausar() {
        if (player != null) player.pause();
    }

    public void executar() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (player != null) player.resumeAudio();
    }
}
