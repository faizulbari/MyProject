package Thread;

class Thread1 implements Runnable
{
    public void run()
    {
        for( int i=0; i<5 ; i++)
        {
            System.out.println("run()  thread1 " + Thread.currentThread().getName());
            try {
                Thread.sleep(0);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void show()
    {
        for( int i=0; i<5 ; i++)
        {
            System.out.println("show()  thread1 " +  Thread.currentThread().getName());
            try {
                Thread.sleep(0);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

class Thread2 implements Runnable
{
    public void run()
    {
        for( int i=0; i<5 ; i++)
        {
            System.out.println("run() thread2 "+ Thread.currentThread().getName());
            try {
                Thread.sleep(0);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void show()
    {
        for( int i=0; i<5 ; i++)
        {
            System.out.println("show()  thread2 " + Thread.currentThread().getName());
            try {
                Thread.sleep(0);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }


}
public class ImplementsRunnable {
    public static void main(String arg[]){

        Runnable run1 = new Thread1();
        Thread th0 = new Thread(run1);

        Runnable run2 = new Thread2();
        Thread th2 = new Thread(run2);
        //th0.setPriority(Thread.MIN_PRIORITY);
        //th2.setPriority(Thread.MAX_PRIORITY);

        th0.start();
        th2.start();
        run2.run();

        Thread2 th3 = new Thread2();
        th3.run();
        Thread2 th4 = new Thread2();
        th4.show();

    }
}
