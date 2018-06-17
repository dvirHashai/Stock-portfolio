package com.fyber.stockportfolio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Dvir.Hashai
 */
public class Users implements Serializable {

    /* --- Static members --- */
    private static final long serialVersionUID = 4305631016981562888L;

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
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
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

    /* --- Getters / Setters --- */

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
