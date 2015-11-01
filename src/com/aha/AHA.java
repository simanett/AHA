/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha;

import com.aha.userinterface.LoginForm;

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
        
        // Show login form
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        
    }
}
