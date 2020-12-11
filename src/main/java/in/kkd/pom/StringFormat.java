package in.kkd.pom;
import java.util.*;
import java.io.*;

public class StringFormat {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        System.out.printf("%-35s",s);
        System.out.println("Length is "+s.length());

    }
}
