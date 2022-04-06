public class IndividualBusinessman extends Client {

  @Override
  public void put(double amountToPut) {
    if (amountToPut<1000){
      super.put(amountToPut*0.99);
    }
    if (amountToPut>=1000){
      super.put(amountToPut*0.995);
    }

  }

  @Override
  public void getInfo() {
    System.out.println("Снятие без комиссии.\n"
        + "Пополнение до 1000руб - комиссия 1%, более 1000 руб - 0,5%\n"
        + "баланс - "+ super.getAmount());
  }
}
