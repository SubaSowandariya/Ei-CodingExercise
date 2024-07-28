import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonPatternTest {
    private static final Logger logger = Logger.getLogger(SingletonPatternTest.class.getName());

    public static void main(String[] args) {
        logger.info("Starting SingletonPatternTest");
        try {
            LoggerInstance logger1 = LoggerInstance.getInstance();
            LoggerInstance logger2 = LoggerInstance.getInstance();
            logger1.log("This is the first log message.");
            logger2.log("This is the second log message.");
            System.out.println(logger1 == logger2); 
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error in SingletonPatternTest", e);
        }
    }
}
