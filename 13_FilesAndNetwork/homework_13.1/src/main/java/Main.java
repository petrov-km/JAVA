import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;
//import org.apache.commons.io.FileUtils;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.println("Введите путь:");
      String path = in.nextLine();
      //По идее можно так:
      //System.out.println(FileUtils.byteCountToDisplaySize(FileUtils.sizeOfDirectory(new File(path))));
      long size = FileUtils.calculateFolderSize(path);
      if (size != -1) {
        System.out
            .println("Размер папки " + path + " составляет " + getStringSizeLengthFile(size));
        break;
      }
    }
  }

  public static String getStringSizeLengthFile(long size) {
    DecimalFormat df = new DecimalFormat("0.00");
    float sizeKB = 1024.0f;
    float sizeMB = sizeKB * sizeKB;
    float sizeGB = sizeMB * sizeKB;
    if (size > sizeGB) {
      return df.format(size / sizeGB) + " GB";
    } else if (size > sizeMB) {
        return df.format(size / sizeMB) + " MB";
    } else if (size > sizeKB) {
        return df.format(size / sizeKB) + " KB";
    }
    return size + " B";
  }
}
