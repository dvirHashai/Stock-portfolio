package com.fyber.stockportfolio.controller;

import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.common.response.response.AbstractResponse;
import com.fyber.stockportfolio.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        public AbstractResponse register(@RequestBody UserDto userDto){
            Collection response = new ArrayList();


        return new AbstractResponse<>(response);
        }

}
