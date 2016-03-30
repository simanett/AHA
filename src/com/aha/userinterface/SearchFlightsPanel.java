/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.userinterface;

import com.aha.businesslogic.model.Airport;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.EventListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.EventListenerList;
import org.jdesktop.swingx.calendar.DateUtils;

/**
 *
 * @author HB
 */
public class SearchFlightsPanel extends javax.swing.JPanel {

    private EventListenerList actionListenerList = new EventListenerList();
    
    /**
     * Creates new form FligtSearchPanel
     */
    public SearchFlightsPanel() {
        initComponents();
    }

    public void setAirports(List<Airport> airports) {        
        fromComboBox.setModel(new DefaultComboBoxModel(airports.toArray()));
        toComboBox.setModel(new DefaultComboBoxModel(airports.toArray()));
    }

    public void addActionListener(ActionListener actionListener) {
        actionListenerList.add(ActionListener.class, actionListener);
    }

    public void removeActionListener(ActionListener actionListener) {
        actionListenerList.remove(ActionListener.class, actionListener);
    }

    private void fireActionPerformed(FlightSearchEvent actionEvent) {
        EventListener[] listenerList = actionListenerList.getListeners(ActionListener.class);
        for (EventListener listener : listenerList) {
            ((ActionListener) listener).actionPerformed(actionEvent);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fromDatePicker = new org.jdesktop.swingx.JXDatePicker();
        toDatePicker = new org.jdesktop.swingx.JXDatePicker();
        toComboBox = new javax.swing.JComboBox<>();
        fromComboBox = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(780, 78));
        setSize(new java.awt.Dimension(780, 78));

        jLabel1.setText("From:");

        jLabel2.setText("To:");

        jLabel3.setText("Between");

        jLabel4.setText("and");

        fromDatePicker.setPreferredSize(new java.awt.Dimension(120, 26));

        toDatePicker.setPreferredSize(new java.awt.Dimension(120, 26));

        toComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        toComboBox.setPreferredSize(new java.awt.Dimension(120, 27));

        fromComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fromComboBox.setPreferredSize(new java.awt.Dimension(120, 27));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(toDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(fromDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        Airport airportFrom = (Airport)fromComboBox.getSelectedItem();
        Airport airportTo = (Airport)toComboBox.getSelectedItem();

        Date fromDate = fromDatePicker.getDate();
        Date toDate = toDatePicker.getDate();

        fireActionPerformed(new FlightSearchEvent(this, ActionEvent.ACTION_PERFORMED,
                null, airportFrom.getCode(), airportTo.getCode(), DateUtils.startOfDay(fromDate), DateUtils.endOfDay(toDate)));    }//GEN-LAST:event_searchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> fromComboBox;
    private org.jdesktop.swingx.JXDatePicker fromDatePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> toComboBox;
    private org.jdesktop.swingx.JXDatePicker toDatePicker;
    // End of variables declaration//GEN-END:variables
}