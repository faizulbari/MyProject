package Thread;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a ThreadPoolExecutor with corePoolSize = 2, maxPoolSize = 4, and a keepAliveTime of 10 seconds
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2));

        // Submit 6 tasks to the executor
        for (int i = 0; i < 6; i++) {
            executor.submit(new WorkerTask(i));
        }

        // Monitor the number of active threads
        while (!executor.isTerminated()) {
            System.out.println("Active Threads: " + executor.getActiveCount());
            System.out.println("Pool Size: " + executor.getPoolSize());
            System.out.println("Completed Tasks: " + executor.getCompletedTaskCount());
            Thread.sleep(1000);
        }

        executor.shutdown();
    }
}

class WorkerTask implements Runnable {
    private final int taskId;

    public WorkerTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Executing Task ID: " + taskId + " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);  // Simulate long-running task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
