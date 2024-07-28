import java.util.logging.Logger;
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;
    private static final Logger logger = Logger.getLogger(AudioPlayer.class.getName());

    @Override
    public void play(String audioType, String fileName) {
        if (audioType == null || audioType.isEmpty() || fileName == null || fileName.isEmpty()) {
            logger.warning("Invalid arguments for AudioPlayer.play()");
            throw new IllegalArgumentException("Audio type and file name cannot be null or empty");
        }

        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            logger.warning("Invalid media. " + audioType + " format not supported");
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
