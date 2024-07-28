import java.util.logging.Logger;

class DeliveryWarehouseCenter implements Observer {
    private String location;
    private static final Logger logger = Logger.getLogger(DeliveryWarehouseCenter.class.getName());

    @Override
    public void update(String location) {
        if (location == null) {
            logger.warning("Location is null in DeliveryWarehouseCenter.update()");
            return;
        }
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        logger.info("Notification at Warehouse - Current Location: " + location);
    }
}
