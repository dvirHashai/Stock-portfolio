package com.fyber.stockportfolio.repositorys.impl;

import com.fyber.stockportfolio.model.User;
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
    protected File file = new File("C:\\Users\\dvirh\\IDE_Project\\IdeaProjects\\stockPortfolio\\src\\main\\java\\com\\fyber\\stockportfolio\\Files\\UserFile.json");

    public UserFileRepositoryImpl() {
        try {
            this.init(file, new Users());
        } catch (IOException e) {
            logger.error("can't read or write to file" + e.getMessage());
        }
    }

    /* --- Overridden methods --- */

    @Override
    public void writeUserToFile(User user) throws IOException {
        if (user != null){
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                Users users = gson.fromJson(reader, Users.class);
                reader.close();
                BufferedWriter writer =new BufferedWriter(new FileWriter(file));
                users.getUsers().add(user);
                gson.toJson(users, writer);
                writer.close();



            }
        }


    }

    @Override
    public Users readUsersJsonFromFile() throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Users users = gson.fromJson(reader, Users.class);
            return users;
        }

    }

    /* --- Public methods --- */


}
