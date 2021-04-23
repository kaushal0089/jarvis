package in.kkd.programs;

import com.google.inject.internal.cglib.core.$CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class PhoneChecker {
    public static void main(String[] args){
        ArrayList<Integer> contryCode = new ArrayList<Integer>();
        contryCode.add(91);
        contryCode.add(81);
        contryCode.add(61);
        contryCode.add(7);
        contryCode.add(10);
//        contryCode.add(null);
        ArrayList<Integer> operatorCode = new ArrayList<Integer>();
        operatorCode.add(99);
        operatorCode.add(82);
        operatorCode.add(98);
        operatorCode.add(20);
//        operatorCode.add(null);

//        Iterator<Integer> i = contryCode.iterator();
//        Iterator<Integer> j = operatorCode.iterator();

        Random rand = new Random();
        int n = 10000000 + rand.nextInt(90000000);

//        System.out.println("Print random number are : "+n);

        for(int i=0;i<contryCode.size();i++){
            for(int j =0;j<operatorCode.size();j++){
                n = 10000000 + rand.nextInt(90000000);
                String testcases = contryCode.get(i).toString() +" "+ operatorCode.get(j).toString() + n;
                System.out.println(testcases);
            }
        }

    }


}
