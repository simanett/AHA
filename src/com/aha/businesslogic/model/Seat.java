/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simonicsanett
 */
public class Seat {
    
    private int row;
    private String letter;
    
    private Booking booking;
    
    public void setRow(int row) {
        this.row = row;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getRow() {
        return row;
    }

    public String getLetter() {
        return letter;
    }

    public Booking getBooking() {
        return booking;
    }

    @XmlTransient
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    
}
