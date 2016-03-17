/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simonicsanett
 */
@XmlRootElement
public class Airplane {

    private int maxDistance;
    //Airplane model is a unique property.
    private String model;
    private List<String> rows;
    
    private int id;

    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + "\t" + maxDistance + "\t" + model;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    @XmlID
    @XmlElement
    public void setModel(String model) {
        this.model = model;
    }

    /*
    
    ABCDEF
    ABCDEF
    ABCDEF
    ..
    ..
    ..
    ACDF
    
     */
    public void setRows(List<String> rows) {
        this.rows = rows;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public String getModel() {
        return model;
    }

    public List<String> getRows() {
        return rows;
    }

}
