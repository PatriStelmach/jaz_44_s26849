package com.example.NBP.Models;

import java.util.List;

public class ResponseNBP {
    private List<Rate> rates;
    private double avgRate;

    public ResponseNBP(List<Rate> rates, double avgRate) {
        this.rates = rates;
        this.avgRate = avgRate;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public double getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }
}
