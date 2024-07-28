import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class DeliveryData implements Subject {
    private List<Observer> observers;
    private String location;
    private static final Logger logger = Logger.getLogger(DeliveryData.class.getName());

    public DeliveryData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            try {
                obj.update(location);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Failed to update observer", e);
            }
        }
    }

    public void locationChanged() {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation() {
        return "Bangalore";
    }
}
