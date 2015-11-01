/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.businesslogic.model.Booking;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Repository class to handle airplane data
 *
 * @author simonicsanett
 */
public class BookingRepository {

    /**
     * Return the Booking object with the given booking number
     *
     * @param bookingNumber String that identifies the Booking object
     * @return The Booking object if exists, null otherwise
     */
    public Booking getBookingByBookingNumber(String bookingNumber) {
        for (Booking booking : bookings()) {
            if (booking.getBookingNumber().equals(bookingNumber)) {
                return booking;
            }
        }
        return null;
    }

    /**
     * Return all Booking objects
     *
     * @return All Bookings in the application state
     */
    public List<Booking> getBookings() {
        return bookings();
    }

    /**
     * Return all approved Booking objects
     *
     * @return All Bookings that are approved (booking.isApproved() == true)
     */
    public List<Booking> getApprovedBookings() {

        List<Booking> approvedBookings = new ArrayList<>();
        for (Booking booking : bookings()) {
            if (booking.isApproved()) {
                approvedBookings.add(booking);
            }
        }
        return approvedBookings;
    }

    /**
     * Return all pending Booking objects
     *
     * @return All Bookings that are pending (booking.isApproved() == false)
     */
    public List<Booking> getPendingBookings() {

        List<Booking> pendingBookings = new ArrayList<>();
        for (Booking booking : bookings()) {
            if (booking.isApproved() == false) {
                pendingBookings.add(booking);
            }
        }
        return pendingBookings;
    }

    /**
     * Add a new Booking object to the application state and save it to the XML
     *
     * @param booking The Booking object to add
     */
    public void addBooking(Booking booking) {
        bookings().add(booking);
        FileSystemManager.getInstance().saveState();
    }

    /**
     * Force saving application state to XML
     */
    public void save() {
        FileSystemManager.getInstance().saveState();
    }

    /**
     * Helper method to get all Booking objects from application state
     *
     * @return List of Booking objects
     */
    private List<Booking> bookings() {
        return FileSystemManager.getInstance().getState().getBooking();
    }
}
