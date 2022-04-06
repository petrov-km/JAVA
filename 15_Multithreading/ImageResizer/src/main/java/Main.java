import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    private static int newWidth = 300;
    private static int numberOfCores = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        String srcFolder = "C:/Users/Александра/Desktop/src";
        String dstFolder = "C:/Users/Александра/Desktop/dst";
        String dstFolder1 = "C:/Users/Александра/Desktop/1";
        System.out.println("кол-во ядер: " + Runtime.getRuntime().availableProcessors());

        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();

        int stepLength = files.length / numberOfCores;
        int currentLength = stepLength;
        for (int i = 0; i < numberOfCores; i++) {
            if (i == numberOfCores - 1) {
                currentLength = stepLength + files.length - (stepLength * numberOfCores);
            }
            File[] filesForCurrentThread = new File[currentLength];
            System.arraycopy(files, i * stepLength, filesForCurrentThread, 0, currentLength);
            ImageResizer resizer1 = new ImageResizer(filesForCurrentThread, newWidth, dstFolder, start);
            ScalrResizer scalrResizer = new ScalrResizer(filesForCurrentThread, newWidth, dstFolder1, start );
            scalrResizer.run();
            resizer1.run();
        }
    }
}
