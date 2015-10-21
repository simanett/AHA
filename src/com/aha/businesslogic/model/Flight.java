/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlIDREF;

/**
 *
 * @author simonicsanett
 */
public class Flight {
    
    private int flightNumber;
    private Date departure;
    private int flightDuration;
    private List<Seat> seat;
    private Airplane airplane;
    private Airport airportTo;
    private Airport airportFrom;

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public List<Seat> getSeat() {
        return seat;
    }

    public void setSeat(List<Seat> seat) {
        this.seat = seat;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airport getAirportTo() {
        return airportTo;
    }

    @XmlIDREF
    public void setAirportTo(Airport airportTo) {
        this.airportTo = airportTo;
    }

    public Airport getAirportFrom() {
        return airportFrom;
    }

    @XmlIDREF
    public void setAirportFrom(Airport airportFrom) {
        this.airportFrom = airportFrom;
    }
    
}
