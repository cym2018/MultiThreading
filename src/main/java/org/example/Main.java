package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Main implements CallBack {
    static final Main obj = new Main();

    public static void main(String[] args) {
        obj.main();
    }

    void main() {

    }

    @Override
    public void callBack(String message) {
        try {
            FileWriter fileWriter=new FileWriter("file.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}