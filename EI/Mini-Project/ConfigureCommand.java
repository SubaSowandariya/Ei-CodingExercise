class ConfigureCommand implements Command {
    private Office office;
    private int roomCount;

    public ConfigureCommand(Office office, int roomCount) {
        this.office = office;
        this.roomCount = roomCount;
    }

    @Override
    public void execute() {
        office.configure(roomCount);
    }
}
