import java.util.Scanner;

class PrintPatterns {
    public static void main(String[] args) {
        int a, b, c;
       /* Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of a");
        a=sc.nextInt();
        System.out.println("Enter the value of b");
        b=sc.nextInt();
        System.out.println("Enter the value of c");
        c=sc.nextInt();
        int sum=a+b+c;
        int avg=a+b+c/3;
        System.out.println("The sum is "+sum);
        System.out.println("The avg is "+avg);*/

        //printPattern2(9);
        printPattern4(9);
    }

    private static void printPattern4(int rows) {
        // for loop for the rows
        for (int i = 1; i <= rows; i++) {
            // white spaces in the front of the numbers
            int numberOfWhiteSpaces = (rows - i) * 2;

            //print leading white spaces
            printString(" ", numberOfWhiteSpaces);

            //print numbers
            for (int x = 1, j = 1; x <= (i * 2 - 1); x++) {
                System.out.print(j + " ");
                if (j >= i) j--;
                else j++;

            }

            //move to next line
            System.out.println("");
        }
    }

    private static void printPattern2(int rows) {
        // for loop for the rows
        for (int i = 1; i <= rows; i++) {
            // white spaces in the front of the numbers
            int numberOfWhiteSpaces = rows - i;

            //print leading white spaces
            printString(" ", numberOfWhiteSpaces);

            //print numbers
            for (int x = 1; x <= i; x++) {
                System.out.print(x + " ");
            }

            //move to next line
            System.out.println("");
        }
    }

    //utility function to print string given times
    private static void printString(String s, int times) {
        for (int j = 0; j < times; j++) {
            System.out.print(s);
        }
    }
}





