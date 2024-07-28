import java.util.logging.Logger;
public class VlcPlayer implements AdvancedMediaPlayer {
    private static final Logger logger = Logger.getLogger(VlcPlayer.class.getName());

    @Override
    public void playVlc(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            logger.warning("Invalid file name for VlcPlayer");
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // Do nothing
    }
}
