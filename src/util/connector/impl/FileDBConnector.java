package util.connector.impl;

import util.connector.Connector;

import java.io.File;

public class FileDBConnector extends Connector {
    public FileDBConnector(String dbPath) {
        this.uri = dbPath;
    }

    public FileDBConnector() {
        this("db.csv");
    }

    @Override
    public void connect() {
        try {
            File dbFile = new File(uri);

            if (dbFile.createNewFile()) System.out.println("DB created");
            else System.out.println("DB already exists");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
