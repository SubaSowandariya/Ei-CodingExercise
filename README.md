# Ei-Coding-Exercise

1.Design Patterns

2.Mini-Project

**Prerequisites**

Before you begin, ensure you have the following installed:

JDK (Java Development Kit) ☕

IDE (Integrated Development Environment) 🛠️

# Design Patterns in Java ☕

Welcome to the repository showcasing various design patterns in Java with different use cases! This project demonstrates six common design patterns, each in a unique application context.

*I.Behavioural Design Pattern:*

1.**Observer Pattern**👀

Folder: Observer Pattern

Use Case: Tracking the location of deliveries.

Description: Demonstrates the Observer design pattern, where DeliveryData (the Subject) maintains a list of Observer objects (Seller, User, DeliveryWarehouseCenter). When the delivery location changes, DeliveryData notifies all registered observers about the update by calling their update methods. Observers respond to the change and log the new location. This pattern ensures that all observers are kept in sync with the subject's state changes.

Output:
![Observer Pattern-Output](https://github.com/user-attachments/assets/ffdaf28f-0ec3-40f6-8e23-1109b6c8bfd4)

2.**Strategy Pattern**🎯

Folder: Strategy Pattern

Use Case: Calculating travel time using different travel methods.

Description: The Strategy design pattern, where the TravelContext can dynamically change its travel strategy to calculate travel time based on different modes of transportation (Car, Bike, Walking). Each mode of transportation implements the TravelStrategy interface with its specific logic for calculating travel time. By setting different strategies in TravelContext, the program can determine the travel time for a given distance according to the selected mode of transportation. This approach promotes flexibility and reusability by decoupling the travel time calculation logic from the context in which it is used.

Output:
![StrategyPattern-Output](https://github.com/user-attachments/assets/851e4663-4294-4c9c-9822-6c62b4805442)

*II.Creational Design Pattern:*

1.**Singleton Pattern**🔒

Folder: Singleton Pattern

Use Case: Managing a single instance of a Logger for logging messages.

Description: Demonstrates the Singleton design pattern, ensuring that only one instance of the LoggerInstance class exists throughout the application. The LoggerInstance class provides a global point of access to the single instance via the getInstance method, which uses double-checked locking to ensure thread safety. The log method in LoggerInstance allows logging messages, and the SingletonPatternTest class tests the singleton behavior by verifying that logger1 and logger2 refer to the same instance. This pattern is useful for managing resources such as logging in a centralized manner, preventing the creation of multiple instances that could lead to inconsistent states or resource wastage.

Output:
![SingletonPattern-Output](https://github.com/user-attachments/assets/d9502e1e-46f7-4c24-afe3-637fbc069a90)

2.**Factory Pattern**🏭

Folder: Factory Pattern

Use Case: Creating different types of computer objects (PC and Server) based on provided specifications.

Description: Demonstrates the Factory design pattern, which defines an interface for creating objects but lets subclasses alter the type of objects that will be created. The ComputerFactory class provides a static method, getComputer, that takes parameters for the type of computer (either "PC" or "Server") along with its specifications (RAM, HDD, CPU). Depending on the type specified, it returns an instance of either PC or Server. This approach encapsulates the object creation logic and provides a flexible and reusable way to create objects without specifying the exact class of the object that will be created. This pattern is useful for creating families of related or dependent objects without specifying their concrete classes.

Output:
![FactoryPattern-Output](https://github.com/user-attachments/assets/004d7b19-c834-4dfd-b986-8e000bfae45f)

*III.Structural Design Pattern:*

1.**Adapter Pattern**🔌

Folder: Adapter Pattern

Use Case: Integrating different media players.

Description: Demonstrates the Adapter design pattern, which allows incompatible interfaces to work together. In this example, the MediaAdapter class adapts the interfaces of VlcPlayer and Mp4Player to the MediaPlayer interface. This enables the AudioPlayer class to play different types of audio formats (mp3, vlc, mp4) without modifying their existing interfaces. By implementing the MediaPlayer interface, the MediaAdapter provides a consistent method to play different media types, encapsulating the specific logic for each format and ensuring compatibility. This pattern is particularly useful for integrating new features into existing systems without disrupting the existing codebase.

Output:
![AdapterPattern-Output](https://github.com/user-attachments/assets/15c66197-d4da-4a43-823c-a2249a848b31)

2. **Decorator Pattern**🎨

Folder: Decorator Pattern

Use Case: Enhancing coffee with various add-ons.

Description: Demonstrates the Decorator design pattern, which dynamically adds functionalities (milk, sugar, caramel) to a basic coffee. The BasicCoffee class implements the Coffee interface, while the CoffeeDecorator class, an abstract class also implementing Coffee, wraps a Coffee object to delegate the prepare method. Concrete decorators (MilkDecorator, SugarDecorator, CaramelDecorator) extend CoffeeDecorator, each adding specific behavior (e.g., adding milk, sugar, or caramel) to the prepare method. This pattern allows flexible, extensible enhancement of coffee preparation without modifying existing code.

Output:
![DecoratorPattern-Output](https://github.com/user-attachments/assets/3e5a3aa9-cee1-4ba2-b3d0-508e9729b042)

# Mini-Project 📋

🏢**Smart Office Facility Application**📊

Welcome to the Smart Office Facility Application! This tool provides an efficient way to manage your office's meeting rooms with a variety of commands and features. 🌟

🚀*Features*

**Configure Room Count**: Set the total number of meeting rooms in your office.

**Set Room Capacity**: Define the maximum capacity for each room.

**Add Occupants**: Update the number of people currently in a room.

**Book a Room**: Reserve a room for a specific time and duration.

**Cancel a Booking**: Release a previously booked room.

**Check Room Status**: Get the current occupancy and booking status of a room.

**View Summary**: See a summary of all rooms' statuses.

**Exit Application**: Close the application.

🎨*Design Patterns Used*

**Singleton Pattern**🏠: Ensures a single instance of the Office class for managing room configurations.

**Observer Pattern**👀: Updates Light and AirConditioner based on room occupancy status changes.

**Command Pattern**📜: Encapsulates requests (like booking a room or adding occupants) as command objects for flexible execution.

📂*How It Works*

1.**Configuration**:

Configure the number of meeting rooms with the Config room count <number> command.

Set the maximum capacity of a room using ConfigRoomCapacity <roomNumber> <maxCapacity>.

2.**Occupancy Management**:

Add occupants to a room with AddOccupant <roomNumber> <occupants>.

Rooms automatically update their status, turning lights and air conditioning on or off as needed.

3.**Booking and Cancellation**:

Book a room using BlockRoom <roomNumber> <time> <duration>.

Cancel a booking with CancelRoom <roomNumber>.

4.**Status and Summary**:

Check a room's current status with RoomStatus <roomNumber>.

View a summary of all rooms with the Summary command.

5.**Exit**:

Close the application with the exit command.

📋*Example Commands*

-Configure 5 rooms: Config room count 5

-Set Room 3 capacity to 20: ConfigRoomCapacity 3 20

-Add 10 occupants to Room 2: AddOccupant 2 10

-Book Room 1 at 10:00 for 60 minutes: BlockRoom 1 10:00 60

-Cancel Room 4 booking: CancelRoom 4

-Check status of Room 3: RoomStatus 3

-View summary: Summary

-Exit application: exit

📈*Application Flow*

**Start**: Initialize the application and display available commands.

**Command Input**: Enter commands to configure rooms, manage bookings, or check statuses.

**Execution**: The application processes commands, updates room states, and provides summary.

Here how's the application works:

![Picture1](https://github.com/user-attachments/assets/6a89cf0c-38c1-4632-b1f3-64766916ad1f)

**For any questions or support, please contact**:

subasathish6060@gmail.com

Github: https://github.com/SubaSowandariya
