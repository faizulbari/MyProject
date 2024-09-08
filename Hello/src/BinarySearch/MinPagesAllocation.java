package BinarySearch;

public class MinPagesAllocation {
    public static int findPages(int[] arr, int m) {
        int n = arr.length;
        int sum = 0, max = 0;

        for (int pages : arr) {
            sum += pages;
            max = Math.max(max, pages);
        }

        int left = max, right = sum, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(arr, n, m, mid)) {
                result = mid;
                right = mid - 1; // Try for a smaller maximum
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static boolean isValid(int[] arr, int n, int m, int maxPages) {
        int students = 1, currentSum = 0;

        for (int pages : arr) {
            if (currentSum + pages > maxPages) {
                students++;
                currentSum = pages;
                if (students > m) return false;
            } else {
                currentSum += pages;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 120,132,165,324,987};
        int m = 2;
        System.out.println("Minimum number of pages: " + findPages(arr, m)); // Output: 113
    }
}
