package Thread;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20);

        int parallelismLevel = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of threads for parallel stream: " + parallelismLevel);

        numbers.parallelStream().forEach(n -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + " processing number: " + n);
        });


    }
}
