package com.perrin.tony.impl;

import java.util.Properties;

/**
 * Created by tonyperrin on 05/01/2014.
 */
public class DatabaseHolder {
    private final String IP;
    private final int port;
    private final String name;
    private final String collection;

    public DatabaseHolder(Properties properties) {
        this.IP = properties.getProperty("databaseIP");
        this.port = Integer.parseInt(properties.getProperty("databasePort"));
        this.name = properties.getProperty("databaseName");
        this.collection = properties.getProperty("databaseCollection");
    }

    public String getIP() {
        return IP;
    }

    public int getPort() {
        return port;
    }

    public String getName() {
        return name;
    }

    public String getCollection() {
        return collection;
    }
}
