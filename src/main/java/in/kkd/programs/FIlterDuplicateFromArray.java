package in.kkd.programs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FIlterDuplicateFromArray {

    public static void main(String[] args){
        ArrayList<String> ar = new ArrayList<>();
        ar.add("test");
        ar.add("new");
        ar.add("software");
        ar.add("test");

        Set<String> filterList = new HashSet<>();
        filterList = filterDuplicate(ar);
        System.out.println(filterList);

    }
    public static Set<String> filterDuplicate(ArrayList<String> ar){

        final Set<String> resultSet = new HashSet<String>();
        final Set<String> tempset = new HashSet<String>();

        for(String item : ar){
//            if(!tempset.add(item)){
                resultSet.add(item);
//            }
        }
        return resultSet;
    }
}
