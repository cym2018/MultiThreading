package org.example.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class ThreadPool {
    static class Holder {
        private static final ExecutorService executorService = Executors.newCachedThreadPool();
    }


    public static void execute(Runnable runnable) {
        Holder.executorService.execute(runnable);
    }

    public static boolean isShutdown() {
        return Holder.executorService.isShutdown();
    }
}
