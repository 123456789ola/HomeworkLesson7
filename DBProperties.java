package org.example.resources;

public class DBProperties {
    private final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb00?serverTimezone=Europe/Kiev";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "pass111";

    public DBProperties() {
    }

    public String getDB_CONNECTION() {
        return DB_CONNECTION;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public String getDB_PASSWORD() {
        return DB_PASSWORD;
    }
}
