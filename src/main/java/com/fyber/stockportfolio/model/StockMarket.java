package com.fyber.stockportfolio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.*;

/**
 * @author Dvir.Hashai
 */
public class StockMarket implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = 86314163436972001L;

    /* --- Members --- */
    @SerializedName("STOCKS")
    private List<ArrayList<Stock>> stocks;

    @SerializedName("STOCKS_INDEX")
    private Map<String,Integer> IndexMap;

    @SerializedName("STOCKS_VALUE")
    private Map<String,Double> valueMap;

    /* --- Constructors --- */

    public StockMarket() {
        this.stocks = new ArrayList<>();
        this.IndexMap = new HashMap<>();
        this.valueMap = new HashMap<>();
    }

    public StockMarket(List<ArrayList<Stock>> stocks, Map<String, Integer> indexMap, Map<String, Double> valueMap) {
        this.stocks = stocks;
        IndexMap = indexMap;
        this.valueMap = valueMap;
    }

    /* --- Overridden methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockMarket)) return false;
        StockMarket that = (StockMarket) o;
        return Objects.equals(stocks, that.stocks) &&
                Objects.equals(IndexMap, that.IndexMap) &&
                Objects.equals(valueMap, that.valueMap);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stocks, IndexMap, valueMap);
    }

    @Override
    public String toString() {
        return "StockMarket{" +
                "stocks=" + stocks +
                ", IndexMap=" + IndexMap +
                ", valueMap=" + valueMap +
                '}';
    }

    /* --- Getters / Setters --- */

    public List<ArrayList<Stock>> getStocks() {
        return stocks;
    }

    public void setStocks(List<ArrayList<Stock>> stocks) {
        this.stocks = stocks;
    }

    public Map<String, Integer> getIndexMap() {
        return IndexMap;
    }

    public void setIndexMap(Map<String, Integer> indexMap) {
        IndexMap = indexMap;
    }

    public Map<String, Double> getValueMap() {
        return valueMap;
    }

    public void setValueMap(Map<String, Double> valueMap) {
        this.valueMap = valueMap;
    }
}
