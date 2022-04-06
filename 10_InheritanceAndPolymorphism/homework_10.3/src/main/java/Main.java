public class Main {

  public static void main(String[] args) {
    Client physicalPerson = new PhysicalPerson();
    physicalPerson.put(200);
    physicalPerson.take(50);
    physicalPerson.getInfo();

    System.out.println("-----------------");

    Client legalPerson = new LegalPerson();
    legalPerson.put(200);
    legalPerson.take(100);
    legalPerson.getInfo();

    System.out.println("-------------------");

    Client individualBusinessman = new IndividualBusinessman();
    individualBusinessman.put(100);
    individualBusinessman.put(1000);
    individualBusinessman.getInfo();

  }

}
