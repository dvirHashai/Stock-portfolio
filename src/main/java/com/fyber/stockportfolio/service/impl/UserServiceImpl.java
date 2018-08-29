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
import java.util.*;


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
            if (user.getId() != null) {

                try {
                    Users usersFromFile = userFileRepository.readUsersJsonFromFile();
                    if (usersFromFile != null && usersFromFile.getUsers().size() > 0) {
                        logger.info("UserFileRepository --> UserRegister --> fetch users from file");
                        Optional<User> matchingEmail = usersFromFile.getUsers().stream().
                                filter(p -> p.getEmail().equals(user.getEmail())).
                                findFirst();
                        User user1 = matchingEmail.orElse(null);
                        if (user1 == null) {
                            User updatedUser = setStocksValueForUser(user);
                            usersFromFile.getUsers().add(updatedUser);
                            userFileRepository.writeUserToFile(usersFromFile);
                            logger.info("UserFileRepository --> UserRegister --> write user to file");
                            return Converters.convertUserToUserDto(updatedUser);
                        } else {
                            logger.error("UserFileRepository --> UserRegister --> User all ready exist");
                        }

                    } else {
                        logger.info("UserFileRepository --> UserRegister --> user list is empty");
                        User updatedUser = setStocksValueForUser(user);
                        usersFromFile.getUsers().add(updatedUser);
                        userFileRepository.writeUserToFile(usersFromFile);
                        logger.info("UserFileRepository --> UserRegister --> write user to file");
                        return Converters.convertUserToUserDto(updatedUser);
                    }
                } catch (IOException e) {
                    logger.error("UserFileRepository --> UserRegister --> The user is not saved " + e.getMessage());
                }catch (RuntimeException e){
                    logger.error("UserFileRepository --> UserRegister --> " + e.getMessage());
                }
            } else {
                logger.error("UserFileRepository --> UserRegister --> user UUID is not valid ");
            }

        }
        return null;
    }

    @Override
    public User setStocksValueForUser(User user) throws IOException {
        StockMarket stockMarket = stockFileRepository.getStockMarket();
        if (stockMarket != null) {
            logger.info("UserFileRepository --> UserRegister --> fetch stocks from file");
            List<Stock> stocks = user.getStockPortfolio().getStocks();
            try {
                stocks.forEach(stock -> stock.setValue(stockMarket.getValueMap().get(stock.getName())));
                stocks.forEach(stock -> stock.setDate(stockMarket.getStocks().get(stockMarket.getIndexMap().get(stock.getName())).get(0).getDate()));

            } catch (RuntimeException e) {
                logger.error("UserFileRepository --> UserRegister --> " + e.getMessage());
            }
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
            logger.error("UserServiceImpl --> getCurrentPortfolioValue --> can't read users from file" + e.getMessage());
        }catch (RuntimeException e){
            logger.error("UserServiceImpl --> getCurrentPortfolioValue --> " + e.getMessage());
        }
        return null;
    }

    @Override
    public UserDto updateUserPortfolio(UserDto userDto) {
        try {
            User user1 = Converters.convertUserDtoToUser(userDto);
            if (user1.getId() != null) {
                logger.info("UserServiceImpl --> updateUserPortfolio --> UUID is valid");
                Users users = userFileRepository.readUsersJsonFromFile();
                if (users != null) {
                    logger.info("UserServiceImpl --> updateUserPortfolio --> users fetch successfully from file");
                    User user = users.getUsers().stream().filter(p -> p.getId().equals(user1.getId())).findFirst().get();
                    if (user != null) {
                        logger.info("UserServiceImpl --> updateUserPortfolio --> user found");
                        if (user1.getStockPortfolio().getStocks() != null && user1.getStockPortfolio().getStocks().size() > 0) {
                            user.setStockPortfolio(user1.getStockPortfolio());
                            User updatedUser = setStocksValueForUser(user);
                            Users usersToSave = updateUsers(users, updatedUser);
                            userFileRepository.writeUserToFile(usersToSave);
                            return Converters.convertUserToUserDto(updatedUser);
                        } else if (!user1.getStockPortfolio().getStocksAmountMap().isEmpty()) {
                            User user2 = updateUserPortfolioByMap(user, user1);
                            User updatedUser = setStocksValueForUser(user2);
                            Users usersToSave = updateUsers(users, updatedUser);
                            userFileRepository.writeUserToFile(usersToSave);
                            return Converters.convertUserToUserDto(updatedUser);
                        }
                    } else {
                        logger.error("UserServiceImpl --> updateUserPortfolio --> user not found");
                    }


                } else {
                    logger.error("UserServiceImpl --> updateUserPortfolio --> users not read successfully from file");
                }


            } else {
                logger.error("UserServiceImpl --> updateUserPortfolio --> UUID is not valid");
            }

        } catch (IOException e) {
            logger.error("UserServiceImpl --> updateUserPortfolio --> can't read users from file");
        } catch (IllegalArgumentException e) {
            logger.error("UserServiceImpl --> updateUserPortfolio --> " + e.getMessage());
        }catch (RuntimeException e){
            logger.error("UserServiceImpl --> updateUserPortfolio --> " + e.getMessage());
        }
        return null;
    }

    @Override
    public Users updateUsers(Users users, User updatedUser) {
        if (users != null && users.getUsers().size() > 0 && updatedUser != null) {
            try {
                User user = users.getUsers().stream().filter(user1 -> user1.getId().equals(updatedUser.getId())).findFirst().get();
                user.setStockPortfolio(updatedUser.getStockPortfolio());
            } catch (RuntimeException e) {
                logger.error("UserFileRepository --> UserRegister --> " + e.getMessage());
            }

        }
        return users;
    }

    @Override
    public Double calculatedCurrentValue(User user) throws IOException {
        User user1 = setStocksValueForUser(user);
        List<Stock> stocks = user1.getStockPortfolio().getStocks();
        try {
            double currentValue = stocks.stream().mapToDouble(stock -> (
                    stock.getValue() * user1.getStockPortfolio().getStocksAmountMap().get(stock.getName()))).sum();

            return currentValue;

        } catch (RuntimeException e) {
            logger.error("UserFileRepository --> calculatedCurrentValue --> " + e.getMessage());
        }
        return null;
    }
    @Override
    public User updateUserPortfolioByMap(User oldUser, User newUser) {
        Map<String, Double> newUserMap = newUser.getStockPortfolio().getStocksAmountMap();
        for (Map.Entry<String, Double> entry : newUserMap.entrySet()) {
            if (oldUser.getStockPortfolio().getStocksAmountMap().containsKey(entry.getKey())) {
                Double stockValue = oldUser.getStockPortfolio().getStocksAmountMap().get(entry.getKey());
                if (stockValue != entry.getValue()) {
                    oldUser.getStockPortfolio().getStocksAmountMap().put(entry.getKey(), entry.getValue());
                }
            } else {
                oldUser.getStockPortfolio().getStocksAmountMap().put(entry.getKey(), entry.getValue());
                oldUser.getStockPortfolio().getStocks().add(new Stock(entry.getKey(), null, null));

            }
        }
        return oldUser;
    }
}
