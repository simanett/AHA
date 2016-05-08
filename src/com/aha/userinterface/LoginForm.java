/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.userinterface;

import com.aha.businesslogic.model.Administrator;
import com.aha.businesslogic.model.CrewMember;
import com.aha.businesslogic.model.Employee;
import com.aha.businesslogic.model.Operator;
import com.aha.businesslogic.model.Passenger;
import com.aha.businesslogic.model.User;
import com.aha.data.EmployeeRepository;
import com.aha.data.FlightRepository;
import com.aha.data.PassengerRepository;
import com.aha.data.UserRepository;
import javax.swing.JOptionPane;

/**
 *
 * @author simonicsanett
 */
public class LoginForm extends javax.swing.JFrame {

    private final UserRepository userRepository = new UserRepository();
    private final PassengerRepository passengerRepository = new PassengerRepository();
    private final FlightRepository flightRepository = new FlightRepository();
    private final EmployeeRepository employeeRepository = new EmployeeRepository();

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        rootPane.setDefaultButton(loginButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userNameBox = new javax.swing.JTextField();
        passwordBox = new javax.swing.JPasswordField();
        userLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AHA Bernot Helga, Simonics Anett");

        userNameBox.setSize(new java.awt.Dimension(84, 128));

        userLabel.setText("Username:");

        passwordLabel.setText("Password:");

        loginButton.setText("Log in");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel)
                            .addComponent(passwordLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameBox, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(passwordBox)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(loginButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String userName = userNameBox.getText();
        User user = null;
        Employee employee = employeeRepository.getEmployeeByName(userName);
        if (employee == null) {
            Passenger passenger = passengerRepository.getPassengerByName(userName);
            user = (User) passenger;
            if (passenger == null) {
                JOptionPane.showMessageDialog(null, "Invalid user name");
            } else {
                PassengerForm passengerForm = new PassengerForm();
                passengerForm.setPassenger(passenger);
                passengerForm.setVisible(true);
//                ListFlightsForm listFlightsForm = new ListFlightsForm(user);
//                listFlightsForm.setVisible(true);
            }
        } else if (employee instanceof Operator) {
            Operator operator = (Operator) employee;
            user = (User) operator;
            ApproveBookingForm approveForm = new ApproveBookingForm();
            approveForm.setVisible(true);
        } else if (employee instanceof CrewMember) {
            JOptionPane.showMessageDialog(null, "Welcome, crew member!");
//            CrewMember crewMember = (CrewMember) employee;
//            user = (User) crewMember;
//            ApproveBookingForm approveForm = new ApproveBookingForm();
//            approveForm.setVisible(true);
        } else if (employee instanceof Administrator) {
            Administrator administrator = (Administrator) employee;
            user = (User) administrator;
            ApproveBookingForm approveForm = new ApproveBookingForm();
            approveForm.setVisible(true);
        }

    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordBox;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userNameBox;
    // End of variables declaration//GEN-END:variables
}
