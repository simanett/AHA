/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

/**
 *
 * @author simonicsanett
 */
public class Airplane {
    
    private int maxDistance ;
    //Airplane model is a unique property.
    private String model;
    private String seat;

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public String getModel() {
        return model;
    }

    public String getSeat() {
        return seat;
    }
    
}
