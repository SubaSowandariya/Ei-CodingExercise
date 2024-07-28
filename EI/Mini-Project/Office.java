import java.util.*;
import java.util.logging.Logger;

class Office {
    private static final Logger logger = Logger.getLogger(Office.class.getName());
    private static Office instance;
    private Map<Integer, Room> rooms = new HashMap<>();

    private Office() {}

    public static synchronized Office getInstance() {
        if (instance == null) {
            instance = new Office();
        }
        return instance;
    }

    public synchronized void configure(int roomCount) {
        rooms.clear();
        for (int i = 1; i <= roomCount; i++) {
            rooms.put(i, new Room(i));
        }
        System.out.println("Office configured with " + roomCount + " meeting rooms: " + generateRoomNames(roomCount));
    }

    private String generateRoomNames(int roomCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= roomCount; i++) {
            sb.append("Room ").append(i);
            if (i < roomCount){
            sb.append(", ");
            }
        }
        return sb.toString();
    }

    public synchronized Room getRoom(int roomNumber) {
        return rooms.get(roomNumber);
    }

    public synchronized Collection<Room> getRooms() {
        return rooms.values();
    }
}