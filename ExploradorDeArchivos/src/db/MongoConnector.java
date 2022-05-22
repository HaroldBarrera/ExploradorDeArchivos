package db;

import com.mongodb.DB;
import com.mongodb.MongoClientException;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnector {

    String uri = "mongodb://localhost:27017/?maxLifeTimeMS=0";
    String db = "sistemasoperativos";

    MongoDatabase database;
    MongoClient mongo;

    public MongoConnector() {
        mongo = Conectar();
        database = BaseDeDatos();
    }

    private MongoClient Conectar(){
        MongoDatabase database;
        MongoClient mongoClient = MongoClients.create(uri);
        if (mongoClient != null){
            database = mongoClient.getDatabase(db);
            System.out.println("Conectado a la base de datos: " + database.getName());
        }else{
            System.err.println("An error occurred while attempting to run a command");
        }
        /*try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase(db);
            try {
                //Bson command = new BsonDocument("ping", new BsonInt64(1));
                //Document commandResult = database.runCommand(command);
                System.out.println("Conectado a la base de datos: " + database.getName());
            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }
        }*/
        return mongoClient;
    }

    private MongoDatabase BaseDeDatos(){
        MongoDatabase database = mongo.getDatabase(db);
        return database;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoClient getMongo() {
        return mongo;
    }
}
