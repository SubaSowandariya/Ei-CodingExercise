import java.util.logging.Level;
import java.util.logging.Logger;
public class AdapterPatternTest {
    private static final Logger logger = Logger.getLogger(AdapterPatternTest.class.getName());

    public static void main(String[] args) {
        logger.info("Starting AdapterPatternTest");
        try {
            AudioPlayer audioPlayer = new AudioPlayer();
            audioPlayer.play("mp3", "song.mp3");
            audioPlayer.play("mp4", "video.mp4");
            audioPlayer.play("vlc", "movie.vlc");
            audioPlayer.play("avi", "myMovie.avi");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error in AdapterPatternTest", e);
        }
    }
}
