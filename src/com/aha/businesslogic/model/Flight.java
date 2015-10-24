/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simonicsanett
 */
@XmlRootElement
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

    @XmlElement
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDeparture() {
        return departure;
    }
    
    @XmlElement
    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    @XmlElement
    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public List<Seat> getSeat() {
        return seat;
    }

    @XmlIDREF
    public void setSeat(List<Seat> seat) {
        this.seat = seat;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    @XmlIDREF
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
