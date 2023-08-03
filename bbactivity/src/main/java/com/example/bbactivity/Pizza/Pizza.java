package com.example.bbactivity.Pizza;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Pizza {
    @Id
    @SequenceGenerator(
            name="pizza_sequence",
            sequenceName="pizza_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pizza_sequence"
    )
    private long id;
    private String name;
    private LocalDate datecreated;
    private LocalDate dateexpiration;

    @Transient
    private Integer days;

    public Pizza() {
    }

    public Pizza(long id, String name, LocalDate datecreated, LocalDate dateexpiration) {
        this.id = id;
        this.name = name;
        this.datecreated = datecreated;
        this.dateexpiration = dateexpiration;
    }

    public Pizza(String name, LocalDate datecreated, LocalDate dateexpiration) {
        this.name = name;
        this.datecreated = datecreated;
        this.dateexpiration = dateexpiration;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(LocalDate datecreated) {
        this.datecreated = datecreated;
    }

    public LocalDate getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(LocalDate dateexpiration) {
        this.dateexpiration = dateexpiration;
    }
    public Integer getDays(){
      return Period.between(this.datecreated,this.dateexpiration).getDays();

    }
    public void setDays(Integer days) {
        this.days = days;
    }


    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", datecreated=" + datecreated +
                ", dateexpiration=" + dateexpiration +
                '}';
    }
}

