/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;

/*Hi*/
import com.aha.businesslogic.model.Administrator;
import com.aha.businesslogic.model.Airport;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Operator;
import com.aha.businesslogic.model.Passenger;
import com.aha.businesslogic.model.User;
import com.aha.data.AirportRepository;
import com.aha.data.FileSystemManager;
import com.aha.data.FlightRepository;
import com.aha.data.UserRepository;
import java.util.Date;
import java.util.List;

/**
 *
 * @author simonicsanett
 */
public class AHA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Adding airports
        
        AirportRepository repo = new AirportRepository();
        List<Airport> airports = repo.getAirports();

        Airport budapest = repo.getAirportByCode("BUD");
        Airport dublin = repo.getAirportByCode("DUB");

        if (budapest == null) {
            budapest = new Airport();
            budapest.setCity("Budapest");
            budapest.setCode("BUD");
            airports.add(budapest);
        }

        if (dublin == null) {
            dublin = new Airport();
            dublin.setCity("Dublin");
            dublin.setCode("DUB");
            airports.add(dublin);
        }

        //Adding flights
        
        FlightRepository repoFlight = new FlightRepository();
        List<Flight> flights = repoFlight.getFlights();
        
        Flight dubBud1252 = repoFlight.getFlightByFlightNumber(1252);
        
        if (dubBud1252 == null) {
            dubBud1252 = new Flight();
            dubBud1252.setFlightNumber(1252);
            dubBud1252.setAirportFrom(budapest);
            dubBud1252.setAirportTo(dublin);
            dubBud1252.setDeparture(new Date());
            flights.add(dubBud1252);
        }

        //Adding users
        
        UserRepository userRepo = new UserRepository();
        List<User> users = userRepo.getUsers();
        
        Operator anett = (Operator) userRepo.getUserById(101);
        Administrator helga = (Administrator) userRepo.getUserById(102);
        Passenger tomi = (Passenger) userRepo.getUserById(103);
        
        if (anett == null) {
            anett = new Operator();
            anett.setId(101);
            anett.setName("Anett");
            anett.setEmail("anett@aha.com");
            users.add(anett);
        }
        
        if (helga == null) {
            helga = new Administrator();
            helga.setId(102);
            helga.setName("helga");
            helga.setEmail("helga@aha.com");
            users.add(helga);
        }
        
        if (tomi == null) {
            tomi = new Passenger();
            tomi.setId(103);
            tomi.setName("Tomi");
            tomi.setEmail("tomi@notaha.com");
            users.add(tomi);
        }
        
        FileSystemManager.getInstance().saveState();
    }

}
