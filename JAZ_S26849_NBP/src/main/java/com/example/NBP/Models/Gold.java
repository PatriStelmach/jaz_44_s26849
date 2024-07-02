package com.example.NBP.Models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Gold")
public enum Gold
{
    GOLD("gold");

    private String gold;

    Gold(String gold) {
        this.gold = gold;
    }
}
