package in.kkd.programs;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] str){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(checkPrime(number)){
            System.out.println("Number is Prime ---");
        }
        else{
            System.out.println("Number is not prime");
        }
    }

    public static boolean checkPrime(int number){
        if(number<0) return false;
        for (int i=2; i<=Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
