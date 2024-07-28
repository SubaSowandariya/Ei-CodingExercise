import java.util.logging.Logger;
public class ComputerFactory {
    private static final Logger logger = Logger.getLogger(ComputerFactory.class.getName());

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if (type == null || ram == null || hdd == null || cpu == null) {
            logger.warning("Invalid arguments provided for ComputerFactory.getComputer()");
            throw new IllegalArgumentException("Invalid arguments provided");
        }

        if ("PC".equalsIgnoreCase(type)) {
            return new PC(ram, hdd, cpu);
        } else if ("Server".equalsIgnoreCase(type)) {
            return new Server(ram, hdd, cpu);
        } else {
            logger.warning("Unknown computer type: " + type);
            return null;
        }
    }
}
