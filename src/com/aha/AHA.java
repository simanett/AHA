/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;

import com.aha.businesslogic.model.Airport;
import com.aha.businesslogic.model.Flight;
import com.aha.data.AirportRepository;
import com.aha.data.FileSystemManager;
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
        AirportRepository repo = new AirportRepository();
        Airport budapest = repo.getAirportByCode("BUD");
        Airport dublin = repo.getAirportByCode("DUB");

        if (budapest == null) {
            budapest = new Airport();
            budapest.setCity("Budapest");
            budapest.setCode("BUD");
        }

        if (dublin == null) {
            dublin = new Airport();
            dublin.setCity("Dublin");
            dublin.setCode("DUB");
        }

        //repo.addAirport(budapest);
        List<Airport> airports = FileSystemManager.getInstance().getState().getAirports();
        airports.add(dublin);
        airports.add(budapest);

        Flight dubBud = new Flight();
        dubBud.setAirportFrom(budapest);
        dubBud.setAirportTo(dublin);
        dubBud.setDeparture(new Date());

        List<Flight> flights = FileSystemManager.getInstance().getState().getFlights();
        flights.add(dubBud);
        FileSystemManager.getInstance().saveState();
    }

}
