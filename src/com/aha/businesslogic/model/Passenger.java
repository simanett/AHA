/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bernothelga
 */
public class Passenger extends User {
    
    private List<Booking> booking;

    public Passenger() {
        this.booking = new ArrayList<>();
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }
}
