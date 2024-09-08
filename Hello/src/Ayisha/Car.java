package Ayisha;

import java.util.Scanner;

public class Car {


    String model;
    String color;
    short numberofwheels;

    void acceptDetails()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Car name: ");
        model = scanner.nextLine();

        System.out.print("Enter color: ");
        color = scanner.nextLine();

        System.out.print("Enter number of wheels: ");
        numberofwheels = scanner.nextShort();
    }

    void setdetails(String model,String color,short noofwheel)
    {
        this.model = model;
        this.color = color;
        numberofwheels = noofwheel;
    }

    void printDetails()
    {
        System.out.println("Model Name = " + model);
        System.out.println("color= " + color);
        System.out.println("numberofwheels = " + numberofwheels);
    }




}
