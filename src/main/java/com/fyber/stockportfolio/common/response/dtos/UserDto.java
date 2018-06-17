package com.fyber.stockportfolio.common.response.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Dvir.Hashai
 */
public class UserDto implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = -6993264925481725599L;

    /* --- Members --- */

    private StockPortfolioDto stockPortfolioDto;

    /* --- Constructors --- */

    public UserDto() {
        //this.stockPortfolioDto = new StockPortfolioDto();
    }

    public UserDto(StockPortfolioDto stockPortfolioDto) {
        this.stockPortfolioDto = stockPortfolioDto;
    }

    /* --- Public methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(stockPortfolioDto, userDto.stockPortfolioDto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stockPortfolioDto);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "stockPortfolioDto=" + stockPortfolioDto +
                '}';
    }

    /* --- Getters / Setters --- */

    public StockPortfolioDto getStockPortfolioDto() {
        return stockPortfolioDto;
    }

    public void setStockPortfolioDto(StockPortfolioDto stockPortfolioDto) {
        this.stockPortfolioDto = stockPortfolioDto;
    }
}
