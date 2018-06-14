package com.fyber.stockportfolio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Dvir.Hashai
 */

public class user implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = 1858062350646040014L;

    /* --- Private methods --- */

    @SerializedName("USER_ID")
    private Integer id;

    @SerializedName("STOCK_PORTFOLIO")
    private StockPortfolio stockPortfolio;

    /* --- Constructors --- */

    public user(Integer id, StockPortfolio stockPortfolio) {
        this.id = id;
        this.stockPortfolio = stockPortfolio;
    }

    /* --- Public methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof user)) return false;
        user user = (user) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(stockPortfolio, user.stockPortfolio);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, stockPortfolio);
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", stockPortfolio=" + stockPortfolio +
                '}';
    }

    /* --- Getters / Setters --- */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StockPortfolio getStockPortfolio() {
        return stockPortfolio;
    }

    public void setStockPortfolio(StockPortfolio stockPortfolio) {
        this.stockPortfolio = stockPortfolio;
    }
}

