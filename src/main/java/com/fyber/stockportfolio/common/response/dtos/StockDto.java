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
    private Double valueDto;

    /* --- Constructors --- */

    public StockDto() {
    }

    public StockDto(String name, Double value) {
        this.nameDto = name;
        this.valueDto = value;
    }


    /* --- Public methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockDto)) return false;
        StockDto stockDto = (StockDto) o;
        return Objects.equals(nameDto, stockDto.nameDto) &&
                Objects.equals(valueDto, stockDto.valueDto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameDto, valueDto);
    }

    @Override
    public String toString() {
        return "StockDto{" +
                "name='" + nameDto + '\'' +
                ", value=" + valueDto +
                '}';
    }

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public Double getValueDto() {
        return valueDto;
    }

    public void setValueDto(Double valueDto) {
        this.valueDto = valueDto;
    }
}
