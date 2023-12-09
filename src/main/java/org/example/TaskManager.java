package org.example;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final MongoCollection<Document> collection;

    public TaskManager() {
        MongoDatabase database = Connector.connect();
        this.collection = database.getCollection(Connector.getCollectionName());
    }

    public void addTask(Task task) {
        Document document = new Document("deskripsi", task.getDeskripsi())
                .append("selesai", task.isSelesai());
        collection.insertOne(document);
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        FindIterable<Document> documents = collection.find();
        for (Document document : documents) {
            Task task = new Task();
            task.setId(document.getObjectId("_id").toString());
            task.setDeskripsi(document.getString("deskripsi"));
            task.setSelesai(document.getBoolean("selesai"));
            tasks.add(task);
        }
        return tasks;
    }

    public void updateTask(Task task) {
        Document filter = new Document("_id", new org.bson.types.ObjectId(task.getId()));
        Document update = new Document("$set", new Document("deskripsi", task.getDeskripsi())
                .append("selesai", task.isSelesai()));
        collection.updateOne(filter, update);
    }

    public void deleteTask(String taskId) {
        Document filter = new Document("_id", new org.bson.types.ObjectId(taskId));
        collection.deleteOne(filter);
    }
}

