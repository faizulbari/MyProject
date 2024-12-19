package ProblemSolving.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumProblem {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), candidates, 0, target);
        return result;
    }

    void dfs(List<List<Integer>> result, List<Integer> temp, int[] candidates, int sum, int target) {
        if (sum == target) {
            result.add(temp);
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            temp.add(candidates[i]);
            sum += candidates[i];
            dfs(result, temp, candidates, sum, target);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String arg[])
    {
        CombinationSumProblem com = new CombinationSumProblem();
        System.out.println(com.combinationSum(new int[]{2, 3, 4, 5},8));
    }
}

