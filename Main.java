









import java.util.*;

// Main class
public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Flight> flights = new ArrayList<>();
    static HashMap<String, Booking> bookings = new HashMap<>();

    static int bookingCounter = 1;

    public static void main(String[] args) {

        // Adding flights
        flights.add(new Flight(1, "Karachi - Lahore", "09:00 AM", 12000, 40));
        flights.add(new Flight(2, "Karachi - Islamabad", "12:00 PM", 15000, 40));
        flights.add(new Flight(3, "Lahore - Dubai", "05:00 PM", 45000, 40));

        while (true) {

            System.out.println("\n0. Exit");
            System.out.println("1. View Flight Schedules");
            System.out.println("2. Book Flight Ticket");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View My Bookings");

            System.out.print("Enter your choice: ");
            int choice = readInt();

            switch (choice) {

                case 0:
                    System.out.println("Exiting Airline Ticket Booking System...");
                    return;

                case 1:
                    viewFlights();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    viewBookings();
                    break;

                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }

    // Function to read integer input
    static int readInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // 1. View flight schedules
    static void viewFlights() {

        System.out.println("\n--- Available Flight Schedules ---");

        for (Flight f : flights) {
            f.displayFlight();
        }
    }

    // 2. Book flight ticket
    static void bookTicket() {

        viewFlights();

        System.out.print("\nEnter Flight ID: ");
        int flightId = readInt();

        Flight selectedFlight = null;

        for (Flight f : flights) {
            if (f.getId() == flightId) {
                selectedFlight = f;
                break;
            }
        }

        if (selectedFlight == null) {
            System.out.println("Invalid Flight ID!");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of seats: ");
        int seats = readInt();

        if (seats <= 0) {
            System.out.println("Invalid number of seats!");
            return;
        }

        if (seats > selectedFlight.getAvailableSeats()) {
            System.out.println("Only "
                    + selectedFlight.getAvailableSeats()
                    + " seats available!");
            return;
        }

        selectedFlight.bookSeats(seats);

        String bookingId = "F" + bookingCounter++;

        Booking booking = new FlightBooking(
                bookingId, name, selectedFlight, seats
        );

        bookings.put(bookingId, booking);

        System.out.println("\nFlight booking successful!");
        booking.displayBooking();
    }

    // 3. Cancel booking
    static void cancelBooking() {

        System.out.print("Enter Booking ID to cancel: ");
        String bookingId = sc.nextLine();

        Booking booking = bookings.get(bookingId);

        if (booking != null) {

            booking.getFlight().releaseSeats(booking.getSeats());

            bookings.remove(bookingId);

            System.out.println("Booking cancelled successfully!");

        } else {
            System.out.println("Booking not found!");
        }
    }

    // 4. View bookings
    static void viewBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available!");
            return;
        }

        System.out.println("\n--- Passenger Bookings ---");

        for (Booking b : bookings.values()) {
            b.displayBooking();
        }
    }
}


// Flight class
class Flight {

    // Encapsulation: Private attributes
    private int id;
    private String route;
    private String departureTime;
    private double ticketPrice;
    private int availableSeats;

    // Constructor
    Flight(int id, String route, String departureTime,
           double ticketPrice, int availableSeats) {

        this.id = id;
        this.route = route;
        this.departureTime = departureTime;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getRoute() {
        return route;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Method to book seats
    public void bookSeats(int seats) {
        availableSeats -= seats;
    }

    // Method to release seats
    public void releaseSeats(int seats) {
        availableSeats += seats;
    }

    // Display flight details
    public void displayFlight() {

        System.out.println(
                "ID: " + id
                + " | Route: " + route
                + " | Time: " + departureTime
                + " | Fare: Rs." + ticketPrice
                + " | Seats Left: " + availableSeats
        );
    }
}


// Abstract parent class
abstract class Booking {

    // Private attributes
    private String bookingId;
    private String passengerName;
    private Flight flight;
    private int seats;

    // Constructor
    Booking(String bookingId, String passengerName,
            Flight flight, int seats) {

        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flight = flight;
        this.seats = seats;
    }

    // Getters
    public String getBookingId() {
        return bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getSeats() {
        return seats;
    }

    // Abstract methods
    abstract double calculateTotalFare();

    abstract void displayBooking();
}


// Child class
class FlightBooking extends Booking {

    // Constructor
    FlightBooking(String bookingId, String passengerName,
                  Flight flight, int seats) {

        super(bookingId, passengerName, flight, seats);
    }

    // Method overriding (Polymorphism)
    @Override
    double calculateTotalFare() {

        return getFlight().getTicketPrice() * getSeats();
    }

    // Method overriding (Polymorphism)
    @Override
    void displayBooking() {

        System.out.println(
                "\nBooking ID: " + getBookingId()
                + " | Passenger: " + getPassengerName()
                + " | Route: " + getFlight().getRoute()
                + " | Time: " + getFlight().getDepartureTime()
                + " | Seats: " + getSeats()
                + " | Total Fare: Rs." + calculateTotalFare()
        );
    }
}

