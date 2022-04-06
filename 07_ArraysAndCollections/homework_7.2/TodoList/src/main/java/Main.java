import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.matches("\\s*ADD\\s+\\d+\\s+.+\\s*")) {
                input = input.substring(input.indexOf(" ")).trim();
                int index = Integer.parseInt(input.substring(0, input.indexOf(" ")));
                String todo = input.replaceFirst("\\d+\\s+", "");
                todoList.add(index, todo);
                continue;
            }
            if (input.matches("\\s*ADD\\s+\\d*\\S.+")) {
                String todo = input.replaceFirst("ADD\\s+", "");
                todoList.add(todo);
                continue;
            }
            if (input.matches("\\s*LIST\\s*")) {
                for (int i = 0; i < todoList.getTodos().size(); i++) {
                    System.out.println(i+" - " + todoList.getTodos().get(i));
                }
                continue;
            }
            if (input.matches("\\s*EDIT\\s+\\d+\\s+.+\\s*")) {
                String todo = input.replaceFirst("\\s*EDIT\\s+\\d+\\s+", "");
                input = input.substring(input.indexOf(" ")).trim();
                int index = Integer.parseInt(input.substring(0, input.indexOf(" ")));
                todoList.edit(todo,index);
                continue;
            }
            if (input.matches("\\s*DELETE\\s+\\d+\\s*")) {
                input = input.substring(input.indexOf(" ")).trim();
                todoList.delete(Integer.parseInt(input));
                continue;
            }
            System.out.println("Неизвестная команда");
        }
    }
}
