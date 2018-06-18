package com.fyber.stockportfolio.controller;

import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.common.response.response.AbstractResponse;
import com.fyber.stockportfolio.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Dvir.Hashai
 */
@RestController
public class StockController {

    /* --- Private methods --- */

    private static final Logger logger = LoggerFactory.getLogger(StockController.class);

    /* --- Services --- */



    @Autowired
    private UserService userService;

    /* --- Public methods --- */

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public AbstractResponse register(@RequestBody UserDto userDto) {
        List response = new ArrayList();
        UserDto registeredUser = userService.UserRegister(userDto);
        if (registeredUser != null) {
            logger.info("User register successfully");
            response.add(true);
            response.add(userDto);
            response.add(null);
        } else {
            logger.error("User already exist");
            response.add(false);
            response.add("Error - User already exist");

        }

        return new AbstractResponse<>(response);
    }

    @RequestMapping(value = "/updateUserStockPortfolio", method = RequestMethod.PUT)
    public AbstractResponse updateUserStockPortfolio (@RequestBody UserDto userDto){
        List response = new ArrayList();
        UserDto updatedUser = userService.updateUserPortfolio(userDto);
        if (updatedUser != null) {
            logger.info("Update user portfolio successfully");
            response.add(true);
            response.add(updatedUser);
            response.add(null);
        } else {
            logger.error("User not exist");
            response.add(false);
            response.add("Error - User not exist");

        }

        return new AbstractResponse<>(response);
    }

    @RequestMapping(value = "/getCurrentPortfolioValue/{userId}", method = RequestMethod.GET)
    public AbstractResponse getCurrentPortfolioValue(@PathVariable(value = "userId") String userId){
        List response = new ArrayList();

        Double currentValue = userService.getCurrentPortfolioValue(userId);
        if (currentValue != null) {
            logger.info("Fetch current value successfully");
            response.add(true);
            response.add(currentValue);
            response.add(null);
        } else {
            logger.error("User not exist");
            response.add(false);
            response.add("Error - User not exist");

        }

        return new AbstractResponse<>(response);
    }
}
