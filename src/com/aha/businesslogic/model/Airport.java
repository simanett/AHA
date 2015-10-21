/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.businesslogic.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simonicsanett
 */
@XmlRootElement
public class Airport {
    
    private String code;
    private String city;

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    @XmlID
    @XmlElement
    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }
    
    
    
}
