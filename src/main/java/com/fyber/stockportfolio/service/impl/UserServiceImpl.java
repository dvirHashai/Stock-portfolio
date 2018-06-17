package com.fyber.stockportfolio.service.impl;

import com.fyber.stockportfolio.common.response.converters.Converters;
import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.model.Stock;
import com.fyber.stockportfolio.model.StockMarket;
import com.fyber.stockportfolio.model.User;
import com.fyber.stockportfolio.model.Users;
import com.fyber.stockportfolio.repositorys.UserFileRepository;
import com.fyber.stockportfolio.repositorys.impl.StockFileRepositoryImpl;
import com.fyber.stockportfolio.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * @author Dvir.Hashai
 */
@Service
public class UserServiceImpl implements UserService {

    /* --- Static members --- */
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /* --- Private methods --- */

    @Autowired
    private StockFileRepositoryImpl stockFileRepository;

    @Autowired
    private UserFileRepository userFileRepository;

    /* --- Overridden methods --- */
    @Override
    public UserDto UserRegister(UserDto userDto) {
        if (userDto != null) {
            logger.info("UserFileRepository --> UserRegister --> register new user");
            User user = Converters.convertUserDtoToUser(userDto);
            try {
                Users usersFromFile = userFileRepository.readUsersJsonFromFile();
                logger.info("UserFileRepository --> UserRegister --> fetch users from file");
                Optional<User> matchingEmail = usersFromFile.getUsers().stream().
                        filter(p -> p.getEmail().equals(user.getEmail())).
                        findFirst();
                User user1 = matchingEmail.orElse(null);
                if (user1 == null) {
                    User updatedUser = setStocksValueForUser(user);
                    userFileRepository.writeUserToFile(updatedUser);
                    logger.info("UserFileRepository --> UserRegister --> write user to file");

                    return Converters.convertUserToUserDto(updatedUser);


                } else {
                    logger.error("UserFileRepository --> UserRegister --> User all ready exist");
                }

            } catch (IOException e) {
                logger.error("The user is not saved " + e.getMessage());
            }
        }
        return null;
    }

    /* --- Public methods --- */

    @Override
    public User setStocksValueForUser(User user) throws IOException {
        StockMarket stockMarket = stockFileRepository.getStockMarket();
        if (stockMarket != null) {
            logger.info("UserFileRepository --> UserRegister --> fetch stocks from file");
            List<Stock> stocks = user.getStockPortfolio().getStocks();
            stocks.forEach(stock -> stock.setValue(stockMarket.getValueMap().get(stock.getName())));
            stocks.forEach(stock -> stock.setDate(stockMarket.getStocks().get(stockMarket.getIndexMap().get(stock.getName())).get(0).getDate()));
            user.getStockPortfolio().setStocks(stocks);
            return user;
        }
        return null;

    }

    @Override
    public Double getCurrentPortfolioValue(String userId) {
        try {
            Users users = userFileRepository.readUsersJsonFromFile();
            UUID uuid = UUID.fromString(userId);
            User firstUser = users.getUsers().stream().filter(user -> user.getId().equals(uuid)).findFirst().get();


            if (firstUser != null) {
                return calculatedCurrentValue(firstUser);
            }

        } catch (IOException e) {
            logger.error("UserServiceImpl --> getCurrentPortfolioValue --> can't read users from file");
        }
        return null;
    }

    public Double calculatedCurrentValue(User user) throws IOException {
        User user1 = setStocksValueForUser(user);
        List<Stock> stocks = user1.getStockPortfolio().getStocks();

        double currentValue = stocks.stream().mapToDouble(stock -> (
                stock.getValue() * user1.getStockPortfolio().getStocksAmountMap().get(stock.getName()))).sum();
        return currentValue;
    }
}
