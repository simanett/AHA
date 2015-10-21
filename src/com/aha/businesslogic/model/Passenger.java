/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import java.util.List;

/**
 *
 * @author bernothelga
 */
public class Passenger {
    private int id;
    private String name;
    private String email;
    private List<Booking> booking;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Booking> getBooking(){
        return booking;
    }
    
    public void setBooking(List<Booking> booking){
        this.booking = booking;
    }
}
