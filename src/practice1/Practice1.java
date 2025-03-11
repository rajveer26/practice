package practice1;

import practice2.Practice2;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Practice1 implements Serializable {


   /* public static Double d1(Double dd)
    {
        System.out.println(Thread.currentThread().getName() + " " + dd + " double");

        return dd;
    }*/
    public static void d1(Float d2)
    {
        System.out.println(Thread.currentThread().getName() + " " + d2 + " float");

    }

    public static String s = "rajveer";
    public String s1 = "rajveer";

    public void test()
    {
        System.out.println(this.s);
    }

    public static void main(String[] args) {

        List<Integer> listnt = new ArrayList<>();
        listnt.add(2);
        listnt.add(1);
        listnt.add(3);

        List<Integer> lst = listnt.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());

        System.out.println(lst);

       //Practice1.d1(Float.valueOf(23.9));
        System.out.println(0.0/0.0);

        Integer i = new Integer(5);

        i.intValue();

        int[] arr = {1,2,3,4};

        ArrayList<Integer> al = new ArrayList<>(2);

        Optional<Integer> max1 = Arrays.stream(arr).boxed().max(Comparator.naturalOrder());

        max1.ifPresent(al::add);

        Optional<Integer> max2 = Arrays.stream(arr).boxed().filter(f -> !al.contains(f)).max(Comparator.naturalOrder());

        max2.ifPresent(al::add);

        Optional<Integer> pro = al.stream().reduce((a,b) -> a * b);

        pro.ifPresent(System.out::println);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(Integer.valueOf(1));
        System.out.println(":::::::" + list);

        try {
            throw new Error("Error occurred");
        } catch (Exception e) {
            System.out.println("Caught Exception");
        } finally {
            System.out.println("Finally block executed");
        }
    }
    }

