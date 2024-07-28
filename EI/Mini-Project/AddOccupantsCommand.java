class AddOccupantsCommand implements Command {
    private Room room;
    private int occupants;

    public AddOccupantsCommand(Room room, int occupants) {
        this.room = room;
        this.occupants = occupants;
    }

    @Override
    public void execute() {
        room.addOccupants(occupants);
    }
}
