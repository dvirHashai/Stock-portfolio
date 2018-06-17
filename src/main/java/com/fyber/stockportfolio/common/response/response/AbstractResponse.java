package com.fyber.stockportfolio.common.response.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Can't be abstract due to serialization
 * @author Dvir.Hashai
 */
public class AbstractResponse<T> implements Serializable {

    /* --- Static members --- */

    private static final long serialVersionUID = 4918133283272918452L;

    /* --- Members --- */

    private List<T> results;

    /* --- Constructor --- */

    public AbstractResponse() {
        results = new ArrayList<T>();
    }

    public AbstractResponse(List<T> results) {
        this.results = results;
    }

    /* --- Getters / Setters --- */

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
