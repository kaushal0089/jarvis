package in.kkd.programs;

import java.util.Scanner;

public class PalindromNumber {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        if(true){
            System.out.println("Given number is palindrom");
        }
        else System.out.println("Not a palindrom number");
    }

    public static boolean checkPalindrom(long number){
        long reverse = 0;
        while(number!=0){
            reverse = (reverse * 10) + (number %10);
            number = number / 10;
        }
        if(number==reverse) return true;
        else return false;
    }
}
