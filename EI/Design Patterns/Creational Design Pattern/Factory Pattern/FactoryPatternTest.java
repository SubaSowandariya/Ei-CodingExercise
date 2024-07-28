import java.util.logging.Level;
import java.util.logging.Logger;
public class FactoryPatternTest {
    private static final Logger logger = Logger.getLogger(FactoryPatternTest.class.getName());

    public static void main(String[] args) {
        logger.info("Starting FactoryPatternTest");
        try {
            Computer pc = ComputerFactory.getComputer("PC", "16 GB", "1 TB", "2.9 GHz");
            System.out.println("Factory PC Config::" + pc);

            Computer server = ComputerFactory.getComputer("Server", "32 GB", "2 TB", "3.5 GHz");
            System.out.println("Factory Server Config::" + server);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating computer", e);
        }
    }
}
