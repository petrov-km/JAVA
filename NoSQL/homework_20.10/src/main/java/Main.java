import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;


public class Main {

    private static MongoCollection<Document> collectionGoods;
    private static MongoCollection<Document> collectionShops;
    private static final int LESS_VALUE = 100;

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("test");

        collectionShops = database.getCollection("shops");
        collectionGoods = database.getCollection("goods");
        collectionShops.drop();
        collectionGoods.drop();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==================================================");
            System.out.println("Введите команду:");
            String input = scanner.nextLine();
            runCommand(input);

            if (input.equals("0")) { break; }
        }
    }

    public static void printInfo() {
        ArrayList<Document> infoDocuments = getInfo();
        for (int i = 0; i < infoDocuments.size(); i++) {
            Document doc = infoDocuments.get(i);
            System.out.println(
                    i + 1 + ". Магазин: " + doc.get("shopName") + "\n" +
                            "Количество товаров: " + doc.get("prodCount") + "\n" +
                            "Средняя цена товаров: " + doc.get("avgPrice")
            );
            List<Document> maxPriceProducts = doc.getList("goodsMaxPrice", Document.class);
            System.out.print("Самый дорогой товар: ");
            for (Document d : maxPriceProducts) {
                System.out.println(d.get("name") + " , " + d.get("price"));
            }
            List<Document> minPriceProducts = doc.getList("goodsMinPrice", Document.class);
            System.out.print("Самый дешевый товар: ");
            for (Document d : minPriceProducts) {
                System.out.println(d.get("name") + " , " + d.get("price"));
            }
            System.out.println("Количество товаров дешевле " + LESS_VALUE + "р - " + doc.get("goodsLessValueSize") + " :");
            List<Document> productsPriceLess100 = doc.getList("goodsPriceLessValue", Document.class);
            for (Document d : productsPriceLess100) {
                System.out.println(d.get("name") + " , " + d.get("price"));
            }
            System.out.println("------------------------------------------------------");
        }
    }

    public static ArrayList<Document> getInfo() {
        BsonDocument q1 = BsonDocument.parse("{$lookup: {" +
                "from: \"goods\", localField:\"products\", foreignField: \"name\", as:\"goods_list\"}}");
        BsonDocument q2 = BsonDocument.parse("{$unwind:{ path: \"$goods_list\"}}");
        BsonDocument q3 = BsonDocument.parse("{$group:{" +
                " _id:{name: \"$name\" }" +
                ", avgPrice:{$avg:\"$goods_list.price\"}" +
                ", prodCount: {$sum:1}" +
                ", maxPrice: {$max:\"$goods_list.price\"}" +
                ", minPrice: {$min:\"$goods_list.price\"}" +
                ", goodsList: {$addToSet: \"$goods_list\"}" +
                "}}");
        BsonDocument q4 = BsonDocument.parse("{ " +
                "$addFields: {goodsPriceLessValue : {$filter: {input:\"$goodsList\" ,as:\"good\", cond: { $lte: [ \"$$good.price\"," + LESS_VALUE + "]}}}}" +
                "}");
        BsonDocument q5 = BsonDocument.parse("{ $addFields: {goodsLessValueSize : {$size : \"$goodsPriceLessValue\"} }}");
        BsonDocument q6 = BsonDocument.parse("{ " +
                "$addFields: {goodsMaxPrice : {$filter: {input:\"$goodsList\" ,as:\"good\", cond: { $eq: [ \"$$good.price\", \"$maxPrice\" ] }}}}" +
                "}");
        BsonDocument q7 = BsonDocument.parse("{ " +
                "$addFields: {goodsMinPrice : {$filter: {input:\"$goodsList\" ,as:\"good\", cond: { $eq: [ \"$$good.price\", \"$minPrice\" ] }}}}" +
                "}");
        BsonDocument q8 = BsonDocument.parse("{ " +
                "$addFields: {shopName : \"$_id.name\" } " +
                "}");
        List<BsonDocument> queryList = Arrays.asList(q1, q2, q3, q4, q5, q6, q7, q8);

        ArrayList<Document> infoDocuments = new ArrayList<>();
        collectionShops.aggregate(queryList).forEach((Consumer<Document>) document -> {
            System.out.println(document);
            infoDocuments.add(document);
        });
        return infoDocuments;
    }

    public static void addProduct(String name, String price) {
        Document doc = new Document()
                .append("name", name)
                .append("price", Integer.parseInt(price));
        collectionGoods.insertOne(doc);
        System.out.println("товар "+name+" добавлен");
    }

    public static void addShop(String name) {
        System.out.println("ddddd");
        Document doc = new Document()
                .append("name", name);
        collectionShops.insertOne(doc);
        System.out.println("магазин "+name+" добавлен");
    }

    public static void addProductToShop(String productName, String shopName) {

        BsonDocument query1 = BsonDocument.parse("{name: \"" + shopName + "\"}");
        BsonDocument query2 = BsonDocument.parse("{$push:{products: \"" + productName + "\"}}");
        collectionShops.updateOne(query1, query2);
        System.out.println("товар "+productName+" добавлен в магазин "+ shopName);
    }

    public static void runCommand(String string) {
        String[] words = string.split(" ");
        if (words[0].matches("ДОБАВИТЬ_МАГАЗИН")) {
            addShop(words[1]);
        }
        if (words[0].matches("ДОБАВИТЬ_ТОВАР")) {
            addProduct(words[1], words[2]);
        }
        if (words[0].matches("ВЫСТАВИТЬ_ТОВАР")) {
            addProductToShop(words[1], words[2]);
        }
        if (words[0].matches("СТАТИСТИКА_ТОВАРОВ")) {
            printInfo();
        }

    }

    public static void runExample() {
        runCommand("ДОБАВИТЬ_МАГАЗИН shop_1");
        runCommand("ДОБАВИТЬ_МАГАЗИН shop_2");
        runCommand("ДОБАВИТЬ_МАГАЗИН shop_3");
        runCommand("ДОБАВИТЬ_ТОВАР prod_1 34");
        runCommand("ДОБАВИТЬ_ТОВАР prod_2 145");
        runCommand("ДОБАВИТЬ_ТОВАР prod_3 67");
        runCommand("ДОБАВИТЬ_ТОВАР prod_4 112");
        runCommand("ВЫСТАВИТЬ_ТОВАР prod_3 shop_1");
        runCommand("ВЫСТАВИТЬ_ТОВАР prod_2 shop_1");
        runCommand("ВЫСТАВИТЬ_ТОВАР prod_1 shop_2");
        runCommand("ВЫСТАВИТЬ_ТОВАР prod_4 shop_3");
        runCommand("ВЫСТАВИТЬ_ТОВАР prod_2 shop_3");
        runCommand("ВЫСТАВИТЬ_ТОВАР prod_4 shop_1");
    }
}
