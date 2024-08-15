import java.util.Arrays;
import java.util.Comparator;

class NumberFunction {

     private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            //This will compare the size of the two strings 
            //and confirm if strings a and b need to be swapped.
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Sort the strings by the custom comparator.
        Arrays.sort(strs, new LargerNumberComparator());

        // After being sorted, if the largest number is 0 then the whole number has to
        // be 0.
        if (strs[0].equals("0")) {
            return "0";
        }

        // After sorting, build the final number as a string!
        String largestNumberStr = new String();
        for (String numAsStr : strs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }

    public boolean isPrime(int n) {
        if (n % 2 == 0 ||
                n % 3 == 0)
            return false;

        for (int j = 2; j * j <= n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        int count = 0;
        if (n == 1 || n == 0 )
            return count;

        for (int i=2; i<n;i++)
        {
            if(isPrime(i)){
                count++;
                //System.out.print(" " +i);
            }
        }
        return count;
    }

    public boolean isPrime1(int n)
    {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
        {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    // Function to print primes
    public int countPrimes1(int n) {
        int count = 0;
        if (n == 1 || n == 0 )
            return count;

        for (int i=2; i<n;i++)
        {
            if(isPrime1(i)){
                count++;
                //System.out.print(" " +i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{4,5,6,98,987};
        NumberFunction ln = new NumberFunction();
        System.out.println("Larget number by arranging the array is "+ln.largestNumber(nums));

        NumberFunction m1 = new NumberFunction();
        System.out.println("\n Total nos = " + m1.countPrimes(1000000));


    }

}