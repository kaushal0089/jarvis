package in.kkd.programs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class sortList {
    public static void main(String[] str){
        String[] arr = {"dear","test","new","hello","gorilla"};
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("your");
        arrList.add("test");
        arrList.add("hello");
        arrList.add("just");
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted arrays : "+Arrays.toString(arr));
        Collections.sort(arrList);
        System.out.println("Sorted arraylist : "+arrList);
    }


}
