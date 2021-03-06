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
public class Seat {

    private int id;
    private int row;
    private String letter;
    private double multiplier;

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return row + letter;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Seat) {
            Seat otherSeat = (Seat)other;
            return getId() == otherSeat.getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getId();
    }
    
    
}
