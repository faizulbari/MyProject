package Thread;

public class DataInconsistency extends Thread{
    int count = 0;

    public void increment()
    {
        count++;
        System.out.println( "Incremented by thread " + Thread.currentThread().getName());
    }

    public void run()
    {
        increment();
        System.out.println("Count =" + count);
    }
}

 class Counter {
    int count = 0,prevCount;
    String prevThName = null;

    public synchronized void increment()
    {
        count++;
        if(null == prevThName || prevThName != Thread.currentThread().getName())
        {
            System.out.printf( "Incremented by thread %s count = %d \n", prevThName,count-prevCount);
            prevThName = Thread.currentThread().getName();
            prevCount = count;
            System.out.printf( "Increment started by thread %s count = %d \n", Thread.currentThread().getName(),count);
        }
    }

    public int getCount()
    {
        System.out.println("Count =" + count);
        return count;
    }
}

 class DataInconsistencyExample
{
    public static void main (String arg[])
    {
        DataInconsistency th = new DataInconsistency();
        th.increment();
        th.start();
        th.run();

        Counter counter = new Counter();

        Thread[] thA = new Thread[10];

        for ( int i=0 ; i < thA.length ; i++)
        {
            thA[i] = new Thread(() ->{
                for (int j=0; j < 10000; j++){
                    counter.increment();
                }
            });
            if (i == 4)
                thA[i].setName("Faizul");
            thA[i].start();
        }

        System.out.println("Before Join  Counter Value: " + counter.getCount());
        // Wait for all threads to complete
        for (Thread thread : thA) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Print the final value of the counter
        System.out.println("Final Counter Value: " + counter.getCount());

    }
}
