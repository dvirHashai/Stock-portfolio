package com.fyber.stockportfolio.common.response.dtos;

import java.io.Serializable;
import java.util.*;

/**
 * @author Dvir.Hashai
 */
public class StockPortfolioDto implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = 3716842197212895084L;

    /* --- Private methods --- */
    private Collection<StockDto> stocks = new LinkedList<StockDto>();
    private Map<String, Integer> StocksAmount = new HashMap<>();

    /* --- Constructors --- */

    public StockPortfolioDto(Collection<StockDto> stocks, Map<String, Integer> stocksAmount) {
        this.stocks = stocks;
        StocksAmount = stocksAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockPortfolioDto)) return false;
        StockPortfolioDto that = (StockPortfolioDto) o;
        return Objects.equals(stocks, that.stocks) &&
                Objects.equals(StocksAmount, that.StocksAmount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stocks, StocksAmount);
    }

    @Override
    public String toString() {
        return "StockPortfolioDto{" +
                "stocks=" + stocks +
                ", StocksAmount=" + StocksAmount +
                '}';
    }

    public Collection<StockDto> getStocks() {
        return stocks;
    }

    public void setStocks(Collection<StockDto> stocks) {
        this.stocks = stocks;
    }

    public Map<String, Integer> getStocksAmount() {
        return StocksAmount;
    }

    public void setStocksAmount(Map<String, Integer> stocksAmount) {
        StocksAmount = stocksAmount;
    }
}
