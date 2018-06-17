package com.fyber.stockportfolio.repositorys;

import com.fyber.stockportfolio.model.StockMarket;

import java.io.IOException;

/**
 * @author Dvir.Hashai
 */
public interface StockFileRepository {
    StockMarket getStockMarket() throws IOException;
}
