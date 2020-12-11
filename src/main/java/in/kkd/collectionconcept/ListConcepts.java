package in.kkd.collectionconcept;

import java.util.Iterator;
import java.util.LinkedList;

public class ListConcepts {

    public static void main(String[] args){
    LinkedList<String> ll = new LinkedList<String>();
    ll.add("test");
    ll.add("test2");

    ll.addFirst("first");
    ll.addLast("last");
        System.out.println("Linked List Elements are :"+ll);

        System.out.println(ll.get(0));

        ll.set(0,"top");
        System.out.println(ll.get(0));

//        ll.removeFirst();
//        ll.removeLast();
//        ll.remove(1);

        System.out.println(ll);

        //for loop
        for (int i=0;i<ll.size();i++){
            System.out.println(ll.get(i));
        }

        //advanced for loop 

        System.out.println("Using advanced fol loop");
        for (String str : ll) {
            System.out.println(str);
        }
        //Iterator

        Iterator<String> it = ll.iterator();
        while(it.hasNext()){
            System.out.println("Iterator is : "+it.next());
        }
        //while loop
        int i=0;
        while(ll.size()>i){
            System.out.println("from while loop "+ll.get(i));
            System.out.println("size is "+ll.size());
            i++;
        }


    }

}
