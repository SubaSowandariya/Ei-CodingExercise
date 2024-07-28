import java.util.logging.Logger;

public class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    private static final Logger logger = Logger.getLogger(CoffeeDecorator.class.getName());

    public CoffeeDecorator(Coffee c) {
        if (c == null) {
            logger.warning("Coffee instance is null in CoffeeDecorator");
            throw new IllegalArgumentException("Coffee instance cannot be null");
        }
        this.coffee = c;
    }

    @Override
    public void prepare() {
        if (coffee == null) {
            logger.warning("Coffee instance is null in CoffeeDecorator.prepare()");
            throw new IllegalStateException("Coffee instance is not set");
        }
        this.coffee.prepare();
    }
}
