import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    PhoneBook phoneBook = new PhoneBook();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Введите номер, имя или команду:");
      String input = scanner.nextLine().trim();
      if (input.matches("\\s*LIST\\s*")) {
        printSet(phoneBook.getAllContacts());
        continue;
      }
      if (input.matches("\\s*\\D+\\s*")) {  //"\\s*[а-яА-Я]+\\s*"
        if (phoneBook.containName(input)) {
          System.out.println(phoneBook.getPhonesByName(input).toString()
              .replace("[", "")
              .replace("]", ""));
          continue;
        } else {
          System.out.println("Такого имени в телефонной книге нет." + "\n" +
              "Введите номер телефона для абонента \"" + input + "\"");
          String inputNumber = scanner.nextLine().trim();
          phoneBook.addContact(inputNumber, input);
          continue;
        }
      }
      input = phoneBook.checkOnCorrectPhoneNumber(input);
      if (input.isEmpty()) {
        System.out.println("Неверный формат ввода");
        continue;
      }
      if (phoneBook.containPhone(input)) {
        System.out.println(phoneBook.getNameByPhone(input));
        continue;
      }
      System.out.println("Такого номера нет в телефонной книге." + "\n" +
          "Введите имя абонента для номера \"" + input + "\"");
      String inputName = scanner.nextLine().trim();
      phoneBook.addContact(input,inputName);
    }
  }


  private static void printSet(Set<String> set) {
    for (String s : set) {
      System.out.println(s);
    }
  }

}
