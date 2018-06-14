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

    private String name;
    private Double value;

    /* --- Constructors --- */

    public StockDto(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    /* --- Public methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockDto)) return false;
        StockDto stockDto = (StockDto) o;
        return Objects.equals(name, stockDto.name) &&
                Objects.equals(value, stockDto.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "StockDto{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
