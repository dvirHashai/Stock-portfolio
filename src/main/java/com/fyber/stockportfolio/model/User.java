package com.fyber.stockportfolio.model;

import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.Email;
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

    @SerializedName("Email")
    @Email
    private String email;

    /* --- Constructors --- */

    public User() {
        this.id = UUID.randomUUID();

    }

    public User(StockPortfolio stockPortfolio,  String email) {
        this.stockPortfolio = stockPortfolio;
        this.email = email;
    }

    public User(User user){
        this.id = user.id;
        this.stockPortfolio = user.stockPortfolio;
        this.email = user.email;
    }

    /* --- Overridden methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(stockPortfolio, user.stockPortfolio) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, stockPortfolio, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "stockPortfolio=" + stockPortfolio +
                ", email='" + email + '\'' +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

