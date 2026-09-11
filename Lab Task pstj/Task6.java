import java.util.*;

class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

// Vehicle base class
abstract class Vehicle {
    abstract int calculateFare(int distance);
}

// Bike
class Bike extends Vehicle {
    int calculateFare(int distance) {
        return distance * 5;
    }
}

// Auto
class Auto extends Vehicle {
    int calculateFare(int distance) {
        return distance * 12;
    }
}

// Cab
class Cab extends Vehicle {
    int calculateFare(int distance) {
        return distance * 12;
    }
}

// Driver class
class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

// Rider class
class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

// Trip class
class Trip {
    Driver driver;
    Rider rider;
    Vehicle vehicle;
    int distance;

    Trip(Driver driver, Rider rider, Vehicle vehicle, int distance)
            throws InvalidBookingException {

        if (distance <= 0) {
            throw new InvalidBookingException("Invalid distance");
        }

        if (driver == null || rider == null || vehicle == null) {
            throw new InvalidBookingException("Invalid booking");
        }

        this.driver = driver;
        this.rider = rider;
        this.vehicle = vehicle;
        this.distance = distance;
    }

    int getFare() {
        return vehicle.calculateFare(distance);
    }
}

public class Task6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Driver driver = new Driver("Driver1");
        Rider rider = new Rider("Rider1");

        for (int i = 0; i < n; i++) {

            String rideType = sc.next();
            int distance = sc.nextInt();

            Vehicle vehicle = null;

            if (rideType.equals("Bike")) {
                vehicle = new Bike();
            }
            else if (rideType.equals("Auto")) {
                vehicle = new Auto();
            }
            else if (rideType.equals("Cab")) {
                vehicle = new Cab();
            }
            else {
                System.out.println("Invalid booking");
                continue;
            }

            try {
                Trip trip = new Trip(
                        driver,
                        rider,
                        vehicle,
                        distance
                );

                System.out.println(trip.getFare());

            }
            catch (InvalidBookingException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}