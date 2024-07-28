class Light implements Observer {
    @Override
    public void update(boolean occupied) {
        if (occupied) {
            System.out.println("Lights turned on.");
        } else {
            System.out.println("Lights turned off.");
        }
    }
}
