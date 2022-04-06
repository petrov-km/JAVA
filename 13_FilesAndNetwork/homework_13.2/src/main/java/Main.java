import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
  static String source;
  static String dest;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.println("Введите путь копируемой папки:");
      source = in.nextLine();
      if (!new File(source).exists()) {
        System.out.println(source + " Путь к копируемой папке неверен !!! ");
        continue;
      }
      break;
    }
    System.out.println("Введите путь папки в которую нужно копировать:");
    dest = in.nextLine();
    try {
      FileUtils.copyFolder(source, dest);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
