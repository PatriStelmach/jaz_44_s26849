package com.example.NBP.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rate {
    @Schema(description = "Rate date", example = "2014-08-20")
    @JsonProperty("data")
    private String date;

    @Schema(description = "Price of gold", example = "250.13")
    @JsonProperty("cena")
    private double cena;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
