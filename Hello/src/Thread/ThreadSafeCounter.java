package Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {
    private AtomicInteger count = new AtomicInteger(5);

    public void increment()
    {
        count.incrementAndGet();
    }

    public int getCount()
    {
        return count.get();
    }

    public static void main(String arg[]) throws InterruptedException {
        ThreadSafeCounter counter = new ThreadSafeCounter();

        Thread t1 = new Thread(counter::increment);
        Thread t2 = new Thread(counter::increment);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count:" + counter.getCount());

    }
}
