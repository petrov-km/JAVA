import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Main {

  public static void main(String[] args) {
    BankAccount bankAccount1 = new BankAccount();
    bankAccount1.put(2358.3);
    bankAccount1.take(58);
    System.out.println(bankAccount1.getAmount());

    BankAccount cardAccount = new CardAccount();
    cardAccount.put(1000);
    cardAccount.take(100);
    System.out.println("карта - "+cardAccount.getAmount());
    System.out.println("--------------------------");

    BankAccount depositAccount = new DepositAccount();
    depositAccount.take(20);
    depositAccount.put(10);
    depositAccount.take(20);
    System.out.println(depositAccount.getAmount());
    System.out.println("---------------------------");

    System.out.println(bankAccount1.send(cardAccount,500));
    System.out.println("Карта  - " + cardAccount.getAmount());
    System.out.println( "Банк - " + bankAccount1.getAmount());
    System.out.println("--------------------");

    System.out.println((cardAccount.send(bankAccount1,100)));
    System.out.println("Карта  - " + cardAccount.getAmount());
    System.out.println( "Банк - " + bankAccount1.getAmount());
  }
}
