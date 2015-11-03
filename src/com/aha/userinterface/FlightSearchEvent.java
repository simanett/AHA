/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.userinterface;

import java.awt.event.ActionEvent;
import java.util.Date;

/**
 *
 * @author simonicsanett
 */
class FlightSearchEvent extends ActionEvent {

    private String airportCodeFrom;
    private String airportCodeTo;
    private Date departure;

    public String getAirportCodeFrom() {
        return airportCodeFrom;
    }

    public String getAirportCodeTo() {
        return airportCodeTo;
    }

    public Date getDeparture() {
        return departure;
    }

    public FlightSearchEvent(Object source, int id, String command, String airportCodeFrom, String airportCodeTo, Date departure) {
        super(source, id, command);
        
        this.airportCodeFrom = airportCodeFrom;
        this.airportCodeTo = airportCodeTo;
        this.departure = departure;
    }

}
