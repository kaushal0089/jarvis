package in.kkd.collectionconcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solutions {

    public static void duplicateZeros(int[] arr) {
        int[] duplicateArr = new int[arr.length];
        for(int i=0;i<arr.length-1;i++){
            System.out.println("element is"+arr[i]);
            if(arr[i]==0){
                for(int j=arr.length-1;j>i;j--){
                    arr[j]=arr[j-1];
                }
                i++;
            }

        }
            System.out.println(Arrays.toString(arr));
    }

    public static void removeEvenNumber(int[] arr){
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,1,5,6,1,1,9));
//        list.removeIf(num -> num % 2 == 0);
        list.retainAll(Collections.singleton(1));
        System.out.println(list);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++) {
                if (nums2[i] < nums1[j]){

                }
            }
        }
    }

    public static void main(String[] args){
        int[] ar1 = new int[]{1,2,3,0,0,0};
        int[] ar2 = new int[]{2,5,6};
//        duplicateZeros(ar);
//        removeEvenNumber(ar);
          merge(ar1,ar1.length,ar2,ar2.length);
//        System.out.println("result array is: "+ Arrays.toString(result));
    }

}