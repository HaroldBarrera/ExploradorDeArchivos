package db;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class usuarioSchema {
    /*MongoDatabase database = new MongoConnector().Conectar();
    MongoCollection collection = database.getCollection("usuarios");*/
    MongoDatabase database;
    MongoCollection collection;

    MongoConnector conexion = new MongoConnector();

    //Constructor)
    public usuarioSchema() {
        database = conexion.getDatabase();
        collection = database.getCollection("usuarios");
    }

    //CRUD
    public void create(String username, String password) {
        Document nuevousuario = new Document();

        nuevousuario.append("_id", new ObjectId())
                .append("username", username)
                .append("password", password);

        try {
            collection.insertOne(nuevousuario);
            System.out.println("Usuario creado con exito. \n");
        } catch (MongoWriteException mwe) {
            if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                System.out.println("Document with that id already exists");
            }
        }
    }

    public void read(String username){
        Bson projectionFields = Projections.fields(
                Projections.include("username", "password"),
                Projections.excludeId());

        Document doc = (Document) collection.find(eq("username", username))
                .projection(projectionFields)
                .first();

        if (doc == null) {
            System.out.println("No results found.");
        } else {
            System.out.println(doc.toJson());
        }
    }

    public ArrayList<Object> readAll(){
        MongoCursor cursor = collection.find().iterator();
        ArrayList<Object> listacuentas = new ArrayList<>();
        try {
            while (cursor.hasNext()) {
                Object usuarioactual = cursor.next();
                System.out.println(usuarioactual.toString());
                listacuentas.add(usuarioactual);
            }

        } finally {
            cursor.close();
        }
        if (listacuentas.isEmpty()){
            System.out.println("LA LISTA ESTA VACIA...");
            return null;
        }else{
            System.out.println("TAMAÑO DE LA LISTA: " + listacuentas.size());
            return listacuentas;
        }
    }

    public void update(String username, String nuevouser, String nuevapass){
        Document query = new Document().append("username",  username);
        Bson updates = Updates.combine(
                Updates.set("username", nuevouser),
                Updates.set("password", nuevapass));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = collection.updateOne(query, updates, options);
            System.out.println("Modified document count: " + result.getModifiedCount());
            System.out.println("Upserted id: " + result.getUpsertedId()); // only contains a value when an upsert is performed
        } catch (MongoException me) {
            System.err.println("Unable to update due to an error: " + me);
        }
    }

    public void delete(String username){
        Bson query = eq("username", username);
        try {
            DeleteResult result = collection.deleteOne(query);
            System.out.println("Deleted document count: " + result.getDeletedCount());
        } catch (MongoException me) {
            System.err.println("Unable to delete due to an error: " + me);
        }
    }
}
