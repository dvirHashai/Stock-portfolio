package com.fyber.stockportfolio.common.response.dtos;

import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.*;

/**
 * @author Dvir.Hashai
 */
public class StockPortfolioDto implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = 3716842197212895084L;

    /* --- Private methods --- */
    @Nullable
    private List<StockDto> stocksDto ;
    private Map<String, Double> stocksAmountMapDto ;

    /* --- Constructors --- */


    public StockPortfolioDto() {
       this.stocksDto = new ArrayList<>();
        this.stocksAmountMapDto = new HashMap<>();
    }

    public StockPortfolioDto(List<StockDto> stocks, Map<String, Double> StocksAmountMap) {
        this.stocksDto = stocks;
        this.stocksAmountMapDto = StocksAmountMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockPortfolioDto)) return false;
        StockPortfolioDto that = (StockPortfolioDto) o;
        return Objects.equals(stocksDto, that.stocksDto) &&
                Objects.equals(stocksAmountMapDto, that.stocksAmountMapDto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stocksDto, stocksAmountMapDto);
    }

    @Override
    public String toString() {
        return "StockPortfolioDto{" +
                "stocks=" + stocksDto +
                ", StocksAmountMap=" + stocksAmountMapDto +
                '}';
    }

    public List<StockDto> getStocksDto() {
        return stocksDto;
    }

    public void setStocksDto(List<StockDto> stocksDto) {
        this.stocksDto = stocksDto;
    }

    public Map<String, Double> getStocksAmountMapDto() {
        return stocksAmountMapDto;
    }

    public void setStocksAmountMapDto(Map<String, Double> stocksAmountMapDto) {
        this.stocksAmountMapDto = stocksAmountMapDto;
    }
}
