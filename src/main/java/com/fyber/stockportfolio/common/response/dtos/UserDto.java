package com.fyber.stockportfolio.common.response.dtos;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Dvir.Hashai
 */
public class UserDto implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = -6993264925481725599L;

    /* --- Members --- */

    private String id;
    @Email
    private String email;
    private StockPortfolioDto stockPortfolioDto;

    /* --- Constructors --- */

    public UserDto() {

    }

    public UserDto(String id, @Email String email, StockPortfolioDto stockPortfolioDto) {
        this.id = id;
        this.email = email;
        this.stockPortfolioDto = stockPortfolioDto;
    }
    /* --- Public methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) &&
                Objects.equals(email, userDto.email) &&
                Objects.equals(stockPortfolioDto, userDto.stockPortfolioDto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, stockPortfolioDto);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", stockPortfolioDto=" + stockPortfolioDto +
                '}';
    }

    /* --- Getters / Setters --- */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StockPortfolioDto getStockPortfolioDto() {
        return stockPortfolioDto;
    }

    public void setStockPortfolioDto(StockPortfolioDto stockPortfolioDto) {
        this.stockPortfolioDto = stockPortfolioDto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
