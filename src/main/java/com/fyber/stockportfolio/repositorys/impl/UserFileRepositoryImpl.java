package com.fyber.stockportfolio.repositorys.impl;

import com.fyber.stockportfolio.model.Users;
import com.fyber.stockportfolio.repositorys.UserFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;


/**
 * @author Dvir.Hashai
 */
@Service
public class UserFileRepositoryImpl extends AbstractRepository implements UserFileRepository {

    /* --- Static members --- */
    private static final Logger logger = LoggerFactory.getLogger(UserFileRepositoryImpl.class);

    /*--- Protected  method ---*/

   protected File file = new File(".\\userFile.json");

    public UserFileRepositoryImpl() {
        try {
            if (!file.exists()) {
                file.getParentFile().mkdir();
                file.createNewFile();
            }
            this.init(file, new Users());
        } catch (IOException e) {
            logger.error("can't read or write to file" + e.getMessage());
        }


    }

    /* --- Overridden methods --- */

    @Override
    public void writeUserToFile(Users users) throws IOException {
        if (users != null && users.getUsers().size() > 0) {
                file.delete();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                gson.toJson(users, writer);
                writer.close();
        }
    }

    @Override
    public Users readUsersJsonFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Users users = gson.fromJson(reader, Users.class);
            return users;
        }
    }
}
