package com.nextgear.clarity.imagesplitter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileUtils {

    public static void writeImage(BufferedImage bufferedImage) {
        try {
            Path output_images = Paths.get(System.getProperty("user.dir"), "output_images");
            if(!Files.exists(output_images)) { Files.createDirectory(output_images); }
            Path filePath = Paths.get(output_images.toString(), UUID.randomUUID().toString() + ".jpg");
            Files.createFile(filePath);
            ImageIO.write(bufferedImage, "jpg", filePath.toFile());
        } catch (Exception e) {
            System.out.println("Unable to write file to disk " + e);
        }
    }
}
