package com.fyber.stockportfolio.repositorys.impl;

import com.fyber.stockportfolio.model.Stock;
import com.fyber.stockportfolio.model.StockMarket;
import com.fyber.stockportfolio.repositorys.StockFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author Dvir.Hashai
 */
@Service
public class StockFileRepositoryImpl extends AbstractRepository implements StockFileRepository{

    /* --- Static members --- */
    private static final Logger logger = LoggerFactory.getLogger(StockFileRepositoryImpl.class);


    protected File stockFile = new File("C:\\Users\\dvirh\\IDE_Project\\IdeaProjects\\stockPortfolio\\src\\main\\java\\com\\fyber\\stockportfolio\\Files\\StockFile.json");



    /* --- Private methods --- */
    private StockMarket initStocksMarket() {
        StockMarket stockMarket = new StockMarket();
        stockMarket.getStocks().add(new ArrayList<>());
        stockMarket.getStocks().add(new ArrayList<>());
        stockMarket.getStocks().add(new ArrayList<>());
        ArrayList<Stock> stocks = stockMarket.getStocks().get(0);
        stocks.add(new Stock("fyber", 2.4, new GregorianCalendar(2018, 6, 17)));
        stocks.add(new Stock("fyber", 2.2, new GregorianCalendar(2018, 6, 16)));
        stocks.add(new Stock("fyber", 2.0, new GregorianCalendar(2018, 6, 15)));
        stocks.add(new Stock("fyber", 1.8, new GregorianCalendar(2018, 6, 14)));
        stocks.add(new Stock("fyber", 1.6, new GregorianCalendar(2018, 6, 13)));
        stocks.add(new Stock("fyber", 1.4, new GregorianCalendar(2018, 6, 12)));
        stocks.add(new Stock("fyber", 1.2, new GregorianCalendar(2018, 6, 11)));
        stockMarket.getIndexMap().put("fyber", 0);
        ArrayList<Stock> stocks1 = stockMarket.getStocks().get(1);
        stocks1.add(new Stock("verint", 2.4, new GregorianCalendar(2018, 6, 17)));
        stocks1.add(new Stock("verint", 2.2, new GregorianCalendar(2018, 6, 16)));
        stocks1.add(new Stock("verint", 2.0, new GregorianCalendar(2018, 6, 15)));
        stocks1.add(new Stock("verint", 1.8, new GregorianCalendar(2018, 6, 14)));
        stocks1.add(new Stock("verint", 1.6, new GregorianCalendar(2018, 6, 13)));
        stocks1.add(new Stock("verint", 1.4, new GregorianCalendar(2018, 6, 12)));
        stocks1.add(new Stock("verint", 1.2, new GregorianCalendar(2018, 6, 11)));
        stockMarket.getIndexMap().put("verint", 1);
        ArrayList<Stock> stocks2 = stockMarket.getStocks().get(2);
        stocks2.add(new Stock("paypal", 2.4, new GregorianCalendar(2018, 6, 17)));
        stocks2.add(new Stock("paypal", 2.2, new GregorianCalendar(2018, 6, 16)));
        stocks2.add(new Stock("paypal", 2.0, new GregorianCalendar(2018, 6, 15)));
        stocks2.add(new Stock("paypal", 1.8, new GregorianCalendar(2018, 6, 14)));
        stocks2.add(new Stock("paypal", 1.6, new GregorianCalendar(2018, 6, 13)));
        stocks2.add(new Stock("paypal", 1.4, new GregorianCalendar(2018, 6, 12)));
        stocks2.add(new Stock("paypal", 1.2, new GregorianCalendar(2018, 6, 11)));
        stockMarket.getIndexMap().put("paypal", 2);
       stockMarket.getValueMap().put("fyber",2.4);
        stockMarket.getValueMap().put("verint",2.4);
        stockMarket.getValueMap().put("paypal",2.4);


        return stockMarket;
    }



    /* --- Constructors --- */
    public StockFileRepositoryImpl() {
        try {
            this.init(stockFile, initStocksMarket());
        } catch (IOException e) {
            logger.error("can't read or write to file" + e.getMessage());
        }
    }

    /* --- Overridden methods --- */

    @Override
    public StockMarket getStockMarket() throws IOException {

            try (BufferedReader reader = new BufferedReader(new FileReader(stockFile))) {
                StockMarket stockMarket = gson.fromJson(reader, StockMarket.class);
                reader.close();

                return stockMarket;
            }


    }









}
