package in.kkd.programs;

import java.util.StringTokenizer;

public class removeExtraSpaceFromString {

    public static void main(String[] args){
        String input = "hello  how r   u  feeling   today";
        String[] arr = input.split(" ");
        StringTokenizer strToken = new StringTokenizer(input," ");
        StringBuilder strbuild = new StringBuilder();
        StringBuilder strbuild1 = new StringBuilder();

        while (strToken.hasMoreTokens()){
            String  token = strToken.nextToken();
//            System.out.println(token);
            strbuild.append(token).append(" ");
        }

        System.out.println("string is : "+strbuild.toString().trim());
        int count = 0;
        for(String str : arr){
            if(!str.equals("")) {
                System.out.println(str.trim());
                strbuild1.append(str.trim()).append(" ");
            }
        }
        System.out.println("count is "+count);

        System.out.println("string is : "+strbuild1.toString());
    }
}
