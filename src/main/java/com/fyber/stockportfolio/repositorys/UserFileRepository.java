package com.fyber.stockportfolio.repositorys;

import com.fyber.stockportfolio.model.User;

import java.io.IOException;

/**
 * @author Dvir.Hashai
 */
public interface UserFileRepository {

    User readUsersJsonFromFile(Integer id);

    void writeUserToFile(User user) throws IOException;






}
