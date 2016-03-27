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
        return "Seat{" + "row=" + row + ", letter=" + letter + '}';
    }
}
