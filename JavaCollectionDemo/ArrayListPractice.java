//Title: Array List
//Author: Raghul S M
//Developed on: 25-11-24
//Modified On: 26-11-24
//Reviewed By:
//Reviewed On:

package JavaCollectionDemo;
import java.util.ArrayList;


public class ArrayListPractice {

    private static void printArrayList(ArrayList<Integer> numbers){//looping of array list
        for(Integer number:numbers){
            System.out.println(number);
        }
    }

    private static void log(String input){
        System.out.println(input);
    }
    private static void log(int input){
        System.out.println(input);
    }
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(); //creating object for array list class
        numbers.add(10);//adding value to array list
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        
        log(numbers.get(0));
        log(numbers.get(1));
        log(numbers.get(2));
        log(numbers.get(3)); 
        numbers.set(0,15); //set value as 15 for 0 of array list 
        log("after set");  // print statement message
        log(numbers.get(0)); 
        numbers.remove(0);//remove a data from 0th index of aray list
        log("after remove");
        log(numbers.get(0));
        log("after loop");
        printArrayList(numbers);//looping array list
    }
}
