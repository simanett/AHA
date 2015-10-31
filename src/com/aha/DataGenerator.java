/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;

import com.aha.businesslogic.FlightFactory;
import com.aha.businesslogic.model.Administrator;
import com.aha.businesslogic.model.Airplane;
import com.aha.businesslogic.model.Airport;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Operator;
import com.aha.businesslogic.model.Passenger;
import com.aha.data.AirplaneRepository;
import com.aha.data.AirportRepository;
import com.aha.data.FlightRepository;
import com.aha.data.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author simonicsanett
 */
public class DataGenerator {

    public void generateAirports() {
        //Adding airports
        AirportRepository repo = new AirportRepository();

        Airport budapest = repo.getAirportByCode("BUD");
        Airport dublin = repo.getAirportByCode("DUB");

        if (budapest == null) {
            budapest = new Airport();
            budapest.setCity("Budapest");
            budapest.setCode("BUD");
            repo.addAirport(budapest);
        }

        if (dublin == null) {
            dublin = new Airport();
            dublin.setCity("Dublin");
            dublin.setCode("DUB");
            repo.addAirport(dublin);
        }
    }

    public void generateAirplanes() {
        AirplaneRepository repo = new AirplaneRepository();

        Airplane boeing = repo.getAirplaneByModel("Boeing");
        if (boeing == null) {
            boeing = new Airplane();
            boeing.setModel("Boeing");

            List<String> rows = new ArrayList<>();

            // 20-row airplane
            for (int i = 0; i < 20; i++) {
                rows.add("ABCDEF");
            }
            boeing.setRows(rows);
            repo.addAirplane(boeing);
        }
    }

    public void generateFlights() {
        //Adding flights
        FlightRepository repoFlight = new FlightRepository();
        AirportRepository repoAirport = new AirportRepository();
        AirplaneRepository repoAirplane = new AirplaneRepository();

        Flight dubBud1252 = repoFlight.getFlightByFlightNumber("1252");

        if (dubBud1252 == null) {
            Airport budapest = repoAirport.getAirportByCode("BUD");
            Airport dublin = repoAirport.getAirportByCode("DUB");
            Airplane boeing = repoAirplane.getAirplaneByModel("Boeing");

            dubBud1252 = FlightFactory.createFlight(budapest, dublin, boeing, new Date(), 180, "1252");
            dubBud1252.setPrice(75600);
            repoFlight.addFlight(dubBud1252);
        }

        Flight dubBud1262 = repoFlight.getFlightByFlightNumber("1262");

        if (dubBud1262 == null) {
            Airport budapest = repoAirport.getAirportByCode("BUD");
            Airport dublin = repoAirport.getAirportByCode("DUB");
            Airplane boeing = repoAirplane.getAirplaneByModel("Boeing");

            dubBud1262 = FlightFactory.createFlight(dublin, budapest, boeing, new Date(), 200, "1262");
            dubBud1262.setPrice(86500);
            repoFlight.addFlight(dubBud1262);
        }

    }

    public void generateUsers() {
        //Adding users
        UserRepository userRepo = new UserRepository();

        Operator anett = (Operator) userRepo.getUserById(101);
        Administrator helga = (Administrator) userRepo.getUserById(102);
        Passenger lucy = (Passenger) userRepo.getUserById(103);
        Passenger tom = (Passenger) userRepo.getUserById(104);

        if (anett == null) {
            anett = new Operator();
            anett.setId(101);
            anett.setName("Anett");
            anett.setEmail("anett@aha.com");
            userRepo.addUser(anett);
        }

        if (helga == null) {
            helga = new Administrator();
            helga.setId(102);
            helga.setName("helga");
            helga.setEmail("helga@aha.com");
            userRepo.addUser(helga);
        }

        if (lucy == null) {
            lucy = new Passenger();
            lucy.setId(103);
            lucy.setName("Lucy Liu");
            lucy.setEmail("lucy.liu@notaha.com");
            userRepo.addUser(lucy);
        }
        
        if (tom == null) {
            tom = new Passenger();
            tom.setId(104);
            tom.setName("Tom Hanks");
            tom.setEmail("tom.hanks@notaha.com");
            userRepo.addUser(tom);
        }
    }

    public void generate() {
        generateAirplanes();
        generateAirports();
        generateUsers();

        generateFlights();
    }

}
