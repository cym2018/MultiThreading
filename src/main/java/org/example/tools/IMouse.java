package org.example.tools;

import java.awt.*;
import java.awt.event.InputEvent;

public abstract class IMouse {
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

    public static void move(int x, int y) {
        set(getX() + x, getY() + y);
    }

    public static void set(int x, int y) {
        Holder.robot.mouseMove(x, y);
    }

    public static void set(Point point) {
        Holder.robot.mouseMove(point.x, point.y);
    }

    public static int getX() {
        return MouseInfo.getPointerInfo().getLocation().x;
    }

    public static int getY() {
        return MouseInfo.getPointerInfo().getLocation().y;
    }

    public static void leftButton() {
        Holder.robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Holder.robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }

    public static void rightButton() {
        Holder.robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        Holder.robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }

}
