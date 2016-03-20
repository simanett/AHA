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
import com.aha.businesslogic.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Repository class to handle user data
 *
 * @author simonicsanett
 */
public class UserRepository {

    /**
     * Return the User object with the given id
     *
     * @param id String that identifies the User object
     * @return The User object if exists, null otherwise
     */
    public User getUserById(int id) throws SQLException {
        User user = null;
        PreparedStatement stmt = null;
        String query = "select ID, NAME, EMAIL, ROLE "
                + "from AHA.Users where ID=? ";

        try {

            stmt = AHA.connection.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            boolean idExist = rs.next();

            if (idExist) {

                int userid = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String role = rs.getString("ROLE");

                switch (role) {
                    case "o":
                        user = new Operator();
                        break;

                    case "a":
                        user = new Administrator();
                        break;

                    case "c":
                        user = new CrewMember();
                        break;
                }
                user.setId(userid);
                user.setName(name);
                user.setEmail(email);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return user;
    }

//        for (User user : users()) {
//            if (user.getId() == id) {
//                return user;
//            }
//        }
//        return null;
    /**
     * Return the User object with the given name
     *
     * @param name String that identifies the User object
     * @return The User object if exists, null otherwise
     */
    public User getUserByName(String name) throws SQLException {

        User names = null;
        PreparedStatement stmt = null;

        String query = "select id, name, email, role "
                + "from AHA.Users where name=?";

        try {

            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            boolean userExist = rs.next();
            if (userExist) {
                int id = rs.getInt("ID");
                String username = rs.getNString("NAME");
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
                names.setName(username);
                names.setEmail(email);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return names;

    }

//{
//        for (User user : users()) {
//            if (user.getName().equals(name)) {
//                return user;
//            }
//        }
//        return null;
//    }
    /**
     * Return all User objects
     *
     * @return All Users in the application state
     */
    public List<User> getUsers() throws SQLException {

        List<User> users = new ArrayList<>();
        Statement stmt = null;

        String query = "select id, name, email, role "
                + "from AHA.Users ";

        try {

            stmt = AHA.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String role = rs.getString("ROLE");
                User user = null;

                switch (role) {
                    case "o":
                        user = new Operator();
                        break;

                    case "a":
                        user = new Administrator();
                        break;

                    case "c":
                        user = new CrewMember();
                        break;
                }

                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                users.add(user);

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return users;
        
        }

//        return users();
    }

    /**
     * Add a new User object to the application state and save it to the XML
     *
     * @param user The User object to add
     */
    public void addUser(User user) {
        users().add(user);
        FileSystemManager.getInstance().saveState();
    }

    /**
     * Helper method to get all User objects from application state
     *
     * @return List of User objects
     */
    private List<User> users() {
        return FileSystemManager.getInstance().getState().getUsers();
    }
}
