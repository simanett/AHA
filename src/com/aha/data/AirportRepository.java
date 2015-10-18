/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.businesslogic.model.Airport;
import java.util.List;

/**
 *
 * @author simonicsanett
 */
public class AirportRepository {
    
    public Airport getAirportByCode(String code) {
        for(Airport airport : airports()) {
            if(airport.getCode().equals(code)) {
                return airport;
            }
        }
        return null;
    }
    
    public List<Airport> getAirports() {
        return airports();
    } 
    
    public void addAirport(Airport airport) {
        airports().add(airport);
        FileSystemManager.getInstance().saveState();
    }
    
    private List<Airport> airports() {
        return FileSystemManager.getInstance().getState().getAirports();
    }
}
