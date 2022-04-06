import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;



public class MyFileVisitor extends SimpleFileVisitor<Path> {
  public long size;

  public FileVisitResult visitFileFailed (Path path, IOException e) throws IOException{
    System.out.println("Файл не доступен " + path.toString());
    return FileVisitResult.SKIP_SUBTREE;
  }
  public FileVisitResult visitFile (Path path, BasicFileAttributes attrs) throws IOException{
    size += path.toFile().length();
    //System.out.println("Файл " + path.getFileName());
    return FileVisitResult.CONTINUE;
  }



}
