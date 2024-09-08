package Ayisha;

import java.util.Scanner;

public class MainPhone {

    public static void main (String arg[])
    {
        Car car_ayisha = new Car();
        car_ayisha.acceptDetails();



        Car car_yasir = new Car();
        car_yasir.acceptDetails();


        Car car_faizul = new Car();
        car_faizul.acceptDetails();


        car_ayisha.printDetails();
        car_yasir.printDetails();
        car_faizul.printDetails();



    }
}
