package com.fyber.stockportfolio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Dvir.Hashai
 */

public class User implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = 1858062350646040014L;

    /* --- Private methods --- */

    @SerializedName("USER_ID")
    private UUID id;

    @SerializedName("STOCK_PORTFOLIO")
    private StockPortfolio stockPortfolio;

    /* --- Constructors --- */

    public User() {
        this.id = UUID.randomUUID();

    }

    public User(StockPortfolio stockPortfolio) {
        this.id = UUID.randomUUID();
        this.stockPortfolio = stockPortfolio;
    }

    public User(User user){
        this.id = user.id;
        this.stockPortfolio = user.stockPortfolio;
    }

    /* --- Overridden methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User User = (User) o;
        return Objects.equals(id, User.id) &&
                Objects.equals(stockPortfolio, User.stockPortfolio);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, stockPortfolio);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", stockPortfolio=" + stockPortfolio +
                '}';
    }

    /* --- Getters / Setters --- */

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public StockPortfolio getStockPortfolio() {
        return stockPortfolio;
    }

    public void setStockPortfolio(StockPortfolio stockPortfolio) {
        this.stockPortfolio = stockPortfolio;
    }
}

