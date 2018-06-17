package com.fyber.stockportfolio.service;

import com.fyber.stockportfolio.common.response.dtos.StockPortfolioDto;
import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.model.StockPortfolio;
import com.fyber.stockportfolio.model.User;

/**
 * @author Dvir.Hashai
 */
public interface StockService {

    User createUser(UserDto userDto);

    StockPortfolio createStockPortfolio(StockPortfolioDto stockPortfolioDto);

    /*Stock createStock(S)*/

}
