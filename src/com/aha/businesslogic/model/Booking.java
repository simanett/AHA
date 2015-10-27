/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simonicsanett
 */
@XmlRootElement
public class Booking {
    
    private String bookingNumber;
    private Seat seat;
    private Passenger passenger;
    
    @XmlTransient
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @XmlID
    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Seat getSeat() {
        return seat;
    }
    
    public String getBookingNumber() {
        return bookingNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
