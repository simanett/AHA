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
    
    private String flightNumber;
    private Date departure;
    private int flightDuration;
    private List<Seat> seats;
    private Airplane airplane;
    private Airport airportTo;
    private Airport airportFrom;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    @XmlID
    public void setFlightNumber(String flightNumber) {
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

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
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
