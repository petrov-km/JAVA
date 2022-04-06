public class LegalPerson extends Client {

  @Override
  public void take(double amountToTake) {
    super.take(amountToTake*1.01);
  }

  @Override
  public void getInfo() {
    System.out.println("Пополнение без комиссии.\n"
        + "Снятие - комиссия 1%\n"
        + "баланс - "+ super.getAmount());
  }
}
