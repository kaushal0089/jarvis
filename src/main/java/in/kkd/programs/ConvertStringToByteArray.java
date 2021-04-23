package in.kkd.programs;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ConvertStringToByteArray {
    public static void main(String[] args){
        String str = "Kaushal";
        byte[] arr = str.getBytes();
        System.out.println("Byte arrays"+ Arrays.toString(arr));
        for (byte b :arr) {
            System.out.println("Arrays print "+b);
        }
    }
}
