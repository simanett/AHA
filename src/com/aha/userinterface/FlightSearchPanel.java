/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.userinterface;

import com.aha.data.AirportRepository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.EventListenerList;

/**
 *
 * @author HB
 */
public class FlightSearchPanel extends javax.swing.JPanel {

    private EventListenerList actionListenerList = new EventListenerList();
    private AirportRepository airportRepository = new AirportRepository();

    /**
     * Creates new form FligtSearchPanel
     */
    public FlightSearchPanel() {

        //initComponents();
        this.setSize(800, 40);

        JLabel labelFrom = new JLabel();
        labelFrom.setText("From:");
        add(labelFrom);

        final JComboBox comboFrom = new JComboBox();
        comboFrom.addItem("");
        for (int i = 0; i < airportRepository.getAirports().size(); i++) {
            comboFrom.addItem(String.valueOf(airportRepository.getAirports().get(i).getCode()));
        }
        add(comboFrom);

        JLabel labelTo = new JLabel();
        labelTo.setText("To:");
        add(labelTo);

        final JComboBox comboTo = new JComboBox();
        comboTo.addItem("");
        for (int i = 0; i < airportRepository.getAirports().size(); i++) {
            comboTo.addItem(String.valueOf(airportRepository.getAirports().get(i).getCode()));
        }
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
        final JComboBox comboYear = new JComboBox();
        int year = cal.get(Calendar.YEAR);
        for (int i = 0; i < 3; i++) {
            comboYear.addItem(year + i);
        }
        add(comboYear);

        //Combo box for months
        String[] monthsString = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
        final JComboBox comboMonth = new JComboBox();
        for (int i = 0; i < monthsString.length; i++) {
            comboMonth.addItem(monthsString[i]);
        }
        comboMonth.setSelectedIndex(month);
        add(comboMonth);

        //Combo box for days
        final JComboBox comboDay = new JComboBox();
        year = (Integer) comboYear.getSelectedItem();
        month = comboMonth.getSelectedIndex() + 1;
        int numDays = 0;
        listDays(year, month, numDays, comboDay);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        comboDay.setSelectedIndex(day);
        add(comboDay);

        comboMonth.addItemListener(new ItemListener() {
            // Listening if a new item of the combo box has been selected.
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    int year = (Integer) comboYear.getSelectedItem();
                    int month = comboMonth.getSelectedIndex() + 1;
                    int numDays = 0;
                    listDays(year, month, numDays, comboDay);
                }
            }
        });

        JButton buttonFilter = new JButton();
        buttonFilter.setText("Filter flights");
        buttonFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String airportCodeFrom = String.valueOf(comboFrom.getSelectedItem());
                String airportCodeTo = String.valueOf(comboTo.getSelectedItem());
                Date departure = new GregorianCalendar((int) comboYear.getSelectedItem(),
                        comboMonth.getSelectedIndex(),
                        (int) comboDay.getSelectedItem()).getTime();
                fireActionPerformed(new FlightSearchEvent(this, ActionEvent.ACTION_PERFORMED,
                        null, airportCodeFrom, airportCodeTo, departure));
            }
        });
        add(buttonFilter);
    }

    public void listDays(int year, int month, int numDays, JComboBox comboDay) {
        Calendar mycal = new GregorianCalendar(year, month - 1, 1);
        numDays = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        comboDay.removeAllItems();
        for (int i = 0; i < numDays; i++) {
            comboDay.addItem(i + 1);
        }
    }

    public void addActionListener(ActionListener actionListener) {
        actionListenerList.add(ActionListener.class, actionListener);
    }

    public void removeActionListener(ActionListener actionListener) {
        actionListenerList.remove(ActionListener.class, actionListener);
    }

    protected void fireActionPerformed(FlightSearchEvent actionEvent) {
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
