package practice2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfosysPractice1
{

    private static  void anagram()
    {
        List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "god", "dog");

        Map<String, List<String>> anagram = words.stream().collect(Collectors.groupingBy(g -> {

            char[] ch = g.toCharArray();
            Arrays.sort(ch);

            return new String(ch);
        }));

        int[] arr = {12, 35, 1, 0, 34 , 1};

        System.out.println(getSecondLargest(arr));

        System.out.println(new ArrayList<>(anagram.values()));
    }

    private static void separateLetterAndNumber()
    {
        String input = "abc123def456";

        List<Character> letters = input.chars().mapToObj(mob -> (char)mob).filter(Character::isLetter).toList();

        List<Integer> digit = input.chars().mapToObj(mto -> (char)mto).filter(Character::isDigit).map(Integer::valueOf).toList();

        System.out.println(new ArrayList<>() {{
            add(letters);
            add((digit));
        }});
    }

    public static void allZerosInLast()
    {
        int[] a = {1,5,0,3,0,12,6};

       int[] b = IntStream.concat(Arrays.stream(a).filter(f -> !Objects.equals(f, 0)), Arrays.stream(a).filter(f -> Objects.equals(f, 0))).toArray();

        System.out.println(Arrays.toString(b));
    }
    public static int getSecondLargest(int[] arr) {

        int[] secondLargest = Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).mapToInt(m -> m).toArray();

        if(secondLargest.length <=1)
        {
            return -1;
        }
        else
        {
            return Arrays.stream(secondLargest).skip(1).findFirst().orElse(0);
        }
    }

    private static void targetArray()
    {
        int[] arr = {2,3,4,6,5,7};
        int target = 9;

        HashSet<Integer> hs = Arrays.stream(arr).boxed().collect(Collectors.toCollection(HashSet::new));

        List<List<Integer>> lis = Arrays.stream(arr).boxed().flatMap(fl -> {

            int num = target - fl;
             if(hs.contains(num))
            {
             return Stream.of(Arrays.asList(num, fl));
            }
             else {
                 return Stream.empty();
             }
        }).toList();

        System.out.println(lis);
    }

    private static void nonRepeatingNumber()
    {
        int[] arr = {2,3,2,4,5,5,6};

        //approach 1
        Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(m -> m, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue()).takeWhile(dw -> Objects.equals(dw.getValue(),1L)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap :: new));
        long l = map.keySet().stream().limit(1).toList().getFirst();

        System.out.println(l);
        System.out.println(map);

        //approach 2
        List<String> ele = Arrays.stream(arr).mapToObj(String::valueOf).toList();
        String st = ele.stream().filter(f -> ele.indexOf(f) == ele.lastIndexOf(f)).findFirst().orElse("0");

        System.out.println(st);
    }

    private static void rotateArray()
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int roteTimes = 3;



        //approach 1
        int[] ar = IntStream.concat(Arrays.stream(arr).skip(arr.length - roteTimes),
                                    Arrays.stream(arr).limit(arr.length - roteTimes)).toArray();

        System.out.println(Arrays.toString(ar));

        //approach 2
        String ar1 = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(""));
        String ar2 = ar1.substring(0, ar1.length() - roteTimes);
        String ar3 = ar1.substring(ar2.length());
        System.out.println(ar3 + ar2);



    }

    public static void main(String[] args) {

        InfosysPractice1.anagram();
        InfosysPractice1.separateLetterAndNumber();
        InfosysPractice1.allZerosInLast();
        InfosysPractice1.targetArray();
        InfosysPractice1.rotateArray();
        InfosysPractice1.nonRepeatingNumber();
    }
}
