package com.fyber.stockportfolio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
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

    /* --- Constructors --- */

    public Stock(String name, Double value) {
        this.name = name;
        this.value = value;
    }
    /* --- Public methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return Objects.equals(name, stock.name) &&
                Objects.equals(value, stock.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", value=" + value +
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
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
