package Thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class CustomParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Create a ForkJoinPool with 4 threads
        ForkJoinPool customThreadPool = new ForkJoinPool(4);

        int parallelismLevel = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of threads for parallel stream: " + parallelismLevel);

        // Submit the parallel stream execution to the custom pool
        customThreadPool.submit(() -> {
            numbers.parallelStream().forEach(n -> {
                System.out.println("Thread: " + Thread.currentThread().getName() + " processing number: " + n);
            });
        }).join();
        
        customThreadPool.shutdown();
    }
}
