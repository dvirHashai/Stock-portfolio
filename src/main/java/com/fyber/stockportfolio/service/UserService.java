package com.fyber.stockportfolio.service;

import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.model.StockMarket;
import com.fyber.stockportfolio.model.User;

/**
 * @author Dvir.Hashai
 */
public interface UserService {
    UserDto UserRegister (UserDto userDto);

     User setStocksValueForUser(User user, StockMarket stockMarket);
}
