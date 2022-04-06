import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScalrResizer extends  Thread {
    private File[] files;
    private int newWidth;
    private  String dstFolder;
    private long start;

    public ScalrResizer(File[] files, int newWidth, String dstFolder, long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }
        @Override
        public  void run(){
            try {
                for (File file : files) {
                    BufferedImage image = ImageIO.read(file);
                    if (image == null) {
                        continue;
                    }
                    BufferedImage scaledImg = Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, 400, Scalr.OP_ANTIALIAS);
                    ImageIO.write(scaledImg,"JPG",new File(dstFolder + "/" + file.getName()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Длительность Scalr: " + (System.currentTimeMillis() - start) + " ms");
        }

    }


