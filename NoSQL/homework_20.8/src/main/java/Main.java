import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    private static final String PATH = "mongo.csv";
    private static int maxAge;

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("students");
        collection.drop();

        List<String> fileLines = new ArrayList<>();
        try {
            fileLines = Files.readAllLines(Paths.get(PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : fileLines) {
            Document secondDocument = Document.parse(getStringJsonToCreateStudent(line));
            collection.insertOne(secondDocument);

           // System.out.println("----------------------------");
        }
        System.out.println("Общее количество студентов:");
        System.out.println(collection.countDocuments());

        System.out.println("==============================================");
        System.out.println("Количество студентов старше 40 лет:");
        BsonDocument query = BsonDocument.parse("{age: {$gt: 40}}");
        System.out.println(collection.countDocuments(query));

        System.out.println("===============================================");
        System.out.println("Имя самого молодого студента:");
        BsonDocument queryMinAge = BsonDocument.parse("{age: 1}");
        collection.find().sort(queryMinAge).limit(1).forEach((Consumer<Document>) document -> {
            System.out.println(document.get("name") + ", возраст:" + document.get("age"));
        });

        System.out.println("================================================");
        System.out.println("Список курсов самого старого студента(ов):");
        BsonDocument queryMaxAge1 = BsonDocument.parse("{age: -1}");

        collection.find().sort(queryMaxAge1).limit(1).forEach((Consumer<Document>) document -> {
            maxAge = document.getInteger("age");
        });
        BsonDocument queryMaxAge2= BsonDocument.parse("{age: {$eq:"+maxAge+"}}");
        collection.find(queryMaxAge2).forEach((Consumer<Document>) document -> {
            System.out.println(document.get("name") + ", возраст:" + document.get("age"));
            ArrayList<String> courses =new ArrayList<>( document.getList("courses",String.class));
            for (String course: courses){
                System.out.println(course);
            }
        });
    }

    public static String getStringJsonToCreateStudent(String line) {
        line = line.replaceAll("\"", "");
        line.trim();
        String[] elements = line.split(",");
        StringBuilder coursesArrayForCurrentStudent = new StringBuilder("[");
        for (int i = 2; i < elements.length; i++) {
            coursesArrayForCurrentStudent.append("\"" + elements[i] + "\"").append(",");
        }
        coursesArrayForCurrentStudent.deleteCharAt(coursesArrayForCurrentStudent.length() - 1);
        coursesArrayForCurrentStudent.append("]");

        StringBuilder stringJson = new StringBuilder("{");
        stringJson.append("name:" + "\"" + elements[0] + "\"" + "," +
                "age:" + Integer.parseInt(elements[1].trim()) + "," +
                "courses:" + coursesArrayForCurrentStudent)
                .append("}");
        return stringJson.toString();
    }
}
