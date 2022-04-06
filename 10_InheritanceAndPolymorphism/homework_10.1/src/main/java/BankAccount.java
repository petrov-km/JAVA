public class BankAccount {

  private double amount = 0;

  public double getAmount() {
    return amount;
  }

  public boolean put(double amountToPut) {
    if (amountToPut >= 0) {
      amount += amountToPut;
      return true;
    }
    return false;
  }

  public boolean take(double amountToTake) {
    if (amountToTake <= amount) {
      amount -= amountToTake;
      return true;
    }
    return false;
  }

  public boolean send(BankAccount receiver, double amount) {
    if (take(amount)) {
      receiver.put(amount);
      return true;
    }
    return false;
  }

}
