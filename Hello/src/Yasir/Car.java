package Yasir;

public class Car {
    //Atributes:
        String brand;
        String color;
        String engineType;

    //Methods:
        //constructor : initialize the attributes
        Car(String bnd, String color, String engType)
        {
           brand = bnd;
           this.color = color;
           engineType = engType;
        }
        void displayDetails(){
            System.out.println("Your car Brand is " + brand );
            System.out.println("Your car color is " + color );
            System.out.println("Your car Engine Type is " + engineType );
        }
}

 class ProgrameExecution
{
    public static void main(String[] arg)
    {
        System.out.println("Hi Welcome");
        Car yasirCar = new Car("Lamborgini" , "Red" , "Petrol");
        Car faizulCar = new Car("Maruti Suzuki", "Blue", "Diesel");

        yasirCar.displayDetails();
        faizulCar.displayDetails();

    }

}
