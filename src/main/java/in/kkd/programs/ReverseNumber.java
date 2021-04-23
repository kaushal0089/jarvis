package in.kkd.programs;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] str){
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        long reverseNumber = reverseNumber(number);
//        System.out.println("Number is "+number);
        System.out.println("reverse number is "+reverseNumber);
    }

    public static long reverseNumber(long number){
        System.out.println("Number is "+number);
        long reverse = 0;
        while(number != 0 ) {
            reverse = (reverse * 10) + (number % 10);
            number = number / 10;
        }
        System.out.println("reverse is"+reverse);
        return reverse;
    }
}
