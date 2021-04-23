package in.kkd.programs;

import java.util.Arrays;

public class AnagramString {
    public static void main(String[] args){
        String s1 = "keep";
        String s2 = "eekp";
        if(checkAnagram(s1,s2)){
            System.out.println("Strings are anagrma");
        }
        else System.out.println("Not anagram strings");
    }

    public static Boolean checkAnagram(String s1, String s2){
        Boolean b = false;
        if(s1.length()!=s2.length())return false;
        int maxlen = 0;
        if(s1.length()<s2.length())maxlen = s2.length();
        else if (s1.length()>s2.length())maxlen = s1.length();
        else maxlen = s2.length();
        for(int i=1;i<maxlen;i++){
            String c = String.valueOf(s1.charAt(i));
            if(s2.contains(c)){
                b = true;
            }
            else {b=false;}
        }
        return b;
    }

    public static Boolean checkAnagramWithArray(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if(c1.length!=c2.length){
            return false;
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        Boolean b = Arrays.equals(c1,c2);
        return b;
    }
}
