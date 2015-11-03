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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
        Airport nantes = repo.getAirportByCode("NTE");

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

        if (nantes == null) {
            nantes = new Airport();
            nantes.setCity("Nantes");
            nantes.setCode("NTE");
            repo.addAirport(nantes);
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

        Airplane boeing2 = repo.getAirplaneByModel("Boeing2");
        if (boeing2 == null) {
            boeing2 = new Airplane();
            boeing2.setModel("Boeing2");

            List<String> rows = new ArrayList<>();

            // 20-row airplane
            for (int i = 0; i < 15; i++) {
                rows.add("ABCDEF");
            }
            boeing2.setRows(rows);
            repo.addAirplane(boeing2);
        }
    }

    public void generateFlights() {
        //Adding flights
        FlightRepository repoFlight = new FlightRepository();
        AirportRepository repoAirport = new AirportRepository();
        AirplaneRepository repoAirplane = new AirplaneRepository();

        for (int i = 1000; i < 1400; i++) {
            Flight flight = repoFlight.getFlightByFlightNumber(String.valueOf(i));
            if (flight == null) {
                Random random = new Random();

                List<Airport> airports = repoAirport.getAirports();
                int fromIndex = random.nextInt(airports.size());
                int toIndex = random.nextInt(airports.size());

                while (toIndex == fromIndex) {
                    toIndex = random.nextInt(airports.size());
                }

                Airport from = airports.get(fromIndex);
                Airport to = airports.get(toIndex);

                List<Airplane> airplanes = repoAirplane.getAirplanes();
                int airplaneIndex = random.nextInt(airplanes.size());

                Airplane plane = airplanes.get(airplaneIndex);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.DATE, random.nextInt(80));
                
                flight = FlightFactory.createFlight(from, to, plane, calendar.getTime(), 180, String.valueOf(i));
                flight.setPrice(50000 + random.nextInt(300) * 100);
                repoFlight.addFlight(flight);
            }

        }
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

        Flight nteBud1260 = repoFlight.getFlightByFlightNumber("1260");

        if (nteBud1260 == null) {
            Airport budapest = repoAirport.getAirportByCode("BUD");
            Airport nantes = repoAirport.getAirportByCode("NTE");
            Airplane boeing2 = repoAirplane.getAirplaneByModel("Boeing2");

            nteBud1260 = FlightFactory.createFlight(budapest, nantes, boeing2, new Date(), 180, "1260");
            nteBud1260.setPrice(45600);
            repoFlight.addFlight(nteBud1260);
        }

        Flight budNte1270 = repoFlight.getFlightByFlightNumber("1270");

        if (budNte1270 == null) {
            Airport budapest = repoAirport.getAirportByCode("BUD");
            Airport nantes = repoAirport.getAirportByCode("NTE");
            Airplane boeing2 = repoAirplane.getAirplaneByModel("Boeing2");

            budNte1270 = FlightFactory.createFlight(budapest, nantes, boeing2, new Date(), 180, "1270");
            budNte1270.setPrice(55500);
            repoFlight.addFlight(budNte1270);
        }

    }

    public void generateUsers() {
        //Adding users
        UserRepository userRepo = new UserRepository();

        Operator anett = (Operator) userRepo.getUserById(101);
        Administrator helga = (Administrator) userRepo.getUserById(102);
        Passenger lucy = (Passenger) userRepo.getUserById(103);
        Passenger tom = (Passenger) userRepo.getUserById(104);
        Passenger luke = (Passenger) userRepo.getUserById(105);
        Passenger mimi = (Passenger) userRepo.getUserById(106);
        Passenger bud = (Passenger) userRepo.getUserById(107);

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

        if (luke == null) {
            luke = new Passenger();
            luke.setId(105);
            luke.setName("Luke Skywalker");
            luke.setEmail("luke.skywalker@notaha.com");
            userRepo.addUser(luke);
        }

        if (mimi == null) {
            mimi = new Passenger();
            mimi.setId(106);
            mimi.setName("Mimi Rogers");
            mimi.setEmail("mimi.rogers@notaha.com");
            userRepo.addUser(mimi);
        }

        if (bud == null) {
            bud = new Passenger();
            bud.setId(107);
            bud.setName("Bud Spencer");
            bud.setEmail("bud.spencer@notaha.com");
            userRepo.addUser(bud);
        }
    }

    public void generate() {
        generateAirplanes();
        generateAirports();
        generateUsers();

        generateFlights();
    }

}
