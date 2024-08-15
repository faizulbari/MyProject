
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Sum3 {


      public static List<List<Integer>> threeSum(int[] nums) {

         List<List<Integer>> result = new ArrayList<>();
         List<Integer> set = new ArrayList<>();

         for(int i=0;i<nums.length;i++)
         {
            for(int j=i+1;j<nums.length;j++)
            {
               for(int k=j+1;k<nums.length;k++)
               {
                  if (nums[i]+nums[j]+nums[k]==0)
                  {
                     set.add(nums[i]);
                     set.add(nums[j]);
                     set.add(nums[k]);
                     System.out.println(set);
                     result.add(set);
                     set.clear();
                  }
               }
            }
         }

         return result;

      }




   public static void main(String args[]){
      int three[] = new int[]{-1,0,1,2,-1,-4};
      threeSum(three);

   }
}