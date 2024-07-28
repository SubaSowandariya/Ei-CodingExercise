import java.util.logging.Logger;

public class MilkDecorator extends CoffeeDecorator {
    private static final Logger logger = Logger.getLogger(MilkDecorator.class.getName());

    public MilkDecorator(Coffee c) {
        super(c);
    }

    @Override
    public void prepare() {
        super.prepare();
        logger.info("Adding Milk");
        System.out.println("Adding Milk");
    }
}
