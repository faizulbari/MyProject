package ProblemSolving.Backtracking;

import java.util.ArrayList;
import java.util.List;

class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        return permutations(result , tempList , nums );
    }

    private static List<List<Integer>> permutations (List<List<Integer>> result , List<Integer> tempList , int[] nums)
    {
        if (tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
        }

        for ( int i=0 ; i < nums.length ; i++)
        {
            if(tempList.contains(nums[i]))
            continue;
            tempList.add(nums[i]);
            permutations(result,tempList,nums);
            tempList.remove(tempList.size()-1);
        }
        return result;
    }

    public static void main(String arg[])
    {
        System.out.println(permute(new int[]{1,2,3}));
    }
}