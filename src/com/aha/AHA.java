/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;

import com.aha.businesslogic.model.Booking;
import com.aha.businesslogic.model.Employee;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Passenger;
import com.aha.data.BookingRepository;
import com.aha.data.EmployeeRepository;
import com.aha.data.FlightRepository;
import com.aha.data.PassengerRepository;
import com.aha.userinterface.LoginForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simonicsanett
 */
public class AHA {

    public static Connection connection;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                System.out.println("Invalid number of arguments, program has to be started with following arguments:");
                System.out.println("[url] [user] [password]");
                System.exit(1);
            }
            String dbUrl = args[0];
            String dbUserName = args[1];
            String dbPassWord = args[2];

            connection = connect(dbUrl, dbUserName, dbPassWord);
            /* Employee repository test*/
//            EmployeeRepository employeeRepository = new EmployeeRepository();
//            Employee employee = employeeRepository.getEmployeeById(1);
//            System.out.println("Employee 1:");
//            System.out.println(employee);
//            List<Employee> employees = employeeRepository.getEmployees();
//            System.out.println("getEmployees:");
//            for (Employee employeeitem : employees) {
//                System.out.println(employeeitem);
//            }
            /* END - Employee repository test*/

            /* Booking repository test */
//            BookingRepository bookingRepository = new BookingRepository();
//            String bookingReference = "BUDDUB0025";
//            Booking b = new Booking();
//            b = bookingRepository.getBookingByBookingReference("12BA");
//            bookingRepository.approveBooking(b);
//            System.out.println(b);
//            System.out.println("Booking test:");
//            Booking booking = bookingRepository.getBookingByBookingReference(bookingReference);
//            System.out.println(booking);
//            List<Booking> bookings = bookingRepository.getBookings();
//            System.out.println("getBookings:");
//            for (Booking bookingitem : bookings) {
//                System.out.println(bookingitem);
//            }
//            System.out.println("");
//            List<Booking> pendingBookings = bookingRepository.getPendingBookings();
//            System.out.println("pendingBookings:");
//            for (Booking bookingitem : pendingBookings) {
//                System.out.println(bookingitem);
//            }
//            System.out.println("");
//            List<Booking> approvedBookings = bookingRepository.getApprovedBookings();
//            System.out.println("approvedBookings:");
//            for (Booking bookingitem : approvedBookings) {
//                System.out.println(bookingitem);
//            }
            /* END - Booking repository test */
            /* Passenger repository test*/
            PassengerRepository passengerRepo = new PassengerRepository();
            List<Passenger> passngers = passengerRepo.getPassengers();
            System.out.println("Passengers:");
            System.out.println(passngers);
            Passenger han = passengerRepo.getPassengerById(2);
            System.out.println("HAN by id?");
            System.out.println(han);
            Passenger hanAgain = passengerRepo.getPassengerByEmail("solo@han.com");
            System.out.println("Han by email?");
            System.out.println(hanAgain);
            Passenger hanByName = passengerRepo.getPassengerByName("Mimi Rogers");
            System.out.println("Mimi by name?");
            System.out.println(hanByName);
//        int maxPassId = passengerRepo.getMaxPassengerId();
//        System.out.println("Max passenger id is:");
//        System.out.println(maxPassId);
//        Passenger passenger = new Passenger();
//        passenger.setEmail("pass@aha.com");
//        passenger.setName("BrandNew Passenger");
//        passengerRepo.addPassenger(passenger);
            /* END - passenger repository test */
            /* airplane repository test */
//        AirplaneRepository repo = new AirplaneRepository();
//
//        Airplane boeing = repo.getAirplaneByModel("Boeing747");
//        System.out.println(boeing);
//
//        Airplane kamu = repo.getAirplaneByModel("Kamu");
//        System.out.println(kamu);
//
//        List<Airplane> planes = repo.getAirplanes();
//        System.out.println("Repulok");
//        for (Airplane plane : planes) {
//            System.out.println(plane);
//        }
//
//        AirportRepository portrepo = new AirportRepository();
//
//        Airport alma = portrepo.getAirportByCode("DUB");
//        System.out.println(alma);
//
//        Airport korte = portrepo.getAirportByCode("Kakimaki");
//        System.out.println(korte);
//
//        List<Airport> airports = portrepo.getAirports();
//        System.out.println("Repterek:");
//        for (Airport airport : airports) {
//            System.out.println(airport);
//        }
            /* END - airplane repository test */

            /* user repository test */
//        UserRepository userrepo = new UserRepository();
//
//        User geza = userrepo.getUserById(2);
//        System.out.println(geza);
//
//        User lama = userrepo.getUserByName("Yellow Pages");
//        System.out.println(lama);
//
//        List<User> users = userrepo.getUsers();
//        System.out.println("Userek:");
//        for (User user : users) {
//            System.out.println(user);
//        }
            /* END - user repository test */
            /* flight repository test */
//            FlightRepository flightrepo = new FlightRepository();
//
//            Flight jarat = flightrepo.getFlightByFlightNumber(1234);
//            System.out.println(jarat);
//            List<Flight> flights = flightrepo.getFlights();
//            System.out.println("Jaratok: ");
//            for (Flight flight : flights) {
//                System.out.println(flight);
//            }
            /* END - flight repository test */
            // Show login form
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AHA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static Connection connect(String url, String user, String password) {

        System.out.println("-------- Oracle JDBC Connection Testing ------");
        try {
            // Check if oracle driver is available
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return null;
        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection newConnection = null;
        try {
            newConnection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }

        if (newConnection != null) {
            System.out.println("Connection successfully created");
        } else {
            System.out.println("Failed to make connection!");
        }

        return newConnection;
    }
}
