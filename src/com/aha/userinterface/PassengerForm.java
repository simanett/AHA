/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.userinterface;

import com.aha.businesslogic.model.Airport;
import com.aha.businesslogic.model.Booking;
import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Passenger;
import com.aha.data.AirportRepository;
import com.aha.data.BookingRepository;
import com.aha.data.FlightRepository;
import com.aha.data.PassengerRepository;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author simonicsanett
 */
public class PassengerForm extends javax.swing.JFrame {

    private Passenger passenger;

    private PassengerRepository passengerRepository = new PassengerRepository();
    private AirportRepository airportRepository = new AirportRepository();
    private FlightRepository flightRepository = new FlightRepository();
    private BookingRepository bookingRepository = new BookingRepository();

    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy kk:mm");

    /**
     * Creates new form PassengerForm
     */
    public PassengerForm() {
        initComponents();

        List<Airport> airports = airportRepository.getAirports();
        searchFlightsPanel.setAirports(airports);
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

        updateBookingTable();
    }

    private void updateBookingTable() {
        List<Booking> bookings = bookingRepository.getActiveBookingsByPassenger(passenger);

        DefaultTableModel bookingModel = (DefaultTableModel) bookingTable.getModel();
        bookingModel.setRowCount(0);
        for (Booking booking : bookings) {
            bookingModel.addRow(new Object[]{
            booking.getBookingReference(),
            booking.getFlight().getFlightNumber(),
            booking.getFlight().getAirportFrom(),
            booking.getFlight().getAirportTo(),
            DATE_FORMAT.format(booking.getFlight().getDeparture()),
            flightArrivalToString(booking.getFlight()),
            booking.getSeat()
            
            });
            
            
            
        }
    }

    private void listFlights(String airportCodeFrom, String airportCodeTo, Date departureFrom, Date departureTo) {
        List<Flight> flights = flightRepository.getFilteredFlights(airportCodeFrom, airportCodeTo, departureFrom, departureTo);

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
        personalDetailsPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        savePersonalDetailsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
                    .addComponent(searchFlightsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bookflightButton)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchFlightsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(bookflightButton))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(49, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Bookings", jPanel2);

        nameLabel.setText("Name:");

        emailLabel.setText("Email:");

        nameField.setSize(new java.awt.Dimension(80, 300));

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
                .addGap(27, 27, 27)
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                        .addComponent(emailLabel)
                        .addGap(18, 18, 18)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(savePersonalDetailsButton)))
                .addContainerGap(369, Short.MAX_VALUE))
        );
        personalDetailsPanelLayout.setVerticalGroup(
            personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(savePersonalDetailsButton))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Edit Personal Details", personalDetailsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savePersonalDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePersonalDetailsButtonActionPerformed

        String name = nameField.getText();
        String email = emailField.getText();

        Passenger tempPassenger = new Passenger();
        tempPassenger.setName(name);
        tempPassenger.setEmail(email);
        tempPassenger.setId(passenger.getId());

        boolean result = passengerRepository.updatePassenger(tempPassenger);

        if (result) {
            passenger = tempPassenger;
        }

        refresh();

    }//GEN-LAST:event_savePersonalDetailsButtonActionPerformed

    private void searchFlightsPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFlightsPanelActionPerformed
        FlightSearchEvent event = (FlightSearchEvent) evt;
        listFlights(event.getAirportCodeFrom(), event.getAirportCodeTo(), event.getDepartureFrom(), event.getDepartureTo());
    }//GEN-LAST:event_searchFlightsPanelActionPerformed

    private void bookflightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookflightButtonActionPerformed
        DefaultTableModel listFlightModel = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            int flightId = (int)listFlightModel.getValueAt(row, 0);
            Flight selectedFlight = flightRepository.getFlightById(flightId);
            
            SelectSeatForm selectSeatForm = new SelectSeatForm(selectedFlight, passenger);
            selectSeatForm.setVisible(true);
            this.dispose();
        } //Set error msg if no flight is selected
//        else {
//            bookFlightError.setText("Please choose a flight");
//            bookFlightError.setForeground(Color.red);
//        }
    }//GEN-LAST:event_bookflightButtonActionPerformed

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
                new PassengerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookflightButton;
    private javax.swing.JTable bookingTable;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel personalDetailsPanel;
    private javax.swing.JButton savePersonalDetailsButton;
    private com.aha.userinterface.SearchFlightsPanel searchFlightsPanel;
    // End of variables declaration//GEN-END:variables

}
