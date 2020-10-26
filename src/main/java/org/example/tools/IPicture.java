package org.example.tools;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class IPicture {
    static class Holder {
        static Robot robot;

        static {
            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }

    public static BufferedImage getCapture(int x, int y, int width, int height) {
        return Holder.robot.createScreenCapture(new Rectangle(x, y, width, height));
    }

    public static BufferedImage getCapture() {
        return Holder.robot.createScreenCapture(new Rectangle(0, 0, 1920, 1080));
    }

    public static BufferedImage getBinaryCapture() {
        return toBinaryPicture(getCapture());
    }

    public static BufferedImage getGrayCapture() {
        return toGrayPicture(getCapture());
    }


    public static BufferedImage toGrayPicture(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth(), height = bufferedImage.getHeight();
        BufferedImage ret = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                ret.setRGB(i, j, bufferedImage.getRGB(i, j));
            }
        }
        return ret;
    }

    public static BufferedImage toBinaryPicture(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth(), height = bufferedImage.getHeight();
        BufferedImage ret = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                ret.setRGB(i, j, bufferedImage.getRGB(i, j));
            }
        }
        return ret;
    }

    public static Point findPic(BufferedImage big, BufferedImage small) {

        if (big.getHeight() < small.getHeight() || big.getWidth() < small.getWidth()) {
            return null;
        }
        int x = 0, y = 0;
        // i:宽度 m:宽度
        // j:高度 n:高度
        for (int i = 0; i + small.getWidth() < big.getWidth(); i++) {
            for (int j = 0; j + small.getHeight() < big.getHeight(); j++) {
                boolean flag = true;
                for (int m = 0; m < small.getWidth(); m++) {
                    for (int n = 0; n < small.getHeight(); n++) {
                        if (small.getRGB(m, n) != big.getRGB(i + m, j + n)) flag = false;
                        if (!flag) break;
                    }
                    if (!flag) break;
                }
                if (flag) return new Point(i + small.getWidth() / 2, j + small.getHeight() / 2);
            }
        }
        return null;
    }

    public static BufferedImage trim(BufferedImage bufferedImage) {
        boolean flag = true;
        // todo
        return null;
    }

    final public static String JPG = "jpg";
    final public static String BMP = "bmp";
    final public static int BINARY_WHITE = -1;
    final public static int BINARY_BLACK = -16777216;
}
