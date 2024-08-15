import java.time.Duration;
import java.time.Instant;
public class TimeTest {
   public void test(){
      int num = 0;
      for(int i=0; i<=50; i++){  
         num =num+i;
         System.out.print(num+", ");
      }  
   }
   public static void main(String args[]){

      NumberFunction m1 = new NumberFunction();

      TimeTest obj = new TimeTest();
      long start1 = System.nanoTime();
      long start2 = System.currentTimeMillis();
      Instant inst1 = Instant.now();

      System.out.println("\n Total nos = "  + m1.countPrimes(1000000));


      long end1 = System.nanoTime();
      long end2 = System.currentTimeMillis();
      Instant inst2 = Instant.now();

      System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
      System.out.println("Elapsed Time in milli seconds: "+ (end2-start2));
      System.out.println("Elapsed Time: "+ Duration.between(inst1, inst2).toString());

      System.out.println("\n Total nos = "  + m1.countPrimes1(1000000));

      long end3 = System.nanoTime();
      long end4 = System.currentTimeMillis();
      Instant inst3 = Instant.now();

      System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
      System.out.println("Elapsed Time in milli seconds: "+ (end4-end2));
      System.out.println("Elapsed Time: "+ Duration.between(inst2, inst3).toString());



   }
}