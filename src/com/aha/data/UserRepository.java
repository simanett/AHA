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
 * @author simonicsanett
 */
public class UserRepository {
    
    public User getUserById(int id) {
        for(User user : users()) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    
    public User getUserByName(String name) {
        for(User user : users()) {
            if(user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
    
    public List<User> getUsers() {
        return users();
    } 
    
    public void addUser(User user) {
        users().add(user);
        FileSystemManager.getInstance().saveState();
    }
    
    private List<User> users() {
        return FileSystemManager.getInstance().getState().getUsers();
    }
}

