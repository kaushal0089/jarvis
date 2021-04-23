package in.kkd.programs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FindCountOfVowels {

    public static void main(String[] args){
        String inputStr = "thIs";
        char[] vowel = {'a','i','o','e','u'};
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
//        count=countNumberOfVowels(inputStr,vowel);
        list=countvowel2(inputStr);
        System.out.println("vowels are "+ list.get(0));
        System.out.println("consonants are "+ list.get(1));
//        System.out.println("Number of vowel's count are : "+count);
    }

    public static int countNumberOfVowels(String input,char[] vowel){
        int len = input.length();
        int count = 0;
        for(int i=0;i<len;i++){
            String str = String.valueOf(input.charAt(i));
            if(Arrays.toString(vowel).contains(str)){
                count++;
            }
        }
    return count;
    }

    public static ArrayList<Integer> countvowel2(String input){
        int vowelcount =0;
        int consonantsCount=0;
        String str =input.toLowerCase();
        ArrayList<Integer> list = new ArrayList<Integer>();
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='a' || ch[i]=='i' || ch[i]=='e' || ch[i]=='o' || ch[i]=='u'){
                vowelcount++;
            }
            else consonantsCount++;
        }
        list.add(vowelcount);
        list.add(consonantsCount);
    return list;
    }

}
