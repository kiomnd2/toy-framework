package com.servlet.database;

public class DatabaseManager {

    private static DatabaseManager instance = new DatabaseManager();

    public static DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseManager() {
        init();
    }

    private void init() {


    }

}
