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
    private Date departureFrom;
    private Date departureTo;

    public String getAirportCodeFrom() {
        return airportCodeFrom;
    }

    public String getAirportCodeTo() {
        return airportCodeTo;
    }

    public Date getDepartureFrom() {
        return departureFrom;
    }

    public Date getDepartureTo() {
        return departureTo;
    }

    public FlightSearchEvent(Object source, int id, String command, String airportCodeFrom, String airportCodeTo, Date departure) {
        this(source, id, command, airportCodeFrom, airportCodeTo, departure, departure);
    }

    public FlightSearchEvent(Object source, int id, String command, String airportCodeFrom, String airportCodeTo, Date departureFrom, Date departureTo) {
        super(source, id, command);

        this.airportCodeFrom = airportCodeFrom;
        this.airportCodeTo = airportCodeTo;
        this.departureFrom = departureFrom;
        this.departureTo = departureTo;
    }

}
