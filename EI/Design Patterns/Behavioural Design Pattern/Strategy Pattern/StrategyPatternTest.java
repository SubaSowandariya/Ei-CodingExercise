import java.util.logging.Level;
import java.util.logging.Logger;
public class StrategyPatternTest {
    private static final Logger logger = Logger.getLogger(StrategyPatternTest.class.getName());

    public static void main(String[] args) {
        logger.info("Starting StrategyPatternTest");
        TravelContext context = new TravelContext();
        try {
            context.setStrategy(new CarTravelStrategy());
            System.out.println("Travel time by car: " + context.executeStrategy(120) + " hours");

            context.setStrategy(new BikeTravelStrategy());
            System.out.println("Travel time by bike: " + context.executeStrategy(120) + " hours");

            context.setStrategy(new WalkTravelStrategy());
            System.out.println("Travel time by walking: " + context.executeStrategy(120) + " hours");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error executing travel strategy", e);
        }
    }
}
