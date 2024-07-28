import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SmartOffice {
    private static final Logger logger = Logger.getLogger(SmartOffice.class.getName());

    public static void main(String[] args) {
        Office office = Office.getInstance();
        Scanner scanner = new Scanner(System.in);
        displayWelcomeMessage();
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter command:");
            String commandLine = scanner.nextLine().trim();
            String[] commandParts = commandLine.split("\\s+");
            String commandType = commandParts[0];
            try {
                switch (commandType) {
                    case "Config":
                        handleConfigCommand(office, commandParts);
                        break;
                    case "ConfigRoomCapacity":
                        handleConfigRoomCapacityCommand(office, commandParts);
                        break;
                    case "AddOccupant":
                        handleAddOccupantCommand(office, commandParts);
                        break;
                    case "BlockRoom":
                        handleBlockRoomCommand(office, commandParts);
                        break;
                    case "CancelRoom":
                        handleCancelRoomCommand(office, commandParts);
                        break;
                    case "RoomStatus":
                        handleRoomStatusCommand(office, commandParts);
                        break;
                    case "Summary":
                        handleSummaryCommand(office);
                        break;
                    case "exit":
                        exit = true;
                        System.out.println("Thank you for using the Smart Office Facility Application. Have a great day!");
                        break;
                    default:
                        logger.warning("Invalid command: " + commandLine);
                        System.out.println("Invalid command.");
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error executing command: " + commandLine, e);
                System.out.println("Error executing command: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to Console-Based Smart Office Facility Application!");
        System.out.println("Available commands:");
        System.out.println("1. Config room count <number>");
        System.out.println("2. ConfigRoomCapacity <roomNumber> <maxCapacity>");
        System.out.println("3. AddOccupant <roomNumber> <occupants>");
        System.out.println("4. BlockRoom <roomNumber> <time> <duration>");
        System.out.println("5. CancelRoom <roomNumber>");
        System.out.println("6. RoomStatus <roomNumber>");
        System.out.println("7. Summary");
        System.out.println("8. exit");
    }

    private static void handleConfigCommand(Office office, String[] commandParts) {
        if (commandParts.length == 4 && commandParts[1].equalsIgnoreCase("room") && commandParts[2].equalsIgnoreCase("count")) {
            try {
                int roomCount = Integer.parseInt(commandParts[3]);
                new ConfigureCommand(office, roomCount).execute();
            } catch (NumberFormatException e) {
                logger.warning("Invalid room count: " + commandParts[3]);
                System.out.println("Invalid room count. Please enter a valid number.");
            }
        } else {
            System.out.println("Invalid command format for Config. Usage: Config room count <number>");
        }
    }

    private static void handleConfigRoomCapacityCommand(Office office, String[] commandParts) {
        if (commandParts.length == 3) {
            try {
                int roomNumber = Integer.parseInt(commandParts[1]);
                int maxCapacity = Integer.parseInt(commandParts[2]);
                if (maxCapacity <= 0) {
                    System.out.println("Invalid capacity. Please enter a valid positive number.");
                    return;
                }
                Room room = office.getRoom(roomNumber);
                if (room != null) {
                    room.setMaxCapacity(maxCapacity);
                } else {
                    System.out.println("Invalid room number. Please enter a valid room number.");
                }
            } catch (NumberFormatException e) {
                logger.warning("Invalid room number or capacity. Room number: " + commandParts[1] + ", Capacity: " + commandParts[2]);
                System.out.println("Invalid room number or capacity. Please enter valid numbers.");
            }
        } else {
            System.out.println("Invalid command format for ConfigRoomCapacity. Usage: ConfigRoomCapacity <roomNumber> <maxCapacity>");
        }
    }

    private static void handleAddOccupantCommand(Office office, String[] commandParts) {
        if (commandParts.length == 3) {
            try {
                int roomNumber = Integer.parseInt(commandParts[1]);
                int occupants = Integer.parseInt(commandParts[2]);
                Room room = office.getRoom(roomNumber);
                if (room != null) {
                    new AddOccupantsCommand(room, occupants).execute();
                } else {
                    System.out.println("Room " + roomNumber + " does not exist.");
                }
            } catch (NumberFormatException e) {
                logger.warning("Invalid room number or number of occupants. Room number: " + commandParts[1] + ", Occupants: " + commandParts[2]);
                System.out.println("Invalid room number or number of occupants. Please enter valid numbers.");
            }
        } else {
            System.out.println("Invalid command format for AddOccupant. Usage: AddOccupant <roomNumber> <occupants>");
        }
    }

    private static void handleBlockRoomCommand(Office office, String[] commandParts) {
        if (commandParts.length == 4) {
            try {
                int roomNumber = Integer.parseInt(commandParts[1]);
                String time = commandParts[2];
                int duration = Integer.parseInt(commandParts[3]);
                Room room = office.getRoom(roomNumber);
                if (room != null) {
                    new BookCommand(room, time, duration).execute();
                } else {
                    System.out.println("Invalid room number. Please enter a valid room number.");
                }
            } catch (NumberFormatException e) {
                logger.warning("Invalid room number or duration. Room number: " + commandParts[1] + ", Duration: " + commandParts[3]);
                System.out.println("Invalid room number or duration. Please enter valid numbers.");
            }
        } else {
            System.out.println("Invalid command format for BlockRoom. Usage: BlockRoom <roomNumber> <time> <duration>");
        }
    }

    private static void handleCancelRoomCommand(Office office, String[] commandParts) {
        if (commandParts.length == 2) {
            try {
                int roomNumber = Integer.parseInt(commandParts[1]);
                Room room = office.getRoom(roomNumber);
                if (room != null) {
                    new CancelCommand(room).execute();
                } else {
                    System.out.println("Invalid room number. Please enter a valid room number.");
                }
            } catch (NumberFormatException e) {
                logger.warning("Invalid room number: " + commandParts[1]);
                System.out.println("Invalid room number. Please enter a valid number.");
            }
        } else {
            System.out.println("Invalid command format for CancelRoom. Usage: CancelRoom <roomNumber>");
        }
    }

    private static void handleRoomStatusCommand(Office office, String[] commandParts) {
        if (commandParts.length == 2) {
            try {
                int roomNumber = Integer.parseInt(commandParts[1]);
                Room room = office.getRoom(roomNumber);
                if (room != null) {
                    if (!room.isOccupied() && room.isBooked() && (System.currentTimeMillis() - room.getLastOccupiedTime() > 300000)) {
                        room.cancel();
                        room.addOccupants(0);
                        System.out.println("Room " + roomNumber + " is now unoccupied. Booking released. AC and lights off.");
                    } else {
                        System.out.println("Room " + roomNumber + " is currently occupied.");
                    }
                } else {
                    System.out.println("Invalid room number. Please enter a valid room number.");
                }
            } catch (NumberFormatException e) {
                logger.warning("Invalid room number: " + commandParts[1]);
                System.out.println("Invalid room number. Please enter a valid number.");
            }
        } else {
            System.out.println("Invalid command format for RoomStatus. Usage: RoomStatus <roomNumber>");
        }
    }

    private static void handleSummaryCommand(Office office) {
        for (Room r : office.getRooms()) {
            System.out.println("Room " + r.getNumber() + ": " + (r.isOccupied() ? "Occupied" : "Unoccupied") + ", " + (r.isBooked() ? "Booked" : "Not Booked"));
        }
    }
}
