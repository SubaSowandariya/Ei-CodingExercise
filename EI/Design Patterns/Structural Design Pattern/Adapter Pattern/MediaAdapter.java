import java.util.logging.Logger;
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;
    private static final Logger logger = Logger.getLogger(MediaAdapter.class.getName());
    public MediaAdapter(String audioType) {
        if (audioType == null || audioType.isEmpty()) {
            logger.warning("Invalid audio type for MediaAdapter");
            throw new IllegalArgumentException("Audio type cannot be null or empty");
        }

        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType == null || audioType.isEmpty() || fileName == null || fileName.isEmpty()) {
            logger.warning("Invalid arguments for MediaAdapter.play()");
            throw new IllegalArgumentException("Audio type and file name cannot be null or empty");
        }

        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
