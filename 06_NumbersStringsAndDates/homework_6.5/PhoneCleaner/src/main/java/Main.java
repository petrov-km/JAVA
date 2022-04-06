import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    input = input.replaceAll("\\D","");
    if (input.matches("89\\d{9}")) {
      input = input.replaceFirst("8","7");
      System.out.println(input);
      return;
    }
    if (input.matches("79\\d{9}")) {
      System.out.println(input);
      return;
    }
    if (input.matches("9\\d{9}")) {
      input = "7" + input;
      System.out.println(input);
      return;
    }
    System.out.println("Неверный формат номера");
  }

}
