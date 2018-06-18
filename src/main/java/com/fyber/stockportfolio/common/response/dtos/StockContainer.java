package com.fyber.stockportfolio.common.response.dtos;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Dvir.Hashai
 */
public class StockContainer implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = -6937131262015628298L;

    /* --- Members --- */

    private String id;
    private Map<String, Integer> containerMap;
    @Email
    private String email;

    /* --- Constructors --- */

    public StockContainer() {
        this.containerMap = new HashMap<>();
    }

    /* --- Overridden methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockContainer)) return false;
        StockContainer that = (StockContainer) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(containerMap, that.containerMap) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, containerMap, email);
    }

    @Override
    public String toString() {
        return "StockContainer{" +
                "id='" + id + '\'' +
                ", containerMap=" + containerMap +
                ", email='" + email + '\'' +
                '}';
    }

    /* --- Getters / Setters --- */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Integer> getContainerMap() {
        return containerMap;
    }

    public void setContainerMap(Map<String, Integer> containerMap) {
        this.containerMap = containerMap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
