
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReprodutorLista {
    private Clip clip;
    private int musicaAtual = 0;
    private ListaReproducao listaReproducao;
    private Scanner scanner = new Scanner(System.in);

    public void reproduzirLista(ListaReproducao lista) {
        this.listaReproducao = lista;

        if (lista.getMusicas().getTamanho() == 0) {
            System.out.println("⚠ Lista de reprodução vazia.");
            return;
        }

        musicaAtual = 0;
        tocarMusica();
    }

    private void tocarMusica() {
        while (musicaAtual < listaReproducao.getMusicas().getTamanho()) {
            Musica musica = listaReproducao.getMusicas().get(musicaAtual);
            System.out.println("\n🎵 Tocando: " + musica.getTitulo() + " - " + musica.getArtista());

            try {
                File arquivo = new File(musica.getPath());
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(arquivo);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();

                long inicio = System.currentTimeMillis();

                boolean tocando = true;
                while (tocando) {
                    System.out.println("\n[1] Parar [2] Próxima [3] Voltar");
                    String comando = scanner.nextLine();

                    switch (comando) {
                        case "1":
                            clip.stop();
                            clip.close();
                            return;

                        case "2":
                            clip.stop();
                            clip.close();
                            musicaAtual++;
                            tocando = false;
                            break;

                        case "3":
                            long tempo = (System.currentTimeMillis() - inicio) / 1000;
                            clip.stop();
                            clip.close();

                            if (tempo > 10 || musicaAtual == 0) {
                                System.out.println("🔁 Reiniciando a música atual...");
                                // mantém musicaAtual
                            } else {
                                musicaAtual--;
                                System.out.println("⏮ Voltando para a música anterior...");
                            }
                            tocando = false;
                            break;

                        default:
                            System.out.println("❌ Comando inválido.");
                    }
                }

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println("❌ Erro ao tocar música: " + e.getMessage());
                musicaAtual++;
            }
        }

        System.out.println("\n🎶 Fim da lista de reprodução.");
    }
}

