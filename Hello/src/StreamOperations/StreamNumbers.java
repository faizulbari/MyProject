package StreamOperations;

import java.util.*;
import java.util.stream.Collectors;

public class StreamNumbers {
    public static void main(String arg[])
    {
        int[] numbers = new int[]{1,2,3,4,5};

        List<Integer> listOfInteger = new LinkedList<>(){{
            add(58);add(73);add(36);add(90);add(14);add(58);
            add(87);add(62);add(1);add(45);;add(29);}};

        List<Double> listOfDecimal = Arrays.asList(41.11,32.2,53.3,24.44,65.55,17.7,78.8,9.9,80.0);

        //Ex1: Remove duplicates
        listOfInteger = listOfInteger.stream().distinct().collect(Collectors.toList());

        //Ex2: Partition the whole group with two concepts
        System.out.println(listOfInteger.stream().collect(Collectors.partitioningBy(x -> x % 2 == 1)));
        Map<Boolean,List<Integer>> map= listOfInteger.stream().collect(Collectors.partitioningBy(i -> (i%2)==0));
        Set<Map.Entry<Boolean, List<Integer>>> entrySet = map.entrySet();
        for(Map.Entry<Boolean, List<Integer>> entry : entrySet){
            if(entry.getKey())
                System.out.println("Even Number = " + entry.getValue());
            else
                System.out.println("Odd numbers = " + entry.getValue());
        }

        //Ex:3 sort in reverse order and print
        listOfDecimal.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.print(x + " "));

        //Ex.4 sort based on the after fraction digits
        System.out.println("\nOrder with after fractions");
        listOfDecimal.stream().sorted((a,d) -> Double.compare(a%1,d%1)).forEach(x -> System.out.print(x + " "));

        System.out.println();
        listOfDecimal.stream().sorted(Comparator.comparingDouble(a -> a % 1)).forEach(x -> System.out.print(x + " "));

        //Ex:5 Filter the number freater than 50
        System.out.println("\nFilter only greater 50 numbers");
        listOfDecimal.stream().sorted().filter(i -> i > 50).forEach(x -> System.out.print(x + " "));

        //Ex:5 Filter and print only the fractions greater than 5
        System.out.println("\nFilter only with the numbers fractionss greater than .50 numbers for ceiling");
        listOfDecimal.stream().sorted().filter(i->((i%1)>=0.5)).forEach(x -> System.out.print(x + " "));

        Double max = listOfDecimal.stream().max(Comparator.naturalOrder()).get();
        Double min = listOfDecimal.stream().min(Comparator.naturalOrder()).get();
        System.out.printf("\nThe max = %.2f and the min = %.2f",max,min);

        max = listOfDecimal.stream().max(Comparator.comparingDouble(a -> a % 1)).get();
        min = listOfDecimal.stream().min(Comparator.comparingDouble(a -> a % 1)).get();
        System.out.printf("\nThe max = %.2f and the min = %.2f",max,min);

    }
}
