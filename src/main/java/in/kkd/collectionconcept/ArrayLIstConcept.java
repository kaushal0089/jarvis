package in.kkd.collectionconcept;

//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayLIstConcept {

    public static void main(String[] args){
    ArrayList ar1 = new ArrayList();
    ar1.add("hello");
    ar1.add("1");

        System.out.println(ar1);
        System.out.println(ar1.get(0));
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("test");

        Employee e1 = new Employee("kkd",28,"QA");
        Employee e2 = new Employee("sanjay",30,"Dev");

        ArrayList<Employee> emp = new ArrayList<Employee>();
        emp.add(e1);
        emp.add(e2);
        Iterator<Employee> it = emp.iterator();
        while (it.hasNext()){
            Employee e = it.next();
            System.out.println("Name is "+e.name);
            System.out.println("age is"+e.age);
        }

        ar1.stream().forEach(ele -> System.out.println("printed from stream:-"+ele));

        ArrayList<Integer> arList = new ArrayList<Integer>(Arrays.asList(10,20,30,40));
        System.out.println(arList);

        //ArrayList<String> languages = new ArrayList<String>(Arrays.asList("Java","test");

    }


}
