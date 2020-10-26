package org.example.program;

import org.example.tools.CallBack;

import java.util.concurrent.TimeUnit;

public class IThread implements Runnable {
    final private CallBack callBack;

    public IThread(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void run() {
        final String threadName = Thread.currentThread().getName();
        if (callBack == null) {
            return;
        }

        int i = callBack.get();
        while (i <= 100) {
            callBack.set(threadName + "\t:\t" + i + "\t:\t" + sleep());
            i = callBack.get();
        }
        System.out.println(threadName + "\tfinished");
    }

    private long generateTimeout() {
        return Double.doubleToLongBits(Math.random()) % 500 + 500;
    }

    private long sleep() {
        long timeout = generateTimeout();
        try {
            TimeUnit.MICROSECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return timeout;
    }
}
