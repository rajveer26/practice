import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        //String
        String s = "rajveer";
        String s1 = new String("rajveer");
        System.out.println(s==s1);

        //Long
        Long l1 =127l;
        Long l2 = 127l;
        System.out.println(l1==l2);

        //Integer
        Integer i1 = 128;
        Integer i2 =128;
        System.out.println(i1==i2);

        //Boolean
        Boolean b = Boolean.valueOf("TRUE");
        Boolean b1 = Boolean.valueOf("ok1");
        System.out.println(b.equals(b1));

        final StringBuffer sb = new StringBuffer("ok1");//final means reference variable cannot refer
                                                        //to any other object
        sb.append("p");
        System.out.println(sb);

         String st = "welcome to the company";

         Boolean bb = st.startsWith("to", 8);

         System.out.println(bb);

          float f2 = 'b';

          System.out.println(f2);

          List<Integer> list = Arrays.asList(2, 3, 4, 6);

        Stream<Integer> integerStream = list.stream().filter(f -> f.equals(2));

        System.out.println("====>" + integerStream);

        list = Stream.of(list.stream(), Stream.of(4, 5)).flatMap(Function.identity()).collect(Collectors.toList());

          System.out.println(list);

          Stream<Integer> stream1 = Stream.of(list.stream(), Stream.of(8,9)).flatMap(Function.identity());

         Integer intMax = stream1.max(Integer :: compareTo).orElse(0);
         System.out.println(intMax);

         //one stream can be consumed only once intMax has already consumed the stream
        //List<Integer> ii2 =  stream1.sorted(Comparator.comparing(Integer :: intValue).reversed()).collect(Collectors.toList());

         //System.out.println(ii2);

        byte byt = 2 + 3;
        System.err.println(byt);

        byte byt1 = 2;
        byte byt2 =3;

        //byte byt3 = byt1 + byt2;

        String sc1 ="Rajveer";
        StringBuffer sb1 = new StringBuffer("Rajveer");

        System.out.println(sc1.equals(sb1));

        Integer iis = new Integer(23);
        Integer iis1 = new Integer(23);
        Integer ii3 = new Integer(23);

//        Long l12 = 3;
        Long l13 = 12L;
        Integer i13 = 12;
       // System.out.println(l13.equals(i13));

        System.out.println(iis.hashCode());//when ever equals() method is override, compulsory we should override
                                           //hashCode method also in such a way equivalent objects must have same hashCode value

         //the parameters used to override .equals same should be used to override hash code value
        //if 2 objects are not equal by .equals methods then there is no restriction on hasCodes may be equal or may not be equal
        System.out.println(iis1.hashCode());
        System.out.println(ii3.hashCode());


        Class<?> c = Class.forName("java.lang.Object");

        String s123 = new String("rajveer"); //in this case s123 will refer to the object created in heap area
        String s345 = "rajveer1";// in this case s345 will refer to the object creted in SCP area
        String s234 = "rajveer1";
        System.out.println("---------------------------------");
        System.out.println(s345 == s234);
        List<Method> methods = Arrays.stream(c.getDeclaredMethods()).collect(Collectors.toList());

        System.out.println(methods);

        Integer[] i = {2,3,4};
        int[] ip = {2,3,4};

       Stream<Integer> iy =  Arrays.stream(i);

        String st67 = "Rajveer";
        String st68 = "RajveerP";
        String st70 = st67.concat("P");
        System.out.println("---------" + st70);
        System.out.println( st70==st68 );

        int ik= 7;
        String.valueOf(ik);

    }
}