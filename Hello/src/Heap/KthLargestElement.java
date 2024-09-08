package Heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k); // Min-Heap of size k

        for (int num : nums) {
            minHeap.offer(num);
            System.out.println(minHeap);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element if size exceeds k
                System.out.println(minHeap);

            }
        }

        return minHeap.peek(); // Root of the heap is the kth largest element
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 2, 8, 1, 5, 9, 6, 4, 7};
        int k = 4;
        System.out.println("Kth largest element: " + findKthLargest(nums, k)); // Output: 5
    }
}
