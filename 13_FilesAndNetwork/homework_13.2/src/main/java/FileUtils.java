import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

  public static void copyFolder(String sourceDirectory, String destinationDirectory) {
    File in = new File(sourceDirectory);
    File out = new File(destinationDirectory);
    if (!out.exists()) {
      try {
        if (!out.mkdirs()) {
          System.out
              .println(
                  destinationDirectory + " Ошибка при создании папки: ");
        }
      } catch (Exception e) {
        System.out
            .println(destinationDirectory + " Ошибка при создании папки ");
        e.printStackTrace();
      }
    }
    // Файл или папка в папке, которую нужно скопировать
    String[] files = in.list();
//		File[] file = in.listFiles();
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
    File temp = null;
    for (int i = 0; i < files.length; i++) {
      if (sourceDirectory.endsWith(File.separator)) {
        temp = new File(sourceDirectory + files[i]);
      } else {
        temp = new File(sourceDirectory + File.separator + files[i]);
      }
      // Это файл
      if (temp.isFile()) {
        try {
                   /* // Создаем и читаем файл для копирования
                    fis = new FileInputStream(temp.getAbsolutePath());
                    // Создаем и записываем файлы для копирования
                    fos = new FileOutputStream(new File(destinationDirectory + "\\" + temp.getName()));*/
          Files.copy(Paths.get(temp.getAbsolutePath()),
              Paths.get(destinationDirectory + "\\" + temp.getName()));
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else if (temp.isDirectory()) {
        // Это папка
        copyFolder(temp.getAbsolutePath(), destinationDirectory + "\\" + temp.getName());
      }
            /*int c;
            // Создаем байтовый массив
            byte[] b = new byte[1024 * 5];
            try {
                // Записываем в файл
                while ((c = fis.read(b)) != -1) {
                    fos.write(b, 0, c);
                }
                fis.close();
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
    }
  }
}
