package ProblemSolving.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pattern132 {
        public boolean obj132(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>(); // a decreasing stack
            int ak = Integer.MIN_VALUE;                // Find a seq, where ai < ak < aj.

            for (int i = nums.length - 1; i >= 0; --i) {
                // ai < ak, done because ai must < aj.
                if (nums[i] < ak)
                    return true;
                while (!stack.isEmpty() && stack.peek() < nums[i])
                    ak = stack.pop();
                stack.push(nums[i]); // `nums[i]` is a candidate of aj.
            }

            return false;
        }


    public static void main(String arg[])
    {
        Pattern132 obj132 = new Pattern132();
        System.out.println(obj132.obj132(new int[]{6,30,25,20,8,7}));   // output : abc
    }

}
