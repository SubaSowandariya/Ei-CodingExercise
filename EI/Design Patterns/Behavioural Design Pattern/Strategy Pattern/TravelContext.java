import java.util.logging.Logger;
class TravelContext {
    private TravelStrategy strategy;
    private static final Logger logger = Logger.getLogger(TravelContext.class.getName());

    public void setStrategy(TravelStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        this.strategy = strategy;
    }

    public int executeStrategy(int distance) {
        if (strategy == null) {
            logger.warning("Strategy is null in TravelContext.executeStrategy()");
            throw new IllegalStateException("Travel strategy is not set");
        }
        return strategy.calculateTravelTime(distance);
    }
}
