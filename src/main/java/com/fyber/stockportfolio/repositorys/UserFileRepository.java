package com.fyber.stockportfolio.repositorys;

import com.fyber.stockportfolio.model.User;
import com.fyber.stockportfolio.model.Users;

import java.io.IOException;

/**
 * @author Dvir.Hashai
 */
public interface UserFileRepository {

    void writeUserToFile(User user) throws IOException;

     Users readUsersJsonFromFile() throws IOException;

}