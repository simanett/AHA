/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;

/*Hi*/
import com.aha.businesslogic.model.Flight;
import com.aha.data.FlightRepository;
import com.aha.userinterface.ApproveBookingForm;
import com.aha.userinterface.SelectSeatForm;

/**
 *
 * @author simonicsanett
 */
public class AHA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataGenerator generator = new DataGenerator();
        generator.generate();
        
        FlightRepository repository = new FlightRepository();
        Flight flight = repository.getFlightByFlightNumber("1252");
        
        SelectSeatForm selectSeatForm = new SelectSeatForm(flight);
        selectSeatForm.setVisible(true);
        
        ApproveBookingForm approveForm = new ApproveBookingForm();
        approveForm.setVisible(true);
    }

}
