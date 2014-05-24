package com.hairCustomer.management.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseStore {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");

        return DriverManager.getConnection("jdbc:sqlite:C:/projects/HairCustomerManagement/src/test/resource/HairCustomerTestDB.db");
    }
}
