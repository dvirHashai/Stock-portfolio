package com.fyber.stockportfolio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 * @author Dvir.Hashai
 */
public class Stock implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = 5464146937129366715L;

    /* --- Private methods --- */

    @SerializedName("STOCK_NAME")
    private String name;

    @SerializedName("STOCK_VALUE")
    private Double value;

    @SerializedName("STOCK_DATE")
    private Calendar calendar;

    /* --- Constructors --- */

    public Stock() {
    }

    public Stock(String name, Double value, Calendar calendar) {
        this.name = name;
        this.value = value;
        this.calendar = calendar;
    }

    public Stock(Stock stock){
        this.name = stock.name;
        this.value = stock.value;
        this.calendar = stock.calendar;
    }
    /* --- Overridden methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return Objects.equals(name, stock.name) &&
                Objects.equals(value, stock.value) &&
                Objects.equals(calendar, stock.calendar);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, value, calendar);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", date=" + calendar +
                '}';
    }

    /* --- Getters / Setters --- */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Calendar getDate() {
        return calendar;
    }

    public void setDate(Calendar date) {
        this.calendar = date;
    }
}
