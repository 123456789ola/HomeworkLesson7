package org.example.database;

import org.example.DollarRate;
import org.example.ExchangeRate;

import java.sql.*;


public class DataBase {
    private Connection conn;

    public DataBase(Connection conn) {
        this.conn = conn;
    }

    public void init() {
        try {
            Statement st = conn.createStatement();
            try {
                st.execute("DROP TABLE IF EXISTS Exchange");
                st.execute("CREATE TABLE Exchange (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, date VARCHAR(20) " +
                        "NOT NULL, dollarRate FLOAT (8,6))");
            } finally {
                st.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void add(String date, float dollarRate) {
        try {
            try (PreparedStatement st = conn.prepareStatement("INSERT INTO Exchange (date, dollarRate) VALUES(?, ?)")) {
                st.setString(1, date);
                st.setFloat(2, dollarRate);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public String maxExchangeRate() throws SQLException {


        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT MAX(dollarRate) FROM Exchange")) {

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();

                return rs.getString(1);
            }
        }
    }

    public String averageDollarRate() throws SQLException {

        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT AVG(dollarRate) FROM Exchange")) {

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();

                return rs.getString(1);
            }
        }
    }


}