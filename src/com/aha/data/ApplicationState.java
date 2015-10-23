/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.businesslogic.model.Airplane;
import com.aha.businesslogic.model.Airport;
import com.aha.businesslogic.model.Booking;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simonicsanett
 */
@XmlRootElement
public class ApplicationState {
    
    @XmlElement
    private List<Airplane> airplanes;
    
    @XmlElement
    private List<Airport> airports;
    
    @XmlElement
    private List<Booking> bookings;
    
    @XmlElement
    private List<Flight> flights;
    
    @XmlElement
    private List<User> users;

    public ApplicationState() {
        airplanes = new ArrayList<>();
        airports = new ArrayList<>();
        bookings = new ArrayList<>();
        flights = new ArrayList<>();
        users = new ArrayList<>();
    }
    
    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
    
    public List<Flight> getFlights() {
        return flights;
    }

    public List<Booking> getBooking() {
        return bookings; 
    }

    public List<User> getUsers() {
        return users;
    }
}
