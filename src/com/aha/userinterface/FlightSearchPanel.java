/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.userinterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author HB
 */
public class FlightSearchPanel extends javax.swing.JPanel {

    /**
     * Creates new form FligtSearchPanel
     */
    
    public FlightSearchPanel() {
        
        //initComponents();
        this.setSize(800, 40);
       
        JLabel labelFrom = new JLabel();
        labelFrom.setText("From:");
        add(labelFrom);
       
        JComboBox comboFrom = new JComboBox();
        comboFrom.addItem("DUB");
        comboFrom.addItem("BUD");
        add(comboFrom);
       
        JLabel labelTo = new JLabel();
        labelTo.setText("To:");
        add(labelTo);
       
        JComboBox comboTo = new JComboBox();
        comboTo.addItem("DUB");
        comboTo.addItem("BUD");
        add(comboTo);
       
        //Setting date
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        
        JLabel labelDepDate = new JLabel();
        labelDepDate.setText("Departure date");
        add(labelDepDate);
        
        //Combo box for year
        JComboBox comboYear = new JComboBox();
        int year = cal.get(Calendar.YEAR);
        for (int i = 0; i < 3; i++) {
            comboYear.addItem(year + i);
        }
        add(comboYear);
        
        //Combo box for months
        String[] monthsString = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
        JComboBox comboMonth = new JComboBox();
            for (int i = 0; i < monthsString.length; i++) {
            comboMonth.addItem(monthsString[i]);
        }
        comboMonth.setSelectedIndex(month);
        add(comboMonth);
        
        //Combo box for days
        JComboBox comboDay = new JComboBox();
        year = (Integer) comboYear.getSelectedItem();
        month = comboMonth.getSelectedIndex() + 1;
        int numDays = 0;
        listDays(year, month, numDays, comboDay);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        comboDay.setSelectedIndex(day);
        add(comboDay);
        
        comboMonth.addItemListener(new ItemListener() {
            // Listening if a new item of the combo box has been selected.
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    int year = (Integer) comboYear.getSelectedItem();
                    int month = comboMonth.getSelectedIndex() + 1;
                    int numDays = 0;
                    listDays(year, month, numDays, comboDay);
                }
            }
        });
        
        
        /*
        comboMonth.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ) {
                    
                }
            }
        });*/
        /*
        comboMonth.addActionListener(new );
        comboMonth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bookFlightError.setText("");
                String selectedflightNumber = String.valueOf(listFlightModel.getValueAt(jTable1.getSelectedRow(), 0));
                selectedFlight = flightRepo.getFlightByFlightNumber(selectedflightNumber);
                bookedFlightLabel.setText(String.valueOf(selectedFlight.getFlightNumber()));
                selectedFlight = flightRepo.getFlightByFlightNumber(selectedflightNumber);
            }
        });*/

    }

    public void listDays(int year, int month, int numDays, JComboBox comboDay){
        switch (month){
            case 2:
                if (((year % 4 == 0) && 
                     !(year % 100 == 0))
                     || (year % 400 == 0))
                    numDays = 29;
                else
                    numDays = 28;
                break;
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                numDays = 31;
                break;
            case 4: case 6: case 9: case 11:
                numDays = 30;
                break;
        }
        comboDay.removeAllItems();
        for (int i = 0; i < numDays; i++) {
            comboDay.addItem(i+1);
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

        jComboBox1 = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(780, 78));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(524, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    // End of variables declaration//GEN-END:variables
}
