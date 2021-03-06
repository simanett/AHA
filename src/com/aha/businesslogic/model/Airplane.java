/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import java.util.List;

/**
 *
 * @author simonicsanett
 */
public class Airplane {

    private int maxDistance;
    //Airplane model is a unique property.
    private String model;
    private int id;
    private List<Seat> seats;

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Airplane{" + "maxDistance=" + maxDistance + ", model=" + model + ", id=" + id + ", seats=" + seats + '}';
    }
}
