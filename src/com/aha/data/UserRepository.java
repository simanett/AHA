/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.businesslogic.model.User;
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
    public User getUserById(int id) {
        for (User user : users()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /**
     * Return the User object with the given name
     *
     * @param name String that identifies the User object
     * @return The User object if exists, null otherwise
     */
    public User getUserByName(String name) {
        for (User user : users()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Return all User objects
     *
     * @return All Users in the application state
     */
    public List<User> getUsers() {
        return users();
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
