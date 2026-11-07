# Airline Ticket Booking System

A console-based Airline Ticket Booking System built using Java. This project demonstrates Object-Oriented Programming (OOP) concepts through flight management, ticket booking, and cancellation.

## About

This project allows users to view available flight schedules, book flight tickets, cancel bookings, and view passenger booking details.

The system provides three predefined flights with different routes, departure times, ticket prices, and available seats.

Users can book multiple seats, and the system automatically calculates the total fare and updates seat availability.

## Features

- View available flight schedules
- Book flight tickets
- Cancel existing bookings
- View passenger bookings
- Book multiple seats
- Automatically calculate total ticket fare
- Update available seats after booking
- Release seats after cancellation
- Generate unique booking IDs
- Validate flight IDs
- Check seat availability
- Handle invalid menu choices

## OOP Concepts Used

### 1. Encapsulation
Private attributes are used in the `Flight` and `Booking` classes. Getters provide controlled access to these attributes.

### 2. Inheritance
The `FlightBooking` class extends the abstract `Booking` class using the `extends` keyword.

### 3. Polymorphism
Method overriding is used in the `FlightBooking` class to provide implementations for the abstract methods inherited from `Booking`.

### 4. Abstraction
The `Booking` class is declared as an abstract class and contains abstract methods such as `calculateTotalFare()` and `displayBooking()`.

## Other Java Concepts Practiced

- Classes and objects
- Constructors
- Getters
- `super()` keyword
- `@Override` annotation
- Abstract classes and methods
- `ArrayList`
- `HashMap`
- `Scanner`
- `switch` statements
- `while` loops
- Enhanced `for` loops
- Conditional statements
- Exception handling
- `Integer.parseInt()`
- `NumberFormatException`

## How It Works

### 1. View Flight Schedules
Displays all available flights with their IDs, routes, departure times, ticket prices, and remaining seats.

### 2. Book Flight Ticket
Allows the user to select a flight, enter the passenger name, and choose the number of seats. The system checks seat availability, calculates the total fare, and generates a booking ID.

### 3. Cancel Booking
Allows the user to cancel an existing booking using its booking ID. The cancelled seats are added back to the flight's available seats.

### 4. View My Bookings
Displays all current bookings, including booking ID, passenger name, flight route, departure time, number of seats, and total fare.

## Available Flights

| Flight ID | Route | Departure Time | Ticket Price |
|---|---|---|---|
| 1 | Karachi - Lahore | 09:00 AM | Rs. 12,000 |
| 2 | Karachi - Islamabad | 12:00 PM | Rs. 15,000 |
| 3 | Lahore - Dubai | 05:00 PM | Rs. 45,000 |

Each flight starts with 40 available seats.

## Menu Options

| Option | Function |
|---|---|
| 0 | Exit |
| 1 | View Flight Schedules |
| 2 | Book Flight Ticket |
| 3 | Cancel Booking |
| 4 | View My Bookings |

## Fare Calculation

Total Fare = Ticket Price × Number of Seats

**Example:**

- Ticket Price = Rs. 15,000
- Number of Seats = 2
- Total Fare = Rs. 30,000

## Data Structures Used

- **ArrayList:** Stores flight objects.
- **HashMap:** Stores bookings using booking IDs as keys.

## How to Run

1. Download or clone this repository.
2. Open the project folder in your code editor.
3. Make sure Java JDK is installed.
4. Open the terminal in the project folder.
5. Compile the program:

   ```bash
   javac Main.java
   ```

6. Run the program:

   ```bash
   java Main
   ```

## Data Storage

Flight schedules and booking records are stored in `ArrayList` and `HashMap`. All data is stored in memory and resets when the program restarts.

## Purpose

This project is designed to practice Java programming and all four major OOP concepts through a practical ticket booking system.

## Future Improvements

- Add passenger contact information
- Add flight search by route
- Add passenger details management
- Add payment processing
- Save bookings using file handling
- Connect the system to a database
- Add a graphical user interface

## Author

Fatima Aziz

GitHub: [fatimaaziz27](https://github.com/fatimaaziz27)
