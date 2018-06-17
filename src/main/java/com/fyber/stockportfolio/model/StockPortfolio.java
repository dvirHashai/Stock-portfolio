package com.fyber.stockportfolio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.*;

/**
 * @author Dvir.Hashai
 */
public class StockPortfolio implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = -2418890166391874469L;

    /* --- Private methods --- */

    @SerializedName("STOCKS")
    private List<Stock> stocks ;

    @SerializedName("STOCK_AMOUNT")
    private Map<String, Double> stocksAmountMap ;


    /* --- Constructors --- */

    public StockPortfolio() {
        this.stocks = new ArrayList<>();
        this.stocksAmountMap = new HashMap<>();
    }

    public StockPortfolio(List<Stock> stocks, Map<String, Double> StocksAmountMap) {
        this.stocks = stocks;
        this.stocksAmountMap = StocksAmountMap;
    }

    public StockPortfolio(StockPortfolio stockPortfolio){
        this.stocks = stockPortfolio.getStocks();
        this.stocksAmountMap = stockPortfolio.getStocksAmountMap();
    }

   /* --- Overridden methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockPortfolio)) return false;
        StockPortfolio that = (StockPortfolio) o;
        return Objects.equals(stocks, that.stocks) &&
                Objects.equals(stocksAmountMap, that.stocksAmountMap);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stocks, stocksAmountMap);
    }

    @Override
    public String toString() {
        return "StockPortfolio{" +
                "stocks=" + stocks +
                ", StocksAmountMap=" + stocksAmountMap +
                '}';
    }

    /* --- Getters / Setters --- */

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public Map<String, Double> getStocksAmountMap() {
        return stocksAmountMap;
    }

    public void setStocksAmountMap(Map<String, Double> stocksAmountMap) {
        this.stocksAmountMap = stocksAmountMap;
    }
}
