package org.example;

public class DollarRate {
    private int id;
    private String date;
    private float dollarRate;

    public DollarRate() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDollarRate() {
        return dollarRate;
    }

    public void setDollarRate(float dollarRate) {
        this.dollarRate = dollarRate;
    }

    @Override
    public String toString() {
        return "DollarRate{" +
                "iD=" + id +
                ", date='" + date + '\'' +
                ", dollarRate=" + dollarRate +
                '}';
    }
}
