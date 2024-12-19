package Anonymous;

public class AnonymousInnerClassExtends {

    public static void main(String arg[]){
        Car car1 = new Car();
        car1.engineBuild();
        car1.buildRadiator();
        System.out.println(car1.getClass().getName());

        //Ex1 :
        Car car2 = new Car(){
            public int wheels = 4;
            //@Override
            public void engineBuild(){
                System.out.println("Diesel Engine built successfully , wheels " + wheels);
            }

        };
        car2.engineBuild();
        car2.buildRadiator();
        //System.out.println("Diesel Engine built successfully , wheels " + car2.wheels);
        System.out.println(car2.getClass().getName());

        //Ex2 :
        Bike superBike = new Bike() {
            //@Override
            public void buildEngine() {
                System.out.println("Super Bike Engine built successfully");
            }

        };
        superBike.buildEngine();
        superBike.buildRadiator();
        System.out.println(superBike.getClass().getName());

        //Ex3 : Thread class extension with inner class
        Thread t = new Thread(){
            @Override
            public void run(){
                System.out.println("Thread extention with inner class. A thread is started");
            }
        };
        t.start();
        System.out.println("Main THread 1");

        //Ex4: Runnable implementation
        Runnable r = new Runnable() {

            // run() method for the thread
            public void run() {
                // Print statement when run() is invoked
                System.out.println("Thread runnable implementtation with inner class. A thread is started");
            }
        };
        Thread t2 = new Thread(r);
        t2.start();
        System.out.println("Main THread 2");

        //lambda applicable if only one abstract method present.
        Bike normalBike = () -> System.out.println("Normal Bike Engine built successfully");
        normalBike.buildEngine();
        normalBike.buildRadiator();
        System.out.println(normalBike.getClass().getName());

    }
}

class Car{
    int wheelsD = 4;
    public void engineBuild(){
        System.out.println("Petrol Engine built successfully");
    }
    public void buildRadiator(){
        System.out.println("Quality Radiator built successfully");
    }
}

interface Bike {
    int wheelsD = 2;
    public void buildEngine();
    public default void buildRadiator(){
        System.out.println("Bike Radiator built successfully");
    }

}
