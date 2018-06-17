package com.fyber.stockportfolio.service;

import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.model.User;

import java.io.IOException;

/**
 * @author Dvir.Hashai
 */
public interface UserService {
    UserDto UserRegister (UserDto userDto);

     User setStocksValueForUser(User user) throws IOException;

    Double getCurrentPortfolioValue(String userId);

    UserDto updateUserPortfolio(UserDto userDto);
}

