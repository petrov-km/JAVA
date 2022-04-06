public class PhysicalPerson extends Client {


  @Override
  public void getInfo() {
    System.out.println("Пополнение и снятие без комиссии.\n"
        + "баланс - "+ super.getAmount());
  }
}
