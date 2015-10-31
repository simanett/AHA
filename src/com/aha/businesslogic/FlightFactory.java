/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic;

import com.aha.businesslogic.model.Airplane;
import com.aha.businesslogic.model.Airport;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Seat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author simonicsanett
 */
public class FlightFactory {

    public static Flight createFlight(Airport from, Airport to, Airplane plane, Date departure, int duration, String flightNumber) {
        Flight flight = new Flight();
        flight.setAirportFrom(from);
        flight.setAirportTo(to);
        flight.setDeparture(departure);
        flight.setFlightDuration(duration);
        
        List<Seat> seats = new ArrayList<>();

        for (int i = 0; i < plane.getRows().size(); i++) {
            String row = plane.getRows().get(i);

            for (char letter : row.toCharArray()) {
                Seat seat = new Seat();
                seat.setRow(i + 1);
                seat.setLetter(String.valueOf(letter));
                seats.add(seat);
            }
        }

        flight.setFlightNumber(flightNumber);
        flight.setSeats(seats);
        
        return flight;

    }
}
