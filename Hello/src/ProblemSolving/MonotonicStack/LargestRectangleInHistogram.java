package ProblemSolving.MonotonicStack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Iterate through all bars
        for (int i = 0; i < n; i++) {
            // Maintain increasing height order in the stack , if small val arrives remove all big values in stack and place the small value
            // small values are maintained in the stack untill find the another small value , so we can easily calculate when the minimum bar started
            // minimum will be maintained in the stack till last
            // if small bar arrives previous min maintain in the stack will be poped out and calcualte width from where it started i-1-stk.peek();
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        // Process remaining bars in the stack
        //minimum length in the increasing order till last is maintained in the stack
        //so we can calcualte the width from the last n-1-stack.peek() if there is no element in stack
        // it means the minimum is maintained from the starting
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? n : n - 1 - stack.peek();
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {6, 5, 4, 3, 2, 1};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights)); // Output: 12

        heights = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights)); // Output: 12

        heights = new int[]{1, 2, 4, 3, 1, 3,4,5,2,5,5,1,4,4,4};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights)); // Output: 15

        heights = new int[]{5, 5, 5, 5, 5};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights)); // Output: 25
    }
}
