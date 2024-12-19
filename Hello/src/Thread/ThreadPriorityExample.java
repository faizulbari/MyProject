package Thread;

class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is running with priority " + Thread.currentThread().getPriority());
        }
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        // Create threads with different priorities
        PriorityThread lowPriorityThread = new PriorityThread("LowPriorityThread");
        PriorityThread normalPriorityThread = new PriorityThread("NormalPriorityThread");
        PriorityThread highPriorityThread = new PriorityThread("HighPriorityThread");

        // Set priorities
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY); // Priority 1
        normalPriorityThread.setPriority(Thread.NORM_PRIORITY); // Priority 5 (default)
        highPriorityThread.setPriority(Thread.MAX_PRIORITY); // Priority 10

        // Start threads
        highPriorityThread.start();
        lowPriorityThread.start();
        normalPriorityThread.start();

    }
}
