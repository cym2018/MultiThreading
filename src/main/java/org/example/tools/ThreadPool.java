package org.example.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static ExecutorService executorService = null;

    public static void execute(Runnable runnable) {
        if (executorService == null) {
            executorService = Executors.newCachedThreadPool();
        }
        executorService.execute(runnable);
    }
}
