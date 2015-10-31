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
 * @author simonicsanett
 */
public class BookingRepository {

    public Booking getBookingByBookingNumber(String bookingNumber) {
        for (Booking booking : bookings()) {
            if (booking.getBookingNumber().equals(bookingNumber)) {
                return booking;
            }
        }
        return null;
    }

    public List<Booking> getBookings() {
        return bookings();
    }

    public List<Booking> getApprovedBookings() {

        List<Booking> approvedBookings = new ArrayList<>();
        for (Booking booking : bookings()) {
            if (booking.isApproved()) {
                approvedBookings.add(booking);
            }
        }
        return approvedBookings;
    }

    public List<Booking> getPendingBookings() {

        List<Booking> pendingBookings = new ArrayList<>();
        for (Booking booking : bookings()) {
            if (booking.isApproved() == false) {
                pendingBookings.add(booking);
            }
        }
        return pendingBookings;
    }

    public void addBooking(Booking booking) {
        bookings().add(booking);
        FileSystemManager.getInstance().saveState();
    }

    public void save() {
        FileSystemManager.getInstance().saveState();
    }

    private List<Booking> bookings() {
        return FileSystemManager.getInstance().getState().getBooking();
    }
}
