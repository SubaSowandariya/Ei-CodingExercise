class WalkTravelStrategy implements TravelStrategy {
    @Override
    public int calculateTravelTime(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }
        return distance / 5;
    }
}
