package Thread;// Case 2
// Java Program to illustrate Difference between Runnable
// & Non-runnable Threads And Single Inheritance



// Class 3
// Main Class
class ExtendThread {

    // Main method
    public static void main(String[] args) {

        // Creating a thread object of our thread class
        MyThread1 obj1 = new MyThread1();
        MyThread2 obj2 = new MyThread2();
        MyThread3 obj3 = new MyThread3();

        obj1.start();       //Executed second
        // This thread will now look for run() method which is absent
        // Thread is simply created not runnable
        obj2.start();       //no execution since no run method

        // This thread is simply a function call as
        // no start() method is executed so here only
        // thread is created only followed by call
        obj2.show();        //Executed first since it direct call on main thread

        obj3.start();       //Executed at last

        //calling run directly will not create a thread , it will be just a functionla call
        obj3.run();         //Executed Third Since it is direct call from main thread
    }
}

// Class 1
// Helper thread Class extending main Thread Class
class MyThread1 extends Thread {

    // Method inside MyThread2
    // run() method which is called as soon as thread is
    // started
    public void run() {

        // Print statement when the thread is called
        System.out.println("Thread 0 is running " + Thread.currentThread().getName());
    }
}

// Class 2
// Main thread Class extending main Thread Class
class MyThread2 extends Thread {

    // Method
    public void show() {

        // Print statement when thread is called
        System.out.println("Thread 1 show " + Thread.currentThread().getName());
    }
}

class MyThread3 extends Thread {

    // Method
    public void show() {

        // Print statement when thread is called
        System.out.println("Thread 2 show " + Thread.currentThread().getName());
    }

    public void run() {

        // Print statement when the thread is called
        System.out.println("Thread 2 is running " + Thread.currentThread().getName());
    }
}
