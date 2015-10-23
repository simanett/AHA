/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.businesslogic.model.Airplane;
import java.util.List;

/**
 *
 * @author HB
 */
public class AirplaneRepository {
    
    public Airplane getAirplaneByModel(String model){
        for(Airplane airplane : airplanes()) {
            if(airplane.getModel().equals(model)) {
                return airplane;
            }
        }
        return null;
    }
    
    public List<Airplane> getAirplanes(){
        return airplanes();
    }
    
    public void addAirplane(Airplane airplane){
        airplanes().add(airplane);
        FileSystemManager.getInstance().saveState();
    }
    
    private List<Airplane> airplanes(){
        return FileSystemManager.getInstance().getState().getAirplanes();
    }
    
}
