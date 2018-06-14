package com.fyber.stockportfolio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Dvir.Hashai
 */
public class StockPortfolio implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = -2418890166391874469L;

    /* --- Private methods --- */

    @SerializedName("STOCK_AMOUNT")
    private Integer amount;

    @SerializedName("STOCK")
    private Stock stock;

    /* --- Constructors --- */

    public StockPortfolio(Integer amount, Stock stock) {
        this.amount = amount;
        this.stock = stock;
    }

    /* --- Public methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockPortfolio)) return false;
        StockPortfolio that = (StockPortfolio) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(stock, that.stock);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, stock);
    }

    @Override
    public String toString() {
        return "StockPortfolio{" +
                "amount=" + amount +
                ", stock=" + stock +
                '}';
    }

    /* --- Getters / Setters --- */
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
