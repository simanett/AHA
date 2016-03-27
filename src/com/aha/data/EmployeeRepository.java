/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.AHA;
import com.aha.businesslogic.model.Administrator;
import com.aha.businesslogic.model.CrewMember;
import com.aha.businesslogic.model.Employee;
import com.aha.businesslogic.model.Operator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Repository class to handle employee data
 *
 * @author HB
 */
public class EmployeeRepository {

    /**
     * Return the Employee object with the given id
     *
     * @param id String that identifies the Employee object
     * @return The Employee object if exists, null otherwise
     */
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        PreparedStatement stmt = null;
        String query = "select ID, NAME, EMAIL, ROLE "
                + "from AHA.Employees where ID=? ";

        try {

            stmt = AHA.connection.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            boolean idExist = rs.next();

            if (idExist) {

                int employeeId = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String role = rs.getString("ROLE");

                switch (role) {
                    case "o":
                        employee = new Operator();
                        break;

                    case "a":
                        employee = new Administrator();
                        break;

                    case "c":
                        employee = new CrewMember();
                        break;
                }
                employee.setId(employeeId);
                employee.setName(name);
                employee.setEmail(email);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return employee;
    }

    /**
     * Return the Employee object with the given name
     *
     * @param name String that identifies the Employee object
     * @return The Employee object if exists, null otherwise
     */
    public Employee getEmployeeByName(String name) {

        Employee names = null;
        PreparedStatement stmt = null;

        String query = "select id, name, email, role "
                + "from AHA.Employees where name=?";

        try {

            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            boolean employeeExists = rs.next();
            if (employeeExists) {
                int id = rs.getInt("ID");
                String employeeName = rs.getString("NAME");
                String email = rs.getString("Email");
                String role = rs.getString("ROLE");

                switch (role) {
                    case "o":
                        names = new Operator();
                        break;

                    case "a":
                        names = new Administrator();
                        break;

                    case "c":
                        names = new CrewMember();
                        break;
                }
                names.setId(id);
                names.setName(employeeName);
                names.setEmail(email);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return names;

    }

    /**
     * Return all Employee objects
     *
     * @return all Employees in the database
     */
    public List<Employee> getEmployees() {

        List<Employee> employees = new ArrayList<>();
        Statement stmt = null;

        String query = "SELECT ID, NAME, EMAIL, ROLE "
                + "FROM AHA.EMPLOYEES ";

        try {

            stmt = AHA.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String role = rs.getString("ROLE");
                Employee employee = null;

                switch (role) {
                    case "o":
                        employee = new Operator();
                        break;

                    case "a":
                        employee = new Administrator();
                        break;

                    case "c":
                        employee = new CrewMember();
                        break;
                }
                employee.setId(id);
                employee.setName(name);
                employee.setEmail(email);

                employees.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return employees;
    }
}
