package com.fyber.stockportfolio.controller;

import com.fyber.stockportfolio.common.response.dtos.StockPortfolioDto;
import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.common.response.response.AbstractResponse;
import com.fyber.stockportfolio.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;


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

    /* --- Public methods --- */

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public AbstractResponse register(@RequestBody UserDto userDto) {
        Collection response = new ArrayList();
        //registerNew/existingUser

        return new AbstractResponse<>(response);
    }

    @RequestMapping(value = "/updateUserStockPortfolio", method = RequestMethod.POST)
    public AbstractResponse updateUserStockPortfolio (@RequestBody StockPortfolioDto stockPortfolioDto){
        Collection response = new ArrayList();

        return new AbstractResponse(response);
    }

    @RequestMapping(value = "/getCurrentPortfolioValue/{userId}", method = RequestMethod.GET)
    public AbstractResponse getCurrentPortfolioValue(@PathVariable(value = "userId") Integer userId){
        Collection response = new ArrayList();

        return new AbstractResponse(response);
    }
}
