package in.kkd.collectionconcept;

import java.util.HashMap;
import java.util.Map;

public class MapConcepts {

    public static void main(String[] args){

        //HashMap is class implements the Map interface
        //extends AbstractMap
        //it contains only unique values
        //stores the value in key:value pair
        //it may have one null key and multiple null values
        // it doesn't maintain order
        //HashMap is not synchronised -- not thread safe
        //concurrent modification Exception -- fail fast

        Map<String,String> map = new HashMap<>();
        map.put("name","kkd");
        map.put("dep","QA");
        map.put("role","engineer");

        System.out.println("Map is "+map);
        System.out.println(map.get("dep2"));
        boolean bl = map.containsValue("QA");
        System.out.println(bl);
        Map<String, String> map1 = new HashMap<String, String>();
        map1.putAll(map);
        System.out.println(map1);

        map1.remove("role1");
        System.out.println(map1);

        HashMap<Integer, Employee> ehm = new HashMap<Integer, Employee>();

        Employee e1 = new Employee("kkd",28,"dep");
        Employee e2 = new Employee("sanjay",29,"dev");

        ehm.put(1,e1);
        ehm.put(2,e2);

        for (Map.Entry<Integer,Employee> me: ehm.entrySet()) {
            System.out.println(me.getKey());
            Employee e = me.getValue();
            System.out.println(e.name+" "+e.age+" "+e.dept);

        }



    }

}
