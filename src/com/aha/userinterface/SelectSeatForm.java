/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.userinterface;

import com.aha.businesslogic.model.Booking;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Passenger;
import com.aha.businesslogic.model.Seat;
import com.aha.businesslogic.model.User;
import com.aha.data.BookingRepository;
import com.aha.data.PassengerRepository;
import com.aha.data.UserRepository;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    //UserRepository userRepository = new UserRepository();
    PassengerRepository passengerRepository = new PassengerRepository();
    BookingRepository repository = new BookingRepository();

    private Flight flight;
    private Seat selectedSeat;
    private Passenger passenger;

    /**
     * Form to
     *
     * @param flight
     * @param user
     */
    public SelectSeatForm(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
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
                }
            };
            seatButton.addActionListener(seatButtonListener);

            // Only allow booking there is no existing booking on seat
            //seatButton.setEnabled(seat.getBooking() == null);
            seatButtonGroup.add(seatButton);
            seatsPanel.add(seatButton);
        }

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

        jPanel1.setLayout(new java.awt.GridLayout(5, 2, 0, 10));

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 56, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            Booking booking = new Booking();
            booking.setBookingReference(flight.getFlightNumber() + selectedSeat.getRow() + selectedSeat.getLetter());

            booking.setSeat(selectedSeat);
            booking.setFlight(flight);

            booking.setPassenger(passenger);

            repository.addBooking(booking);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.ButtonGroup seatButtonGroup;
    private javax.swing.JPanel seatsPanel;
    private javax.swing.JLabel selectSeatLabel;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables

}
