package practice2;

import practice1.Practice1;

import java.util.*;
import java.util.stream.Collectors;

public class Practice2 extends Practice1
{
    static String s = "rajveer";
    public void ok() {
        List<List<Long>> nums = new ArrayList<>();

         nums.add(Arrays.asList(2L));
         nums.add(Arrays.asList(3L));

         Set<Long> set = new HashSet<>();
         set.add(2L);
         set.add(4L);

         List<Long> numLis = nums.stream().flatMap(n -> n.stream().filter(set::contains)).collect(Collectors.toList());

         System.err.println(numLis);

        System.out.println(this.s);

    }

    public static void main(String[] args) {
        Practice2 practice2 = new Practice2();

        System.out.println(Practice1.s);;
    }
}
