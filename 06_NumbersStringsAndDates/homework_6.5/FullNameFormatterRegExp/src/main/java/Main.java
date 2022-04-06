import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      if (input.matches("\\s*[а-яА-Я[-]]+\\s+[а-яА-Я[-]]+\\s+[а-яА-Я[-]]+\\s*")) { //\s*[а-яА-Я]\s+[а-яА-Я]\s+[а-яА-Я]\s*
        String[] words = input.split("\\s+");
        System.out.printf("Фамилия: %s%nИмя: %s%nОтчество: %s",words[0],words[1],words[2]);
      } else {
        System.out.println("Введенная строка не является ФИО");
      }
  }

}