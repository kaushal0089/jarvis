package in.kkd.programs;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String revstr = reversestr(str);
        System.out.println("Reverse of given string is : "+revstr);

    }
    public static String reversestr(String str){
        String revstr = "";
        int len = str.length();
        for(int i = len-1; i>=0; i--){
            revstr = revstr + str.charAt(i);
        }
        return revstr;
    }

    String s = "str";

}
