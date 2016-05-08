/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.userinterface;

import com.aha.Client;
import com.aha.businesslogic.model.Booking;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Passenger;
import com.aha.businesslogic.model.Seat;
import com.aha.service.BookingService;
import com.aha.service.PassengerService;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author simonicsanett
 */
public class SelectSeatForm extends javax.swing.JFrame {


    
    private final PassengerService passengerService = Client.passengerService;
    private final BookingService bookingService = Client.bookingService;
    
    private Flight flight;
    private Seat selectedSeat;
    private Passenger passenger;
    private Booking originalBooking;

    /**
     * Form to
     *
     * @param flight
     * @param user
     */
    public SelectSeatForm(Flight flight, Passenger passenger) {
        this(flight, passenger, null);
    }
    
    public SelectSeatForm(Flight flight, Passenger passenger, Booking booking) {
        this.flight = flight;
        this.passenger = passenger;
        this.originalBooking = booking;
        initComponents();
        flightNumberLabel.setText(String.valueOf(flight.getFlightNumber()));
        jLabel3.setText(flight.getAirportFrom().getCity());
        jLabel4.setText(flight.getAirportTo().getCity());
        String date = new SimpleDateFormat("dd/MM/yyyy kk:mm").format(flight.getDeparture());
        jLabel5.setText(date);
        drawSeatRadioButtons();
        this.pack();
    }
    
    private void drawSeatRadioButtons() {
        try {
            List<Seat> bookedSeats = bookingService.getBookedSeatsOfFlight(flight);
            List<Seat> seats = flight.getAirplane().getSeats();
            
            seatsPanel.setLayout(new GridLayout(0, 7, 0, 0));
            
            // Empty label - top left
            seatsPanel.add(new JLabel());
            
            // Set title
            for (char letter = 'A'; letter <= 'F'; letter++) {
                JLabel label = new JLabel(String.valueOf(letter));
                label.setHorizontalAlignment(JLabel.CENTER);
                seatsPanel.add(label);
            }
            
            for (final Seat seat : seats) {
                if (seat.getLetter().equals("A")) {
                    JLabel label = new JLabel(String.valueOf(seat.getRow()));
                    seatsPanel.add(label);
                }
                
                JRadioButton seatButton = new JRadioButton();
                
                ActionListener seatButtonListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectedSeat = seat;
                        selectSeatLabel.setText(seat.getRow() + seat.getLetter());
                        
                        int price = (int)(flight.getBasicPrice() * seat.getMultiplier());
                        priceLabel.setText(String.valueOf(price) + "Ft");
                    }
                };
                seatButton.addActionListener(seatButtonListener);
                
                // Only allow booking there is no existing booking on seat
                if(bookedSeats.contains(seat)) {
                    seatButton.setEnabled(false);
                }
                
                seatButtonGroup.add(seatButton);
                seatsPanel.add(seatButton);
                
                if(originalBooking != null && seat.equals(originalBooking.getSeat())) {
                    seatButton.setEnabled(true);
                    seatButton.doClick();
                }
                
            }
        } catch (RemoteException ex) {
            Logger.getLogger(SelectSeatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private String generateBookingReference() {
        SecureRandom random = new SecureRandom();
        
        return new BigInteger(130, random).toString(32);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seatButtonGroup = new javax.swing.ButtonGroup();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        seatsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        flightNumberLabel = new javax.swing.JLabel();
        javax.swing.JLabel dateLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fromLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        selectSeatLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AHA Bernot Helga, Simonics Anett");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("Flight details:");

        javax.swing.GroupLayout seatsPanelLayout = new javax.swing.GroupLayout(seatsPanel);
        seatsPanel.setLayout(seatsPanelLayout);
        seatsPanelLayout.setHorizontalGroup(
            seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );
        seatsPanelLayout.setVerticalGroup(
            seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jPanel1.setLayout(new java.awt.GridLayout(6, 2, 0, 10));

        jLabel1.setText("Flight number:");
        jPanel1.add(jLabel1);

        flightNumberLabel.setText("jLabel1");
        jPanel1.add(flightNumberLabel);

        dateLabel.setText("Departure: ");
        jPanel1.add(dateLabel);

        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5);

        fromLabel.setText("From: ");
        jPanel1.add(fromLabel);

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);

        toLabel.setText("To: ");
        jPanel1.add(toLabel);

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);

        jLabel6.setText("Selected Seat: ");
        jPanel1.add(jLabel6);

        selectSeatLabel.setText("No seat selected");
        selectSeatLabel.setName(""); // NOI18N
        jPanel1.add(selectSeatLabel);

        jLabel7.setText("Price:");
        jPanel1.add(jLabel7);

        priceLabel.setText("No seat selected");
        jPanel1.add(priceLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seatsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addContainerGap(126, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(seatsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        
        if (selectedSeat != null) {
            Booking newBooking = new Booking();
            
            if (originalBooking != null) {
                newBooking.setBookingReference(originalBooking.getBookingReference());
            } else {
                String reference = flight.getFlightNumber() + generateBookingReference();
                
                newBooking.setBookingReference(reference.substring(0, 20));
                
            }
            newBooking.setSeat(selectedSeat);
            newBooking.setFlight(flight);
            newBooking.setPassenger(passenger);
            
            if (originalBooking != null) {
                try {
                    bookingService.updateSeat(newBooking);
                } catch (RemoteException ex) {
                    Logger.getLogger(SelectSeatForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    bookingService.addBooking(newBooking);
                } catch (RemoteException ex) {
                    Logger.getLogger(SelectSeatForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a seat.");
        }

    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel flightNumberLabel;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.ButtonGroup seatButtonGroup;
    private javax.swing.JPanel seatsPanel;
    private javax.swing.JLabel selectSeatLabel;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables

}
