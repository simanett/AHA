/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simonicsanett
 */
@XmlRootElement
public class Seat {

    private int row;
    private String letter;

//    private String seatId;
    private Booking booking;
//
//    @XmlElement
//    public void setSeatId() {
//        this.seatId = this.row + this.letter;
//    }

    @XmlElement
    public void setRow(int row) {
        this.row = row;
    }

    @XmlElement
    public void setLetter(String letter) {
        this.letter = letter;
    }

    @XmlTransient
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getRow() {
        return row;
    }

    public String getLetter() {
        return letter;
    }

//    public String getSeatId() {
//        return seatId;
//    }

    public Booking getBooking() {
        return booking;
    }

}
