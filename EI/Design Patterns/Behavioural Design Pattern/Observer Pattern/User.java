import java.util.logging.Logger;

class User implements Observer {
    private String location;
    private static final Logger logger = Logger.getLogger(User.class.getName());

    @Override
    public void update(String location) {
        if (location == null) {
            logger.warning("Location is null in User.update()");
            return;
        }
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        logger.info("Notification at User - Current Location: " + location);
    }
}
