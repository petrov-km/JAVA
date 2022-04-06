public class CardAccount extends BankAccount {

  @Override
  public boolean take(double amountToTake) {
    return super.take(amountToTake*1.01);
//    if (amountToTake <= amount) {
//      amount -= amountToTake*1.01;
//      return true;
//    }
//    return false;
  }
}
