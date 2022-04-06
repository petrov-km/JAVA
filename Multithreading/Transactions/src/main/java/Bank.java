import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Bank {

    private static final Random random = new Random();
    private static Map<String, Account> accounts = new HashMap<>();
    public static Vector<String> blockedAccounts = new Vector<>();

    public static void main(String[] args) {
        createAccounts();
        System.out.println("---------------------------------------");
        for (String n : accounts.keySet()) {
            System.out.println(n + "___" + accounts.get(n).getMoney());
        }
        System.out.println("сумма в начале " + getSumAllAccounts());
        runThreadsOfTransfers();
    }

    public static void createAccounts() {
        for (int i = 1; i < 11; i++) {
            Account acc = new Account(100000/*(int)(Math.random()*5000)*/, Integer.toString(i));
            accounts.put(acc.getAccNumber(), acc);
        }
    }

    public static void runThreadsOfTransfers() {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            threads.add(new Thread(() -> {
                String n1 = Integer.toString((int) (Math.random() * 10 + 1));
                String n2 = Integer.toString((int) (Math.random() * 10 + 1));
                long summa = (long) (Math.random() * 30000 + 30000);
                Bank.transfer(n1, n2, summa);
            }));
        }
        threads.forEach(Thread::start);
    }

    public static synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public static void transfer(String fromAccountNum, String toAccountNum, long amount) {
        if (!transferIsAvailable(fromAccountNum, toAccountNum, amount)) {
            System.out.println(("Опреация некорректна"));
            return;
        }
        Account fromAcc = accounts.get(fromAccountNum);
        Account toAcc = accounts.get(toAccountNum);
         if (amount > 50000) {
            try {
                if (isFraud(fromAccountNum, toAccountNum, amount)) {
                    blockedAccounts.add(fromAccountNum);
                    blockedAccounts.add(toAccountNum);
                    System.out.println("Мошенничество");
                    return;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("                   перевод более 500000");
        }

        if (fromAcc.getMoney() > toAcc.getMoney()) {
            synchronized (fromAcc) {
                synchronized (toAcc) {
                    doTransfer(fromAcc, toAcc, amount);
                }
            }
        } else {
            synchronized (toAcc) {
                synchronized (fromAcc) {
                    doTransfer(fromAcc, toAcc, amount);
                }
            }
        }
                System.out.println("перевод выполнен");
                System.out.println(getSumAllAccounts());
                System.out.println("кол-во заблокированных - " + blockedAccounts.size());

    }
    public static void doTransfer(Account fromAcc, Account toAcc, long amount){
        fromAcc.setMoney(fromAcc.getMoney() - amount);
        accounts.put(fromAcc.getAccNumber(), fromAcc);

        toAcc.setMoney(toAcc.getMoney() + amount);
        accounts.put(toAcc.getAccNumber(), toAcc);
    }

    public static synchronized boolean transferIsAvailable(String fromAccountNum, String toAccountNum, long amount) {
        return (accounts.containsKey(fromAccountNum) && accounts.containsKey(toAccountNum)
                && getBalance(fromAccountNum) >= amount
                && !blockedAccounts.contains(fromAccountNum)
                && !blockedAccounts.contains(toAccountNum));
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public static synchronized long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public static synchronized long getSumAllAccounts() {
        Set<String> accountsSet = accounts.keySet();
        long totalCount = 0;
        for (String number : accountsSet) {
            totalCount += getBalance(number);
        }
        return totalCount;
    }
}
