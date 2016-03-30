/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author simonicsanett
 */
public class Flight {

    private String flightNumber;
    private Date departure;
    private int flightDuration;
    private Airplane airplane;
    private Airport airportTo;
    private Airport airportFrom;
    private int id;
    private int basicPrice;

    public int getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(int basicPrice) {
        this.basicPrice = basicPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
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


    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airport getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(Airport airportTo) {
        this.airportTo = airportTo;
    }

    public Airport getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(Airport airportFrom) {
        this.airportFrom = airportFrom;
    }

    @Override
    public String toString() {
        return "Flight{" + "flightNumber=" + flightNumber + ", departure=" + departure + ", flightDuration=" + flightDuration + ", airplane=" + airplane + ", airportTo=" + airportTo + ", airportFrom=" + airportFrom + ", id=" + id + '}';
    }

}
