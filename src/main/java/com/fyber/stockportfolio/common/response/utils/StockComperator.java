package com.fyber.stockportfolio.common.response.utils;

import com.fyber.stockportfolio.model.Stock;

import java.util.Comparator;

/**
 * @author Dvir.Hashai
 */
public class StockComperator implements Comparator<Stock> {

    @Override
    public int compare(Stock o1, Stock o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
