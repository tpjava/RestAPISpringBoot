package com.perrin.tony.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by tonyperrin on 05/01/2014.
 */
public class Utils {
    private static DatabaseHolder databaseProperties;
    private Utils() {/*no instance of this class can be instantiated.*/}

    public static DatabaseHolder getDatabaseConfig() {
        try {
            if(databaseProperties == null) {
                Properties properties = new Properties();
                InputStream stream = Utils.class.getClassLoader().getResourceAsStream("databaseConfiguration.config");
                properties.load(stream);
                databaseProperties = new DatabaseHolder(properties);
            }
            return databaseProperties;
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot open databaseConfiguration.config");
        }
    }
}
