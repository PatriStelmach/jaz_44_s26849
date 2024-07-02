package com.example.NBP.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity
public class GoldValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id of currency rate record.", required = true)
    private Integer id;

    @Schema(description = "Gold", required = true)
    @Column(name = "gold", columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private Gold gold;

    @Schema(description = "Start of interval used to calculate rate", required = true)
    @Column(name = "start_date")
    private LocalDate startDate;

    @Schema(description = "End of interval used to calculate rate", required = true)
    @Column(name = "end_date")
    private LocalDate endDate;

    @Schema(description = "Sum of rates divided by amount of days", required = true)
    @Column(name = "avg_rate")
    private Double avgRate;

    @Schema(description = "Date and time of request", required = true)
    @Column(name = "created")
    private Instant created;

    public GoldValue(Integer id, Gold gold ,LocalDate startDate, LocalDate endDate, Double avgRate, Instant created) {
        this.id = id;
        this.gold = gold;
        this.startDate = startDate;
        this.endDate = endDate;
        this.avgRate = avgRate;
        this.created = created;
    }

    public GoldValue() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(Double rate) {
        this.avgRate = rate;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }


}
