package com.fyber.stockportfolio.service.impl;

import com.fyber.stockportfolio.common.response.converters.Converters;
import com.fyber.stockportfolio.common.response.dtos.UserDto;
import com.fyber.stockportfolio.model.User;
import com.fyber.stockportfolio.repositorys.UserFileRepository;
import com.fyber.stockportfolio.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * @author Dvir.Hashai
 */
@Service
public class UserServiceImpl implements UserService {

    /* --- Static members --- */
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /* --- Private methods --- */



    @Autowired
    private UserFileRepository userFileRepository;

    /* --- Overridden methods --- */
    @Override
    public void UserRegister(UserDto userDto) {
        User user = Converters.convertUserDtoToUser(userDto);
        try {
            userFileRepository.writeUserToFile(user);
        } catch (IOException e) {
            logger.error("The user is not saved " + e.getMessage() );
        }


    }
}
