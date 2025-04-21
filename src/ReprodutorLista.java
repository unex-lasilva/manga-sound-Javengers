

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


                Thread.sleep(5000); // Simulação de 5 segundos
                player.stop();
            } catch (Exception e) {
                System.out.println("Erro ao reproduzir: " + musica.getTitulo());
                e.printStackTrace();

            }
        }
    }

    public void pausar() {
        if (player != null) player.pause();
    }


    public void executar() {
        if (player != null) {
            try {
                player.resumeAudio();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


