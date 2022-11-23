package Bench;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessing {
    public static void imageProcessing()
    {
        try {
            String imagePath = "image.jpg";
            BufferedImage image = ImageIO.read(new File(imagePath));
            BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            int cores = Runtime.getRuntime().availableProcessors();
            Thread[] threads = new Thread[cores];
            for (int i = 0; i < cores; i++) {
                int j = i;
                threads[i] = new Thread(() -> {
                    for (int x = j; x < image.getWidth(); x += cores) {
                        for (int y = 0; y < image.getHeight(); y++) {
                            int rgb = image.getRGB(x, y);
                            int r = (rgb >> 16) & 0xFF;
                            int g = (rgb >> 8) & 0xFF;
                            int b = (rgb) & 0xFF;
                            int grayscale = (r + g + b) / 3;
                            int newRgb = (grayscale << 16) + (grayscale << 8) + grayscale;
                            newImage.setRGB(x, y, newRgb);
                        }
                    }
                });
                threads[i].start();
            }
            for (int i = 0; i < cores; i++) {
                threads[i].join();
            }
            ImageIO.write(newImage, "jpg", new File("new_image.jpg"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
