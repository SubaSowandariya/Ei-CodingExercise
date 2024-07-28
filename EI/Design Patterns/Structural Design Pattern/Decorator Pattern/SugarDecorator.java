import java.util.logging.Logger;

public class SugarDecorator extends CoffeeDecorator {
    private static final Logger logger = Logger.getLogger(SugarDecorator.class.getName());

    public SugarDecorator(Coffee c) {
        super(c);
    }

    @Override
    public void prepare() {
        super.prepare();
        logger.info("Adding Sugar");
        System.out.println("Adding Sugar");
    }
}
