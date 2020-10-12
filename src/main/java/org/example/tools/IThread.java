package org.example.tools;

import org.example.CallBack;

public class IThread implements Runnable {
    final private CallBack callBack;

    public IThread(CallBack callBack) {
        this.callBack = callBack;
    }

    public IThread() {
        callBack = null;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            if (callBack == null) {
                return;
            }
            while (true) {
                i = callBack.get();
                Thread.sleep(getSleepTime());
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private long getSleepTime() {
        return Double.doubleToLongBits(Math.random()) % 500 + 500;
    }
}
