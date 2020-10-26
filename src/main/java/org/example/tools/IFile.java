package org.example.tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class IFile {

    public static void writeString(String message, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName + ".txt", true);
            fileWriter.write(message + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("文件写入失败");
            e.printStackTrace();
        }
    }

    public static void writePicture(BufferedImage im, String formatName, String fileName) {
        try {
            File file = new File(fileName + "." + formatName);
            ImageIO.write(im, formatName, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage readPicture(String fileName) {
        try {
            return ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
