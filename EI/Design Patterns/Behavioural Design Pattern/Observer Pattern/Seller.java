import java.util.logging.Logger;

class Seller implements Observer {
    private String location;
    private static final Logger logger = Logger.getLogger(Seller.class.getName());

    @Override
    public void update(String location) {
        if (location == null) {
            logger.warning("Location is null in Seller.update()");
            return;
        }
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        logger.info("Notification at Seller - Current Location: " + location);
    }
}
