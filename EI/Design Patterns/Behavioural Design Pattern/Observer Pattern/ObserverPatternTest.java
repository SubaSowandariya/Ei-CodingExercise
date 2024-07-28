import java.util.logging.Level;
import java.util.logging.Logger;

public class ObserverPatternTest {
    private static final Logger logger = Logger.getLogger(ObserverPatternTest.class.getName());

    public static void main(String[] args) {
        logger.info("Starting ObserverPatternTest");
        DeliveryData topic = new DeliveryData();
        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);
        topic.locationChanged();
        topic.unregister(obj3);
        logger.info("Unregistered DeliveryWarehouseCenter observer");
        topic.locationChanged();
    }
}
