package Ayisha;

import java.util.Scanner;

public class Library {

    int acc_num;
    String tittle;
    String author;


    void input()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the access number");
        this.acc_num = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter the Title");
        this.tittle = scan.nextLine();

        System.out.println("Enter the Author Name");
        this.author = scan.nextLine();


    }

    void compute()
    {
        Scanner scan1 = new Scanner(System.in);

        System.out.println("Enter the No of days late");
        int no_of_day_late = scan1.nextInt();

        int result = 0;
        result = no_of_day_late * 2 ;

        System.out.println("The total fine rupees= " + result);

    }

    void display()
    {
        System.out.println("Access Number\tTittle\tAuthor");
        System.out.println(acc_num+"\t"+tittle+"\t"+author);

    }



    public static void main (String arg[])
    {
        Library lib1 = new Library();
        lib1.input();
        lib1.display();
        lib1.compute();
    }
}
