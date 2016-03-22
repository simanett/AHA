/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simonicsanett
 */
@XmlRootElement
public class Seat {

    private int row;
    private String letter;

    @Override
    public String toString() {
        return "Seat{" + "row=" + row + ", letter=" + letter + '}';
    }
    
    @XmlElement
    public void setRow(int row) {
        this.row = row;
    }
    
    @XmlElement
    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getRow() {
        return row;
    }

    public String getLetter() {
        return letter;
    }

}
