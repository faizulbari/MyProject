import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Add the current subset to the result list
        System.out.println(", start = " + start + ", temp list = " + tempList + ",  result = " + result);
        for (int i = start; i < nums.length; i++) {
            System.out.println(", i ="+i);
            tempList.add(nums[i]); // Include the current element in the subset
            System.out.println("templist added " + tempList);
            backtrack(result, tempList, nums, i + 1); // Recur with the remaining elements

            tempList.remove(tempList.size() - 1); // Exclude the last element to backtrack
            System.out.println("templist removed " + tempList);
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = {1, 2, 3,4,5};
        System.out.println(s.subsets(nums));
    }
}