package org.example.tools;

import org.example.program.IThread;

import java.util.ArrayList;
import java.util.List;

public abstract class MultThread implements CallBack {
    static int i = 1;

    @Override
    public synchronized int get() {
        return i++;
    }

    @Override
    public synchronized void set(String message) {
        IFile.writeString(message,"messages.txt");
    }

    public void run() {
        List<IThread> threads = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            threads.add(new IThread(this));
        }
        System.out.println("begin");
        threads.forEach(ThreadPool::execute);
        System.out.println("finish");
    }
}
