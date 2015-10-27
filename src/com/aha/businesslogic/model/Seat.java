/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
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

    private Booking booking;

    @XmlElement
    public void setRow(int row) {
        this.row = row;
    }

    @XmlElement
    public void setLetter(String letter) {
        this.letter = letter;
    }

    @XmlIDREF
    public void setBooking(Booking booking) {
        this.booking = booking;
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

}
