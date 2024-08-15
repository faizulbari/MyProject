
public class Test1 extends Thread {
    public void run(){
        System.out.println("thread is running...");
    }

    public static void main(String args[]){
        Test1 m1=new Test1();
        Thread t1 =new Thread(m1);
        t1.start();
    }
}
