import java.util.ArrayList;
import java.util.List;

public class PermutationsSwap {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            // If start index reaches the end, a full permutation has been formed
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            for (int element: nums) { System.out.print(" "+element); }
            result.add(permutation);
            System.out.print("\nPermutaion Added\n");
        } else {
            for (int i = start; i < nums.length; i++) {
                // Swap the current index with the start index
                swap(nums, i, start);
                System.out.println("Swap start = "+start+" i = "+i+ "");
                // Recurse to form permutations with the next element in the sequence
                backtrack(nums, start + 1, result);
                // Backtrack by undoing the previous swap
                swap(nums, i, start);
                System.out.println("Back Swap start = "+start+" i = "+i+"" );

            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        PermutationsSwap perm = new PermutationsSwap();
        int[] nums = { 1, 2, 3, 4};
        List<List<Integer>> permutations = perm.permute(nums);
        System.out.println(permutations);
    }
}
