package com.fyber.stockportfolio.common.response.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Can't be abstract due to serialization
 * @author Dvir.Hashai
 */
public class AbstractResponse<T> implements Serializable {

    /* --- Static members --- */

    private static final long serialVersionUID = 4918133283272918452L;

    /* --- Members --- */

    private Collection<T> results;

    /* --- Constructor --- */

    public AbstractResponse() {
        results = new ArrayList<T>();
    }

    public AbstractResponse(Collection<T> results) {
        this.results = results;
    }

    /* --- Getters / Setters --- */

    public Collection<T> getResults() {
        return results;
    }

    public void setResults(Collection<T> results) {
        this.results = results;
    }
}
