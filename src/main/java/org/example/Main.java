package org.example;

import org.example.tools.IFile;
import org.example.tools.IKeyboard;
import org.example.tools.IPicture;
import org.example.ui.MainWindow;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class Main {
    static class Holder {
        // ��׽�� �շ��λ� ��ʾ
        public static BufferedImage taskFlag;
        // �������Ͻ�
        public static BufferedImage leftUp;
        public static BufferedImage leftDown;
        public static BufferedImage rightUp;
        public static BufferedImage rightDown;
        public static Point leftUpPoint;
        public static Point leftDownPoint;
        public static Point rightUpPoint;
        public static Point rightDownPoint;

        static {
            System.out.println("��ʼ����ͼƬ");
            taskFlag = IFile.readPicture("TaskFlag.bmp");
            leftUp = IFile.readPicture("LeftUp.bmp");
            leftDown = IFile.readPicture("LeftDown.bmp");
            rightUp = IFile.readPicture("RightUp.bmp");
            rightDown = IFile.readPicture("RightDown.bmp");
            System.out.println("ͼƬ�������");
            //RightDown.bmp
        }
    }

    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

    }


    // ��ȡ��������
    public static void getWindowLocation() {
        // ������Alt+1 ��Ƶ���л�Ϊ��ǰ
        IKeyboard.keyPress(IKeyboard.ALT, KeyEvent.VK_1);
        IKeyboard.keyPress(IKeyboard.ALT, KeyEvent.VK_1);
        BufferedImage capture = IPicture.getBinaryCapture();
        Holder.leftUpPoint = IPicture.findPic(capture, Holder.leftUp);
        Holder.leftUpPoint.x -= 30;
        Holder.leftUpPoint.y -= 14;

        Holder.leftDownPoint = IPicture.findPic(capture, Holder.leftDown);
        Holder.leftDownPoint.x -= 24;
        Holder.leftDownPoint.x += 17;
        Holder.rightUpPoint = IPicture.findPic(capture, Holder.rightUp);
        Holder.rightDownPoint = IPicture.findPic(capture, Holder.rightDown);

        System.out.println("LU:" + Holder.leftUpPoint);
    }
}