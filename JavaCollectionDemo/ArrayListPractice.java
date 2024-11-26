package JavaCollectionDemo;
import java.util.*;

public class ArrayListPractice {
    public static void main(String[] args) {
        System.out.println("hi");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        System.out.println(numbers.get(0));
        System.out.println(numbers.get(1));
        System.out.println(numbers.get(2));
        System.out.println(numbers.get(3));
        numbers.set(0,15);
        System.out.println("after set");
        System.out.println(numbers.get(0));
        numbers.remove(0);
        System.out.println("after remove");
        System.out.println(numbers.get(0));
        System.out.println("after loop");
        for(Integer number:numbers){
            System.out.println(number);
        }
    }
}
