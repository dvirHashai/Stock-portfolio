package com.fyber.stockportfolio.common.response.converters;

import com.fyber.stockportfolio.common.response.dtos.StockDto;
import com.fyber.stockportfolio.common.response.dtos.StockPortfolioDto;
import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.model.Stock;
import com.fyber.stockportfolio.model.StockPortfolio;
import com.fyber.stockportfolio.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dvir.Hashai
 */
@Component
public class Converters {

    /* --- Public methods --- */

     public static User convertUserDtoToUser(UserDto userDto){
         User user = new User();
         user.setStockPortfolio(convertDtoToStockPortFolio(userDto.getStockPortfolioDto()));
         user.setEmail(userDto.getEmail());
        return user;
    }

    public static UserDto convertUserToUserDto(User user){
         UserDto userDto = new UserDto();
         userDto.setStockPortfolioDto(convertStockPortfolioToDto(user.getStockPortfolio()));
         userDto.setEmail(user.getEmail());

         return userDto;
    }
    public static StockPortfolioDto convertStockPortfolioToDto(StockPortfolio stockPortfolio){

        StockPortfolioDto stockPortfolioDto = new StockPortfolioDto();
         stockPortfolioDto.setStocksDto(convertStockListToStockListDto(stockPortfolio.getStocks()));
         stockPortfolioDto.setStocksAmountMapDto(stockPortfolio.getStocksAmountMap());
         return stockPortfolioDto;
    }

    public static StockPortfolio convertDtoToStockPortFolio(StockPortfolioDto stockPortfolioDto){
         StockPortfolio stockPortfolio = new StockPortfolio();
         stockPortfolio.setStocks(convertStockListDtoToStockList(stockPortfolioDto.getStocksDto()));
         stockPortfolio.setStocksAmountMap(stockPortfolioDto.getStocksAmountMapDto());
         return stockPortfolio;
    }

    public static StockDto convertStockToStockDto(Stock stock){
         StockDto stockDto = new StockDto();
        stockDto.setNameDto(stock.getName());



         return stockDto;
    }

    public static List<StockDto>  convertStockListToStockListDto(List<Stock> stocks){
        List<StockDto> stockDtos = new ArrayList<>();
        for (Stock stock: stocks) {
            stockDtos.add(convertStockToStockDto(stock));
        }

        return stockDtos;
    }

    public static Stock convertStockDtoToStock(StockDto stockDto){
         Stock stock = new Stock();
         stock.setName(stockDto.getNameDto());
         stock.setValue(null);
         stock.setDate(null);
         return stock;
    }

    public static List<Stock> convertStockListDtoToStockList(List<StockDto> stockDtos){
         List<Stock> stocks = new ArrayList<>();
        for (StockDto stockDto : stockDtos) {
            stocks.add(convertStockDtoToStock(stockDto));
        }
        return stocks;

    }





}
