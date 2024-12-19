package Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample extends Thread{

    private final CyclicBarrier cyclicBarrier;
    private final int waitTime;

    CyclicBarrierExample(int waitTime, CyclicBarrier cyclicBarrier){
        this.waitTime = waitTime;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        super.run();


        try {

            System.out.printf("\n%s Thread doing specific action and sleeping for " + waitTime ,
                    Thread.currentThread().getName() );

            Thread.sleep(waitTime);

            System.out.print("\nThread reached the common point going to wait for other threads " +
                    Thread.currentThread().getName());

            cyclicBarrier.await();

            System.out.print("\nThread reached the after wait " +
                    Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.print( "\ncontinues his journey");


    }

    public static void main (String args[]){

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new ActionThread());

        CyclicBarrierExample th1 = new CyclicBarrierExample(1000,cyclicBarrier);
        CyclicBarrierExample th2 = new CyclicBarrierExample(2000 ,cyclicBarrier);
        CyclicBarrierExample th3 = new CyclicBarrierExample(3000 ,cyclicBarrier);

        th1.start();
        th2.start();
        th3.start();

    }
}

class ActionThread extends  Thread
{
    public void run()
    {
        System.out.print("\nAction executed after all the bike reached common point");
    }
}

