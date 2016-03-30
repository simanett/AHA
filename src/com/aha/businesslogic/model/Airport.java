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
public class Airport {

    private String code;
    private String city;

    public void setCode(String code) {
        this.code = code;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return city + " (" + code + ")";
    }

}
