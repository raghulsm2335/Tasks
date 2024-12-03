package JAVAPractice;

import java.util.Scanner;

public class Review {
    public static void main(String[] args) {    
        String name="raghul";
        System.out.println();
        for(int length=name.length()-1;length>=0;length--){
            System.out.print(name.charAt(length));
        }

    }
}
