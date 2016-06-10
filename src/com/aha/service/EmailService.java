/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.service;

import com.aha.businesslogic.model.Booking;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author simonicsanett
 */
public interface EmailService extends Remote {

    void sendConfirmation(Booking booking) throws RemoteException;
}
