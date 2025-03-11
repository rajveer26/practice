import java.util.*;

public class Test
{
    public void m1()
    {
        ArrayList<Integer> al = new ArrayList<>(5);

        Map<String, Integer> map = new IdentityHashMap<>();//In case of hashMap jvm uses .equals() to
                                                           //check duplicate keys and in case of
                                                           //IdentityHashMap jvm uses == operator to check
                                                        //duplicates

        map.put("A", 12);
        map.put(new String("A"), 13);

        map.forEach((key, value) -> {
            System.out.println(key);
        });

        System.out.println(map.entrySet());//set representation of a map
        System.out.println(map);

        String sbil = "I Love Java";

        List<String> words = Arrays.asList(sbil.split(" "));
        Collections.reverse(words);
        System.err.println(String.join(" ", words));

        Map<StringBuffer ,Integer> map1 = new HashMap<>();
         StringBuffer s1 = new StringBuffer("a");

         map1.put(s1,2);
         map1.put(null,7);
         map1.put(s1, 9);
         map1.put(null, 8);

          s1= null;
          System.gc();
        //System.out.println(map1);


    }

    public static void main(String[] args) {

        Test t = new Test();
        t.m1();
    }
}
