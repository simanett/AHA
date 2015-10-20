/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;
/*Hi*/
import com.aha.businesslogic.model.Airport;
import com.aha.data.AirportRepository;

/**
 *
 * @author simonicsanett
 */
public class AHA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AirportRepository repo = new AirportRepository();
        Airport budapest = repo.getAirportByCode("BUD");
        
        if (budapest == null) {
            budapest = new Airport();
            budapest.setCity("Budapest");
            budapest.setCode("BUD");
        }

        repo.addAirport(budapest);

    }

}
