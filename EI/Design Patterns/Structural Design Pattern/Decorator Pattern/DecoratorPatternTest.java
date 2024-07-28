import java.util.logging.Level;
import java.util.logging.Logger;

public class DecoratorPatternTest {
    private static final Logger logger = Logger.getLogger(DecoratorPatternTest.class.getName());

    public static void main(String[] args) {
        logger.info("Starting DecoratorPatternTest");
        try {
            Coffee milkCoffee = new MilkDecorator(new BasicCoffee());
            milkCoffee.prepare();
            System.out.println();

            Coffee sugarCoffee = new SugarDecorator(new BasicCoffee());
            sugarCoffee.prepare();
            System.out.println();

            Coffee caramelCoffee = new CaramelDecorator(new BasicCoffee());
            caramelCoffee.prepare();
            System.out.println();

            Coffee milkSugarCoffee = new MilkDecorator(new SugarDecorator(new BasicCoffee()));
            milkSugarCoffee.prepare();
            System.out.println();

            Coffee caramelMilkCoffee = new CaramelDecorator(new MilkDecorator(new BasicCoffee()));
            caramelMilkCoffee.prepare();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error in DecoratorPatternTest", e);
        }
    }
}
