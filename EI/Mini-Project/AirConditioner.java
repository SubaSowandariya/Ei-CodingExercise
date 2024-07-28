class AirConditioner implements Observer {
    @Override
    public void update(boolean occupied) {
        if (occupied) {
            System.out.println("Air conditioner turned on.");
        } else {
            System.out.println("Air conditioner turned off.");
        }
    }
}
