package com.servlet.database.connection.impl;

import com.servlet.database.connection.ConnectionMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DriverConnection implements ConnectionMaker {

    private String url;

    private String user;

    private String password;

    public H2DriverConnection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public H2DriverConnection(String url) {
        this.url = url;
        setUser("sa");
        setPassword("");
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
