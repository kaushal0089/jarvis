package in.kkd.programs;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        System.out.println("factorial of number is :"+factrecursion(number));
    }

    public static long fact(long number){
        long fact = 1;
        for(int i =2;i<=number;i++){
            fact = fact * i;
        }
    return fact;
    }

    public static long factrecursion(long number){
        long fact =1;
        if(number<=2)return number;
        return number * factrecursion(number-1);
    }
}
