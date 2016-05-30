/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.userinterface;

import com.aha.Client;
import com.aha.businesslogic.model.Airport;
import com.aha.businesslogic.model.Booking;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Passenger;
import com.aha.service.AirportService;
import com.aha.service.BookingService;
import com.aha.service.FlightService;
import com.aha.service.PassengerService;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author simonicsanett
 */
public class PassengerForm extends javax.swing.JFrame {

    private Passenger passenger;

    private final PassengerService passengerService = Client.passengerService;
    private final AirportService airportService = Client.airportService;
    private final FlightService flightService = Client.flightService;
    private final BookingService bookingService = Client.bookingService;

    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy kk:mm");

    /**
     * Creates new form PassengerForm
     */
    public PassengerForm(int selectedIndex) {
        try {
            initComponents();
            jTabbedPane1.setSelectedIndex(selectedIndex);
            List<Airport> airports = airportService.getAirports();
            searchFlightsPanel.setAirports(airports);
        } catch (RemoteException ex) {
            Logger.getLogger(PassengerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPassenger(Passenger newPassenger) {
        passenger = newPassenger;

        refresh();
    }

    private void refresh() {

        String name = passenger.getName();
        String email = passenger.getEmail();

        nameField.setText(name);
        emailField.setText(email);
        if (passenger.isVip()) {
            name = name + " - VIP MEMBER";
        }
        userLabel.setText(name);

        updateBookingTable();
    }

    private void updateBookingTable() {
        try {
            List<Booking> activeBookings = bookingService.getPendingBookingsByPassenger(passenger);

            DefaultTableModel activeBookingModel = (DefaultTableModel) bookingTable.getModel();
            activeBookingModel.setRowCount(0);
            for (Booking booking : activeBookings) {
                activeBookingModel.addRow(new Object[]{
                    booking.getBookingReference(),
                    booking.getFlight().getFlightNumber(),
                    booking.getFlight().getAirportFrom(),
                    booking.getFlight().getAirportTo(),
                    DATE_FORMAT.format(booking.getFlight().getDeparture()),
                    flightArrivalToString(booking.getFlight()),
                    booking.getSeat()
                });
            }

            List<Booking> approvedBookings = bookingService.getApprovedBookingsByPassenger(passenger);

            DefaultTableModel approvedBookingModel = (DefaultTableModel) bookingTable1.getModel();
            approvedBookingModel.setRowCount(0);
            for (Booking booking : approvedBookings) {
                approvedBookingModel.addRow(new Object[]{
                    booking.getBookingReference(),
                    booking.getFlight().getFlightNumber(),
                    booking.getFlight().getAirportFrom(),
                    booking.getFlight().getAirportTo(),
                    DATE_FORMAT.format(booking.getFlight().getDeparture()),
                    flightArrivalToString(booking.getFlight()),
                    booking.getSeat()
                });
            }

        } catch (RemoteException ex) {
            Logger.getLogger(PassengerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listFlights(String airportCodeFrom, String airportCodeTo, Date departureFrom, Date departureTo) {
        try {
            List<Flight> flights = flightService.getFilteredFlights(airportCodeFrom, airportCodeTo, departureFrom, departureTo);

            DefaultTableModel listFlightModel = (DefaultTableModel) jTable1.getModel();
            listFlightModel.setRowCount(0);

            for (Flight flight : flights) {
                listFlightModel.addRow(new Object[]{
                    flight.getId(),
                    //Flight number
                    flight.getFlightNumber(),
                    //From
                    flight.getAirportFrom().getCity(),
                    //Departure
                    DATE_FORMAT.format(flight.getDeparture()),
                    //To
                    flight.getAirportTo().getCity(),
                    //Arrival
                    flightArrivalToString(flight),
                    //Price
                    flight.getBasicPrice(), //Book flight
                });
            }
        } catch (RemoteException ex) {
            Logger.getLogger(PassengerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String flightArrivalToString(Flight flight) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(flight.getDeparture());
        cal.add(Calendar.MINUTE, flight.getFlightDuration());
        String arrival = DATE_FORMAT.format(cal.getTime());
        return arrival;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchFlightsPanel = new com.aha.userinterface.SearchFlightsPanel();
        bookflightButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookingTable = new javax.swing.JTable();
        DeleteButton = new javax.swing.JButton();
        seatChangeButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookingTable1 = new javax.swing.JTable();
        jlbl_pendingBookings = new javax.swing.JLabel();
        jlbl_approvedBookings = new javax.swing.JLabel();
        personalDetailsPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        savePersonalDetailsButton = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AHA Bernot Helga, Simonics Anett - Passenger manage bookings");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Flight number", "From", "Departure", "To", "Arrival", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("Highlight row to select flight");
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        searchFlightsPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFlightsPanelActionPerformed(evt);
            }
        });

        bookflightButton.setText("Book flight");
        bookflightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookflightButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchFlightsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bookflightButton)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchFlightsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(bookflightButton))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(109, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)))
        );

        jTabbedPane1.addTab("Book Flights", jPanel1);

        bookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Booking Reference", "Flight Number", "From", "To", "Departure", "Arrival", "Seat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(bookingTable);

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        seatChangeButton.setText("Change booking");
        seatChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatChangeButtonActionPerformed(evt);
            }
        });

        bookingTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Booking Reference", "Flight Number", "From", "To", "Departure", "Arrival", "Seat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(bookingTable1);

        jlbl_pendingBookings.setText("Pending bookings");

        jlbl_approvedBookings.setText("Approved bookings");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seatChangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbl_pendingBookings)
                            .addComponent(jlbl_approvedBookings))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jlbl_pendingBookings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seatChangeButton)
                    .addComponent(DeleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbl_approvedBookings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Manage Bookings", jPanel2);

        nameLabel.setText("Name:");

        emailLabel.setText("Email:");

        savePersonalDetailsButton.setText("Save");
        savePersonalDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalDetailsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout personalDetailsPanelLayout = new javax.swing.GroupLayout(personalDetailsPanel);
        personalDetailsPanel.setLayout(personalDetailsPanelLayout);
        personalDetailsPanelLayout.setHorizontalGroup(
            personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(savePersonalDetailsButton)
                    .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                        .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailLabel)
                            .addComponent(nameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(578, Short.MAX_VALUE))
        );
        personalDetailsPanelLayout.setVerticalGroup(
            personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(savePersonalDetailsButton)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Edit Personal Details", personalDetailsPanel);

        userLabel.setText("jLabel1");

        logoutButton.setText("Logout");
        logoutButton.setToolTipText("");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(userLabel)
                        .addGap(222, 222, 222)
                        .addComponent(logoutButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(userLabel))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savePersonalDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePersonalDetailsButtonActionPerformed

        try {
            String name = nameField.getText();
            String email = emailField.getText();

            Passenger tempPassenger = new Passenger();
            tempPassenger.setName(name);
            tempPassenger.setEmail(email);
            tempPassenger.setId(passenger.getId());

            boolean result = passengerService.updatePassenger(tempPassenger);

            if (result) {
                passenger = tempPassenger;
            }

            refresh();
        } catch (RemoteException ex) {
            Logger.getLogger(PassengerForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_savePersonalDetailsButtonActionPerformed

    private void searchFlightsPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFlightsPanelActionPerformed
        FlightSearchEvent event = (FlightSearchEvent) evt;
        listFlights(event.getAirportCodeFrom(), event.getAirportCodeTo(), event.getDepartureFrom(), event.getDepartureTo());
    }//GEN-LAST:event_searchFlightsPanelActionPerformed

    private void bookflightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookflightButtonActionPerformed
        DefaultTableModel listFlightModel = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            try {
                int flightId = (int) listFlightModel.getValueAt(row, 0);
                Flight selectedFlight = flightService.getFlightById(flightId);

                SelectSeatForm selectSeatForm = new SelectSeatForm(selectedFlight, passenger, null, 1);
                selectSeatForm.setVisible(true);
                this.dispose();
            } catch (RemoteException ex) {
                Logger.getLogger(PassengerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose a flight.");
        }
    }//GEN-LAST:event_bookflightButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        DefaultTableModel bookedFlightModel = (DefaultTableModel) bookingTable.getModel();
        //boolean checkedExists = false;
        int row = bookingTable.getSelectedRow();
        if (row >= 0) {
            try {
                String bookingNumber = (String) bookedFlightModel.getValueAt(row, 0);
                int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete? Booking: " + bookingNumber,
                        "Deleting booking", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (dialogResult == JOptionPane.OK_OPTION) {
                    boolean result = bookingService.deleteBookingByBookingreference(bookingNumber);
                    updateBookingTable();
                }
            } catch (RemoteException ex) {
                Logger.getLogger(PassengerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose a booking to delete.");
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void seatChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatChangeButtonActionPerformed
        DefaultTableModel bookedFlightModel = (DefaultTableModel) bookingTable.getModel();
        int row = bookingTable.getSelectedRow();
        if (row >= 0) {
            try {
                String bookingNumber = (String) bookedFlightModel.getValueAt(row, 0);
                Booking booking = bookingService.getBookingByBookingReference(bookingNumber);
                Flight flight = flightService.getFlightById(booking.getFlight().getId());

                SelectSeatForm changeSeat = new SelectSeatForm(flight, passenger, booking, 1);
                changeSeat.setVisible(true);

                changeSeat.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        updateBookingTable();
                    }
                });
                this.dispose();
            } catch (RemoteException ex) {
                Logger.getLogger(PassengerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_seatChangeButtonActionPerformed
        else {
            JOptionPane.showMessageDialog(null, "Please choose a booking to modify.");
        }
    }
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PassengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PassengerForm(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton bookflightButton;
    private javax.swing.JTable bookingTable;
    private javax.swing.JTable bookingTable1;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlbl_approvedBookings;
    private javax.swing.JLabel jlbl_pendingBookings;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel personalDetailsPanel;
    private javax.swing.JButton savePersonalDetailsButton;
    private com.aha.userinterface.SearchFlightsPanel searchFlightsPanel;
    private javax.swing.JButton seatChangeButton;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables

}
