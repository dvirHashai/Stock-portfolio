package com.fyber.stockportfolio.common.response.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Dvir.Hashai
 */
public class StockDto implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = 6955721390101524361L;

    /* --- Private methods --- */

    private String nameDto;


    /* --- Constructors --- */

    public StockDto() {
    }

    public StockDto(String name) {
        this.nameDto = name;

    }


    /* --- Public methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockDto)) return false;
        StockDto stockDto = (StockDto) o;
        return Objects.equals(nameDto, stockDto.nameDto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameDto);
    }

    @Override
    public String toString() {
        return "StockDto{" +
                "nameDto='" + nameDto + '\'' +
                '}';
    }

    /* --- Getters / Setters --- */

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }
}
