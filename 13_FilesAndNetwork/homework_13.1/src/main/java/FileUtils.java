import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        //long result = 0;
        MyFileVisitor myFileVisitor = new MyFileVisitor();
        try {
            Files.walkFileTree(Paths.get(path), myFileVisitor);
        } catch (IOException e){
            e.printStackTrace();
        }
       /* try {
            result = Files.walk(Paths.get(path))
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .mapToLong(File::length)
                    .sum();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Папка не найдена, требуется ввести корректный путь");
            result = -1;
        }*/
        return myFileVisitor.size;
    }
}
