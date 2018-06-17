package com.fyber.stockportfolio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Dvir.Hashai
 */
public class Users implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = 6096911521444225655L;

    /* --- Private methods --- */
    @SerializedName("USERS")
    private List<User> users ;

    /* --- Constructors --- */

    public Users() {
        this.users = new LinkedList<>();
    }

    public Users(List<User> users) {
        this.users = users;
    }

    /* --- Overridden methods --- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return Objects.equals(this.users, users.users);
    }

    @Override
    public int hashCode() {

        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }

    /* --- Public methods --- */

    /* --- Getters / Setters --- */

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
