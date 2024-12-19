package ProblemSolving.MonotonicStack;

import static ProblemSolving.MonotonicStack.LargestRectangleInHistogram.largestRectangleArea;

public class MaximumRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int ans = 0;
        int[] hist = new int[matrix[0].length];

        for (char[] row : matrix) {
            for (int i = 0; i < row.length; ++i)
                hist[i] = row[i] == '0' ? 0 : hist[i] + 1;
            ans = Math.max(ans, largestRectangleArea(hist));
        }

        return ans;
    }

    public static void main(String arg[])
    {
        char[][] c = new char[][]{{1,0,1,0,0},
                                  {1,0,1,1,1},
                                  {1,1,1,1,1},
                                  {1,0,0,1,0}};
        MaximumRectangle max = new MaximumRectangle();
        int result = max.maximalRectangle(c);
        System.out.println(result);
    }

}
