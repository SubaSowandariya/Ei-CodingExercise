import java.util.logging.Logger;

public class CaramelDecorator extends CoffeeDecorator {
    private static final Logger logger = Logger.getLogger(CaramelDecorator.class.getName());

    public CaramelDecorator(Coffee c) {
        super(c);
    }

    @Override
    public void prepare() {
        super.prepare();
        logger.info("Adding Caramel");
        System.out.println("Adding Caramel");
    }
}
