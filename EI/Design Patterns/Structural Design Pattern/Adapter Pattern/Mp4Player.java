import java.util.logging.Logger;
public class Mp4Player implements AdvancedMediaPlayer {
    private static final Logger logger = Logger.getLogger(Mp4Player.class.getName());
    @Override
    public void playVlc(String fileName) {
    }

    @Override
    public void playMp4(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            logger.warning("Invalid file name for Mp4Player");
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
