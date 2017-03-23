package com.udemy.model;

/**
 * Created by Julio on 03/03/2017.
 */
public class UserCredencial {

    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserCredencial(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserCredencial(){

    }
}
