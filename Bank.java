package org.example;

import java.util.List;

public class Bank {
    private String date;
    private String bank;
    private float baseCurrency;
    private String baseCurrencyLit;
    private List<ExchangeRate> exchangeRate;

    public Bank() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {

        this.bank = bank;
    }

    public float getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(float baseCurrency) {

        this.baseCurrency = baseCurrency;
    }

    public String getBaseCurrencyLit() {
        return baseCurrencyLit;
    }

    public void setBaseCurrencyLit(String baseCurrencyLit) {
        this.baseCurrencyLit = baseCurrencyLit;
    }

    public List<ExchangeRate> getExchangeRate() {

        return exchangeRate;
    }

    public void setExchangeRate(List<ExchangeRate> exchangeRate) {

        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "bank{" +
                "date='" + date + '\'' +
                ", bank='" + bank + '\'' +
                ", baseCurrency=" + baseCurrency +
                ", baseCurrencyLit='" + baseCurrencyLit + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
