package org.example;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Connector {
    private static final String DATABASE_NAME = "todo";
    private static final String COLLECTION_NAME = "1";

    public static MongoDatabase connect() {
        MongoClient mongoClient = MongoClients.create();
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }
}
