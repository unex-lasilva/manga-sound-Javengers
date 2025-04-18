import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SimpleAudioPlayer {
    private Clip clip;
    private Long currentFrame;
    private AudioInputStream audioInputStream;
    private String filePath;

    public SimpleAudioPlayer(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.filePath = filePath;
        File audioFile = new File(filePath);

        if (!audioFile.exists()) {
            throw new IOException("Arquivo não encontrado: " + filePath);
        }

        audioInputStream = AudioSystem.getAudioInputStream(audioFile);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void pause() {
        currentFrame = clip.getMicrosecondPosition();
        clip.stop();
    }

    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.close();
        File audioFile = new File(filePath);
        audioInputStream = AudioSystem.getAudioInputStream(audioFile);
        clip.open(audioInputStream);
        clip.setMicrosecondPosition(currentFrame);
        clip.start();
    }

    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public boolean isPlaying() {
        return clip.isRunning();
    }
}
