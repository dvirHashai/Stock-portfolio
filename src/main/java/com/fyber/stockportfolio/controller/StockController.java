package com.fyber.stockportfolio.controller;

import com.fyber.stockportfolio.common.response.dtos.StockPortfolioDto;
import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.common.response.response.AbstractResponse;
import com.fyber.stockportfolio.service.StockService;
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
    private StockService stockService;

    @Autowired
    private UserService userService;

    /* --- Public methods --- */

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public AbstractResponse register(@RequestBody UserDto userDto) {
        List response = new ArrayList();
        userService.UserRegister(userDto);

        return new AbstractResponse<>(response);
    }

    @RequestMapping(value = "/updateUserStockPortfolio", method = RequestMethod.POST)
    public AbstractResponse updateUserStockPortfolio (@RequestBody StockPortfolioDto stockPortfolioDto){
        List response = new ArrayList();

        return new AbstractResponse(response);
    }

    //TODO create api to receive list of stocks

    @RequestMapping(value = "/getCurrentPortfolioValue/{userId}", method = RequestMethod.GET)
    public AbstractResponse getCurrentPortfolioValue(@PathVariable(value = "userId") Integer userId){
        List response = new ArrayList();

        return new AbstractResponse(response);
    }
}
