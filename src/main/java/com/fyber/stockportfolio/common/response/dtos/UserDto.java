package com.fyber.stockportfolio.common.response.dtos;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Dvir.Hashai
 */
public class UserDto implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = -6993264925481725599L;

    /* --- Members --- */

    private int id;
    private Collection<StockDto> stocks = new LinkedList<StockDto>();
    private Map<String, Integer> StocksAmount = new HashMap<>();

}
