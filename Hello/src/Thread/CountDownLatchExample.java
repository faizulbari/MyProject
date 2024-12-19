package Thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main (String arg[]){

        CountDownLatch latch = new CountDownLatch(3);

        Worker th1 = new Worker("Worker 1",latch,1000);
        Worker th2 = new Worker("Worker 2",latch,2000);
        Worker th3 = new Worker("Worker 3",latch,3000);

        th1.start();
        th2.start();
        th3.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()
                + " Main thread after workers Finished  ");

    }



}

class Worker extends Thread{

    private final CountDownLatch latch;
    private final int sleepTime;

    Worker(String name , CountDownLatch latch , int delay)
    {
        super(name);
        this.latch = latch ;
        this.sleepTime = delay ;
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println(Thread.currentThread().getName()
                    + " Going on sleep for " + sleepTime );

            Thread.sleep(sleepTime);

            System.out.println(Thread.currentThread().getName()
                    + " Finished work counting down ");

            latch.countDown();

            System.out.println(Thread.currentThread().getName()
                    + " After count down ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}