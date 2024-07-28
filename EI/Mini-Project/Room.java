import java.util.*;
import java.util.logging.Logger;

class Room {
    private static final Logger logger = Logger.getLogger(Room.class.getName());
    private int number;
    private int maxCapacity;
    private boolean occupied;
    private List<Observer> observers = new ArrayList<>();
    private boolean booked;
    private int occupants;
    private long lastOccupiedTime;

    public Room(int number) {
        this.number = number;
        this.occupied = false;
        this.booked = false;
        this.occupants = 0;
        this.observers.add(new Light());
        this.observers.add(new AirConditioner());
    }

    public synchronized void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        System.out.println("Room " + number + " maximum capacity set to " + maxCapacity + ".");
    }

    public synchronized void addOccupants(int occupants) {
        if (occupants < 0 || occupants > maxCapacity) {
            logger.warning("Invalid number of occupants: " + occupants + " for room: " + number);
            System.out.println("Invalid number of occupants. Please enter a number between 0 and " + maxCapacity);
            return;
        }
        this.occupants = occupants;
        if (occupants >= 2) {
            this.occupied = true;
            this.lastOccupiedTime = System.currentTimeMillis();
            notifyObservers();
            System.out.println("Room " + number + " is now occupied by " + occupants + " persons. AC and lights turned on.");
        } else {
            this.occupied = false;
            notifyObservers();
            System.out.println("Room " + number + " is now unoccupied. AC and lights turned off.");
        }
    }

    public synchronized void book(String time, int duration) {
        if (!booked) {
            this.booked = true;
            System.out.println("Room " + number + " booked from " + time + " for " + duration + " minutes.");
        } else {
            System.out.println("Room " + number + " is already booked during this time. Cannot book.");
        }
    }

    public synchronized void cancel() {
        if (booked) {
            this.booked = false;
            System.out.println("Booking for Room " + number + " cancelled successfully.");
        } else {
            System.out.println("Room " + number + " is not booked. Cannot cancel booking.");
        }
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(occupied);
        }
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isBooked() {
        return booked;
    }

    public long getLastOccupiedTime() {
        return lastOccupiedTime;
    }

    public int getNumber() {
        return number;
    }
}
