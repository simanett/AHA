/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.service;

import com.aha.businesslogic.model.Booking;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Passenger;
import com.aha.businesslogic.model.Seat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author simonicsanett
 */
public interface BookingService extends Remote {

    /**
     * Add a new Booking object to the application state and save it to the XML
     *
     * @param booking The Booking object to add
     */
    boolean addBooking(Booking booking)throws RemoteException;

    /**
     * Set Booking approved status to 1.
     *
     * @param booking The booking to be set approved in database
     * @return void
     */
    void approveBooking(Booking booking)throws RemoteException;

    boolean deleteBookingByBookingreference(String bookingreference)throws RemoteException;

    List<Booking> getActiveBookingsByPassenger(Passenger inputpassenger)throws RemoteException;

    /**
     * Return all approved Booking objects
     *
     * @return All Bookings that are approved (booking.isApproved() == true)
     */
    List<Booking> getApprovedBookings()throws RemoteException;

    List<Seat> getBookedSeatsOfFlight(Flight flight)throws RemoteException;

    /**
     * Return the Booking object with the given booking number
     *
     * @param bookingReference String that identifies the Booking object
     * @return The Booking object if exists, null otherwise
     */
    Booking getBookingByBookingReference(String bookingReference)throws RemoteException;

    /**
     * Return all Booking objects
     *
     * @return All Bookings in the database
     */
    List<Booking> getBookings()throws RemoteException;

    /**
     * Return all pending Booking objects
     *
     * @return All Bookings that are pending (booking.isApproved() == false)
     */
    List<Booking> getPendingBookings()throws RemoteException;

    void updateSeat(Booking booking)throws RemoteException;
    
}
