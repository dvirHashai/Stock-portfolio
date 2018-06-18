package com.fyber.stockportfolio.service;

import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.model.User;
import com.fyber.stockportfolio.model.Users;

import java.io.IOException;

/**
 * @author Dvir.Hashai
 */
public interface UserService {
    UserDto UserRegister (UserDto userDto);

     User setStocksValueForUser(User user) throws IOException;

    Double getCurrentPortfolioValue(String userId);

    UserDto updateUserPortfolio(UserDto userDto);

    Users updateUsers(Users users, User updatedUser);

    Double calculatedCurrentValue(User user) throws IOException;

    User updateUserPortfolioByMap(User oldUser, User newUser);
}

