package BinarySearch;

public class SquareRoot {
    public static int sqrt(int x) {
        if (x == 0 || x == 1) return x;

        int left = 1, right = x / 2, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid <= x / mid) { // Check for overflow
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 36;
        System.out.println("Square root of " + x + " is: " + sqrt(x)); // Output: 4
    }
}