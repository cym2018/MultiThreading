package org.example.tools;

import java.awt.*;
import java.util.Stack;

public abstract class IKeyboard {
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

    public static void keyPress(int... keycodes) {
        Stack<Integer> stack = new Stack<>();
        for (int keycode : keycodes) {
            stack.push(keycode);
            ISleep.sleep(50);
            IMouse.Holder.robot.keyPress(keycode);
        }
        while (!stack.empty()) {
            ISleep.sleep(50);
            IMouse.Holder.robot.keyRelease(stack.pop());
        }
    }


    public static final int ALT = 18;
    public static final int SHIFT = 16;
    public static final int CTRL = 17;
    public static final int ESC = 27;
}
