import java.util.ArrayList;
import java.util.Random;

public class RedisTest {

    private static final int SLEEP = 1;
    private static Random random = new Random();
    private static final int USERS_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();
        redis.clear();

        String userName;
        for (int i = 1; i < USERS_COUNT+1; i++) {
            userName = "user" + i;
            redis.addUser(userName);
        }

        for (; ; ) {
            String randomUserName = "";
            ArrayList<String> usersList = new ArrayList<>(redis.getUsersList());
            Boolean servicePayment = (Math.random() < 0.80) ? false : true;
            if (servicePayment) {
                int randomUserNumber = random.nextInt(usersList.size());
                randomUserName = usersList.get(randomUserNumber);
            }
            redis.go(randomUserName);
            Thread.sleep(1000);
        }
        // redis.shutdown();
    }
}
