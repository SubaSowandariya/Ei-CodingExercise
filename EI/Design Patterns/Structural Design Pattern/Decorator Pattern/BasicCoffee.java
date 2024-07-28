import java.util.logging.Logger;

public class BasicCoffee implements Coffee {
    private static final Logger logger = Logger.getLogger(BasicCoffee.class.getName());

    @Override
    public void prepare() {
        logger.info("Preparing Basic Coffee");
        System.out.println("Basic Coffee");
    }
}
