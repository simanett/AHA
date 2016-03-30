/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.userinterface;

import com.aha.businesslogic.model.Flight;
import com.aha.businesslogic.model.Passenger;
import com.aha.businesslogic.model.User;
import com.aha.data.FlightRepository;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HB
 */
public class ListFlightsForm extends javax.swing.JFrame {

    FlightRepository flightRepo = new FlightRepository();
    private final Passenger passenger;
    private Flight selectedFlight;
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy kk:mm");

    /**
     * Creates new form ListFlights
     *
     * @param user
     */
    public ListFlightsForm(Passenger passenger) {
        SearchFlightsPanel flightSearchPanel = new SearchFlightsPanel();
        flightSearchPanel.setLocation(0, 40);
        flightSearchPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlightSearchEvent event = (FlightSearchEvent) e;
                listFlights(event.getAirportCodeFrom(), event.getAirportCodeTo(), event.getDepartureFrom());
            }
        });
        add(flightSearchPanel);

        this.passenger = passenger;
        initComponents();
        jLbl_User.setText(passenger.getName());
        jLbl_UserType.setText("[" + passenger.getClass().getSimpleName() + "]");
        listFlights("", "", null);
        showSelectedFlightId();
        //Set jTable rows sortable
        jTable1.setAutoCreateRowSorter(true);

    }

    private String flightDepartureToString(Flight flight) {
        String departure = DATE_FORMAT.format(flight.getDeparture());
        return departure;
    }

    private String flightArrivalToString(Flight flight) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(flight.getDeparture());
        cal.add(Calendar.MINUTE, flight.getFlightDuration());
        String arrival = DATE_FORMAT.format(cal.getTime());
        return arrival;
    }

    private boolean flightMatchesFilter(Flight flight, String airportCodeFrom, String airportCodeTo, Date departure) {
        if (!airportCodeFrom.isEmpty() && !flight.getAirportFrom().getCode().equals(airportCodeFrom)) {
            // "From" Airport code is set in filter and flight doesn't match, return false
            return false;
        }

        if (!airportCodeTo.isEmpty() && !flight.getAirportTo().getCode().equals(airportCodeTo)) {
            // "To" Airport code is set in filter and flight doesn't match, return false
            return false;
        }

        if (departure != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String formattedFilterDeparture = dateFormat.format(departure);
            String formattedFlightDeparture = dateFormat.format(flight.getDeparture());
            if (!formattedFilterDeparture.equals(formattedFlightDeparture)) {
                return false;
            }
        }

        return true;
    }

    private void listFlights(String airportCodeFrom, String airportCodeTo, Date departure) {
        DefaultTableModel listFlightModel = (DefaultTableModel) jTable1.getModel();
        listFlightModel.setRowCount(0);
        selectedFlight = null;
        for (Flight flight : flightRepo.getFlights()) {
            if (flightMatchesFilter(flight, airportCodeFrom, airportCodeTo, departure)) {
                listFlightModel.addRow(new Object[]{
                    //Flight number
                    flight.getFlightNumber(),
                    //From
                    flight.getAirportFrom().getCity(),
                    //Departure
                    flightDepartureToString(flight),
                    //To
                    flight.getAirportTo().getCity(),
                    //Arrival
                    flightArrivalToString(flight),
                    //Price
                    flight.getBasicPrice(), //Book flight
                });
            }
        }

    }

    private void showSelectedFlightId() {
        final DefaultTableModel listFlightModel = (DefaultTableModel) jTable1.getModel();
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bookFlightError.setText("");
                if (jTable1.getSelectedRow() >= 0) {
                    //String selectedflightNumber = String.valueOf(listFlightModel.getValueAt(jTable1.getSelectedRow(), 0));
                    int selectedflightNumber = (int) listFlightModel.getValueAt(jTable1.getSelectedRow(), 0);
                    selectedFlight = flightRepo.getFlightByFlightNumber(selectedflightNumber);
                    bookedFlightLabel.setText(String.valueOf(selectedFlight.getFlightNumber()));
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLbl_FlightNum = new javax.swing.JLabel();
        jLbl_From = new javax.swing.JLabel();
        jLbl_Departure = new javax.swing.JLabel();
        jLbl_To = new javax.swing.JLabel();
        jLbl_Arrival = new javax.swing.JLabel();
        jLbl_Price = new javax.swing.JLabel();
        jLbl_Book = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLbl_User = new javax.swing.JLabel();
        jLbl_UserType = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bookedFlightLabel = new javax.swing.JLabel();
        bookFlightButton = new javax.swing.JButton();
        bookFlightError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLbl_FlightNum.setText("Flight number");

        jLbl_From.setText("From");

        jLbl_Departure.setText("Departure");

        jLbl_To.setText("To");

        jLbl_Arrival.setText("Arrival");

        jLbl_Price.setText("Price");

        jLbl_Book.setText("Book this flight");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AHA Bernot Helga, Simonics Anett");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Welcome");

        jLbl_User.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLbl_User.setText("user");

        jLbl_UserType.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLbl_UserType.setText("user type");

        jLabel8.setText("Your flight preference:");

        bookFlightButton.setText("Book flight");
        bookFlightButton.setAlignmentY(0.0F);
        bookFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookFlightButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight number", "From", "Departure", "To", "Arrival", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("Highlight row to select flight");
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(21, 21, 21)
                        .addComponent(bookedFlightLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLbl_User)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLbl_UserType)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bookFlightError)
                        .addGap(50, 50, 50)
                        .addComponent(bookFlightButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbl_UserType)
                    .addComponent(jLbl_User)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(bookedFlightLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bookFlightError)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bookFlightButton)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void bookFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookFlightButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel listFlightModel = (DefaultTableModel) jTable1.getModel();
        if (selectedFlight != null) {
            SelectSeatForm selectSeatForm = new SelectSeatForm(selectedFlight, passenger);
            selectSeatForm.setVisible(true);
            this.dispose();
        } //Set error msg if no flight is selected
        else {
            bookFlightError.setText("Please choose a flight");
            bookFlightError.setForeground(Color.red);
        }
    }//GEN-LAST:event_bookFlightButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookFlightButton;
    private javax.swing.JLabel bookFlightError;
    private javax.swing.JLabel bookedFlightLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLbl_Arrival;
    private javax.swing.JLabel jLbl_Book;
    private javax.swing.JLabel jLbl_Departure;
    private javax.swing.JLabel jLbl_FlightNum;
    private javax.swing.JLabel jLbl_From;
    private javax.swing.JLabel jLbl_Price;
    private javax.swing.JLabel jLbl_To;
    private javax.swing.JLabel jLbl_User;
    private javax.swing.JLabel jLbl_UserType;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
