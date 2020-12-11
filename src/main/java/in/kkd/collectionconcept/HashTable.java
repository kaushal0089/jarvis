package in.kkd.collectionconcept;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class HashTable {

    public static void main(String[] args){
        //It is simislar to HashMap but HashTable is synchronised
        //stores the value on the basis of key-val
        //Key --> Object --> Hascode --> value
        //

        Hashtable ht = new Hashtable();
        ht.put(1,"kkd");
        ht.put(2,"sanjay");

        Hashtable h = new Hashtable();
        h = (Hashtable) ht.clone();

        System.out.println("value from ht"+ht);

//        h.clear();

        System.out.println("value from h "+h);
        if(ht.containsValue("kkd")){
            System.out.println("kkd is present");
        }

        // Print all the values from Hashtable using Enumeration
        Enumeration e = ht.elements();

        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

        //get all values from hashtable using entryset() set of hashtable value
        Set s = ht.entrySet();
        System.out.println(s);
        if (ht.equals(h)){
            System.out.println("both are equal");
        }

        //Get the value from key
        System.out.println(ht.get(1));
        System.out.println("the hascode value of ht is :"+ht.hashCode());

    }
}
