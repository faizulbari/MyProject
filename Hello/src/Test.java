public class Test {
        int f=1;
         int factorial(int n){
            if (n != 0)
                f=(n * factorial(n-1));
            return f;
        }
        public static void main(String args[]){
             Test t=new Test();
            int i,fact=1;
            int number=4;//It is the number to calculate factorial
            t.factorial(number);
            System.out.println("Factorial of "+number+" is: "+t.f);
        }

}
