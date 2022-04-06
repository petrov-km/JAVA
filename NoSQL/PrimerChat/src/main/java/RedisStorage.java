import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Date;

public class RedisStorage {

    private RedissonClient redisson;
    private RKeys rKeys;
    private RScoredSortedSet<String> chatUsers;

    private final static String KEY = "USERS";

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
            System.out.println("подключено");
        } catch (RedisConnectionException Exc) {
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        chatUsers = redisson.getScoredSortedSet(KEY);
       // rKeys.delete(KEY);
    }
    public void clear(){
        chatUsers.clear();
    }

    public ArrayList<String> getUsersList (){
        return (ArrayList<String>) chatUsers.readAll();
    }


    public void go (String someName){
        if (!(someName == "")){
            Double d = chatUsers.getScore(someName);
            System.out.println("Пользователь " + someName + " оплатил платную услугу");
            chatUsers.add(1, someName);
            //chatUsers.addScore(someName,1);
            //System.out.println("ранк "+chatUsers.rank(someName));
        }
        String s = chatUsers.first();
        System.out.println(s);
        chatUsers.add(getTs(), chatUsers.first());
    }

    public void addUser(String userName){
        chatUsers.add(getTs(),userName);
    }

    private double getTs() {
        return new Date().getTime();
    }

    void shutdown() {
        redisson.shutdown();
    }
}
