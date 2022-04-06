import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        EmailList emailList = new EmailList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("\\s*LIST\\s*")) {
                System.out.println(emailList.getSortedEmails());
                continue;
            }
            if (input.matches("\\s*ADD\\s+.+")) {
                input = input.substring(input.indexOf(" ")).trim();
                emailList.add(input);
                continue;
            }
            System.out.println("Неизвестная команда");

        }
    }
}