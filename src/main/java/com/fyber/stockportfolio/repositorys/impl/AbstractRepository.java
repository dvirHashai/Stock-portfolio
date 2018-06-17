package com.fyber.stockportfolio.repositorys.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/**
 * @author Dvir.Hashai
 */
public class AbstractRepository {

    /*--- Protected  method ---*/
    protected GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
    protected Gson gson = builder.create();


    /* --- Private methods --- */
    protected void init(File file, Object Object) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            if (reader.readLine() == null) {
                reader.close();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                gson.toJson(Object, writer);
                writer.close();
            }


        }
    }
}
