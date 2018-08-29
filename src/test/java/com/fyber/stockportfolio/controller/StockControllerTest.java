package com.fyber.stockportfolio.controller;

import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertNotNull;

/**
 * @author Dvir.Hashai
 */
public class StockControllerTest {
    Gson gson = new Gson();

    @Before
    public void setUp() throws Exception {

        //UserDto upUserDto = new UserDto("12ea04de-eed4-4ce9-87d5-838b59daa0d9","1@gmail.com",new StockPortfolioDto(Arrays.asList(new StockDto("fyber")));
    }

    @Test
    public void register() {
        ClassLoader classLoader = getClass().getClassLoader();
        String jsonRequest = classLoader.getResource("jsonRequest.json").getFile();
        File file = new File(jsonRequest);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            UserDto userDto = gson.fromJson(reader, UserDto.class);
            assertNotNull(userDto.getEmail());
            assertNotNull(userDto.getStockPortfolioDto());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

        @Test
    public void updateUserStockPortfolio() {
    }

    @Test
    public void getCurrentPortfolioValue() {
    }
}