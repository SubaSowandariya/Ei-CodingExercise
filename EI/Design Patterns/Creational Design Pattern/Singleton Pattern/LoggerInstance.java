import java.util.logging.Logger;

public class LoggerInstance {
    private static volatile LoggerInstance instance;
    private static final Logger logger = Logger.getLogger(LoggerInstance.class.getName());

    private LoggerInstance() {}

    public static LoggerInstance getInstance() {
        if (instance == null) {
            synchronized (LoggerInstance.class) {
                if (instance == null) {
                    instance = new LoggerInstance();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        if (message == null || message.isEmpty()) {
            logger.warning("Invalid message for log");
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        System.out.println("Log: " + message);
    }
}
