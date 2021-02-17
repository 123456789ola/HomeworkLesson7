package org.example;

public class ExchangeRate {
    private String baseCurrency;
    private String currency;
    private float saleRateNB;
    private float purchaseRateNB;

    public ExchangeRate() {
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getSaleRateNB() {
        return saleRateNB;
    }

    public void setSaleRateNB(float saleRateNB) {
        this.saleRateNB = saleRateNB;
    }

    public float getPurchaseRateNB() {
        return purchaseRateNB;
    }

    public void setPurchaseRateNB(float purchaseRateNB) {
        this.purchaseRateNB = purchaseRateNB;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", currency='" + currency + '\'' +
                ", saleRateNB=" + saleRateNB +
                ", purchaseRateNB=" + purchaseRateNB +
                '}';
    }
}