package org.example;

import org.example.tools.IThread;
import org.example.tools.ThreadPool;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main implements CallBack {
    static final Main obj = new Main();
    static FileWriter fileWriter = null;
    int i = 0;

    public static void main(String[] args) {
        // 打开文件
        try {
            fileWriter = new FileWriter("file.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileWriter != null) {
            obj.main();
        }
    }

    void main() {
        List<IThread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new IThread(this));
        }
        System.out.println("begin");
        threads.forEach(ThreadPool::execute);
        System.out.println("finish");
    }

    @Override
    public synchronized int get() {
        return i++;
    }

    @Override
    public synchronized void set(String message) {
        try {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}