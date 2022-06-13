package sample;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test implements ArrayProcessor
{
    public static void main(String[] args)
            throws IOException
    {
        Integer[] array = {80,22, 73, 44, 56, 97, 89, 22, 11};
        Test ts = new Test();
        ts.apply(array);
        System.out.println(ts.counter(array, 22));

    }

    @Override
    public double apply(Integer[] array) {
        List<Integer> listOfIntegers = Arrays.asList(array);
        Integer m =  listOfIntegers.stream().mapToInt(v -> v).max().orElseThrow();
        Integer mi =  listOfIntegers.stream().mapToInt(v -> v).min().orElseThrow();
        double av= listOfIntegers.stream().mapToInt(v-> v).average().orElse(0);
        double su= listOfIntegers.stream().mapToInt(v -> v).sum();
        System.out.print("Max: "+ m+ "\n");
        System.out.print("Mn: "+ mi+ "\n");
        System.out.print("Max: "+ av+"\n");
        System.out.print("Max: "+ su+"\n");
        return 0;
    }

    @Override
    public double counter(Integer[] array, Integer no) {
        List<Integer> list = Arrays.asList(array);
        //double c= (double) Collections.frequency(list, no);
        return list.stream().filter(p -> p.equals(no)).count();
    }

}
