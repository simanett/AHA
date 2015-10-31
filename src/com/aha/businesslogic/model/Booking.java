/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simonicsanett
 */
@XmlRootElement
public class Booking {
    
    private String bookingNumber;
    //private Seat seat;
    private Passenger passenger;
    private boolean approved;
    private Date bookingDate;
    private Flight flight;
    private int row;
    private String letter;

    public Flight getFlight() {
        return flight;
    }

    @XmlIDREF
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    
//    @XmlTransient
//    public void setSeat(Seat seat) {
//        this.seat = seat;
//    }

    @XmlID
    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }
//
//    public Seat getSeat() {
//        return seat;
//    }
//    
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
