package in.kkd.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxOccuringChar {
    public static void main(String[] args){
        String str = "hellogoodmorning";
        str.trim();
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
//        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i =0;i<str.length();i++){
            int count = 0;
            for(int j=0;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                }
            }
            map.put(str.charAt(i),count);
//            arr.add(count);
        }
        System.out.println(map.toString());
        int max = 0;
        for (Map.Entry<Character,Integer> entry:map.entrySet()) {
            if(entry.getValue()>max)max=entry.getValue();
        }
        System.out.println("Maximum occurence is:"+max);
    }
}
