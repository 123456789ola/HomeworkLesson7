package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;

import com.google.gson.GsonBuilder;
import org.example.database.ConnectionFactory;
import org.example.database.DataBase;
import org.example.resources.DBProperties;

import javax.xml.soap.SOAPConnectionFactory;

public class App {
    static String stringJSON = "{\"baseCurrency\":\"UAH\",\"saleRateNB\":21.0188000,\"purchaseRateNB\":21.0188000}";


    public static void main(String[] args) throws IOException, MalformedURLException, SQLException, UnknownHostException {

        DBProperties dbProperties = new DBProperties();

        for (int i = 2014; i < 2016; i++) {
            URL url = new URL("https://api.privatbank.ua/p24api/exchange_rates?json&date=01.12." + i);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputStreamJSON = "";
            String tmp = "";

            while ((tmp = br.readLine()) != null) {
                inputStreamJSON += tmp;

            }
            Gson gson = new GsonBuilder().create();
            Bank b = gson.fromJson(inputStreamJSON, Bank.class);
            System.out.println(b);

            DollarRate dollarRate = new DollarRate();


            dollarRate.setId(1);
            dollarRate.setDate(b.getDate());

            List<ExchangeRate> list = b.getExchangeRate();
            for (ExchangeRate num : list) {
                if (num.getCurrency().equals("USD")) {
                    dollarRate.setDollarRate(num.getSaleRateNB());
                }
            }

            System.out.println(dollarRate);
            ConnectionFactory factory = new ConnectionFactory(dbProperties.getDB_CONNECTION(),
                    dbProperties.getDB_USER(), dbProperties.getDB_PASSWORD());
            Connection conn = factory.getConnection();
            try {
                DataBase db = new DataBase(conn);
                db.init();
                db.add(dollarRate.getDate(), (float) dollarRate.getDollarRate());

                System.out.println(db.maxExchangeRate());
                System.out.println(db.averageDollarRate());

            } finally {
                conn.close();
            }

        }


    }
}
