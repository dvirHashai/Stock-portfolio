package com.fyber.stockportfolio.service.impl;

import com.fyber.stockportfolio.common.response.dtos.StockPortfolioDto;
import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.model.StockPortfolio;
import com.fyber.stockportfolio.model.User;
import com.fyber.stockportfolio.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @author Dvir.Hashai
 */
@Service
public class StockServiceImpl implements StockService {

    /* --- Static members --- */
    private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

    /* --- Overridden methods --- */

    @Override
    public User createUser(UserDto userDto) {
        return null;
    }

    @Override
    public StockPortfolio createStockPortfolio(StockPortfolioDto stockPortfolioDto) {
        return null;
    }

    /* --- Public methods --- */

}
