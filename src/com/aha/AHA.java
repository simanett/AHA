/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;

/*Hi*/
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.User;
import com.aha.data.FlightRepository;
import com.aha.data.UserRepository;
import com.aha.userinterface.ListFlightsForm;
import com.aha.userinterface.ApproveBookingForm;
import com.aha.userinterface.LoginForm;
import java.util.List;

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
        List<Flight> flights = repository.getFlights();
        
        UserRepository userRepo = new UserRepository();
        User user = userRepo.getUserById(101);
        
        /*
        SelectSeatForm selectSeatForm = new SelectSeatForm(flight);
        selectSeatForm.setVisible(true);
        */
        
        //Show passenger welcome screen with flight list
        
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        

//        

    }

}
