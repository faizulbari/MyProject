package Thread;

public class DeamonThread implements Runnable{
    @Override
    public void run() {
        while(true){
            for(int i=0 ; i < 5 ; i++)
            {
                //periodically do a job
                System.out.printf("Demon Thread %s %d \n",Thread.currentThread().getName(), i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class DemonThreadExample{
    public static void main(String arg[]){
        Thread dth = new Thread(new DeamonThread());
        //dth.setDaemon(true);
        dth.start();

        Thread th = new Thread(() -> {
            for(int i=0 ; i < 10 ; i++){
                System.out.printf("Thread Name %s count %d \n",Thread.currentThread().getName(),i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        th.start();

        for(int i=0 ; i < 10 ; i++){
            System.out.printf("Thread Name %s count %d \n",Thread.currentThread().getName(),i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
