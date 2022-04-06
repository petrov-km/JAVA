import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      //System.out.println("Введите строку:");
      String input = scanner.nextLine();
      input = input.trim();
      boolean error = false;

      for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if ( (c<'А'||c>'я') && (!(c == '-')&&!(c==' ')) )  {
          error = true;
          break;
        }
      }
      if (error){
        System.out.println("Введенная строка не является ФИО");
        break;
      }

      if (!input.contains(" ")) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      String surname = input.substring(0,input.indexOf(' '));
      String currentString = input.substring(input.indexOf(' '));
      currentString = currentString.trim();
      if (!currentString.contains(" ")) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      String name = currentString.substring(0,currentString.indexOf(' '));

      String patronymic = currentString.substring(currentString.indexOf(' '));
      patronymic = patronymic.trim();
      if (patronymic.contains(" ")) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      System.out.printf("Фамилия: %s%nИмя: %s%nОтчество: %s",surname,name,patronymic);
      break;
      }



  }

}