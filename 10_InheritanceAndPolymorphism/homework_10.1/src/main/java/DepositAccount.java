import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {

  private LocalDate lastIncome = LocalDate.now();

  public boolean put(double amountToPut) {
    if (super.put(amountToPut)) {
      lastIncome = LocalDate.now();
      return true;
    }
    return false;
    //    if (amountToPut >= 0) {
//      amount += amountToPut;
//      lastIncome = LocalDate.now();
//    }
  }

  public boolean take(double amountToTake) {
    if (lastIncome.until(LocalDate.now(), ChronoUnit.MONTHS) < 1) {
      System.out.println("Нельзя снимать деньги в течении месяца после последнего пополнения");
      return false;
    }
    return super.take(amountToTake);
//    if (amountToTake <= amount) {
//      amount -= amountToTake;
//      return true;
//    }
//    return false;
  }


}
