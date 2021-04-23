package in.kkd.programs;

public class FirstTwoMax {
    public static void main(String[] str){

        int [] arr = {10,50,30,40,20,70,60,90,5};
        int maxOne = 0;
        int maxTwo = 0;
        int len = arr.length;
        for(int number : arr){
            if(maxOne < number){
                maxTwo = maxOne;
                maxOne = number;
            }
            else if(maxTwo < number){
                    maxTwo = number;
            }
    }
        System.out.println("first max is : "+maxOne+" and second max is : "+maxTwo);
}
}

