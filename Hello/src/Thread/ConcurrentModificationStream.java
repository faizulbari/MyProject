package Thread;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationStream {
    public static void main(String[] args) {
        // Create a List of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Attempt to modify the list during stream operation
        try {
            numbers.stream().forEach(number -> {
                System.out.println("Processing: " + number);
                // Attempt to modify the collection during the stream's operation
                if (number == 3) {
                    numbers.add(6);  // This will cause a ConcurrentModificationException to throw
                }
            });
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e);
        }
    }
}
