/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import java.util.Date;

/**
 *
 * @author simonicsanett
 */
public class Booking {

    private String bookingReference;
    private Passenger passenger;
    private boolean approved;
    private Flight flight;
    private Seat seat;
    private int price;

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    
    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingReference=" + bookingReference + ", passenger=" + passenger + ", approved=" + approved + ", flight=" + flight + ", seat=" + seat + ", price=" + price + '}';
    }

  



}
