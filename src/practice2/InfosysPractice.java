package practice2;

import java.nio.CharBuffer;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfosysPractice
{
    public static void main(String[] args) {

        anagram();

        List<String> strList = Arrays.asList("apple", "banana", "apple");

        Map<String, Long> listMap = strList.parallelStream().peek(thr -> System.out.println(Thread.currentThread().getName())).collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(listMap);

        List<Integer> num = Arrays.asList(1,2,8,9,0);

        Map<Boolean, List<Integer>> listMap1 = num.stream().collect(Collectors.partitioningBy(w -> w %2 == 0));

        System.out.println(listMap1);

        String st = "java";

        Map<Character, Long> characterLongMap = st.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(characterLongMap);

        Map<Integer, List<String >> charCounting = strList.stream().collect(Collectors.groupingBy(String :: length));

        System.out.println("charCounting " + charCounting);

        Optional<Character> characterLong = st.chars().mapToObj(c -> (char)c).filter(fil -> st.indexOf(fil) != st.lastIndexOf(fil)).findFirst();
        characterLong.ifPresent(System.out::println);

        System.out.println(Thread.currentThread().getName());

        try
        {
            Runnable r = ()-> {
                System.out.println(":::::::::::::::::::::::");
                System.out.println(Thread.currentThread().getName());
            };

            new Thread(r).start();

            List<Character> characterList = st.chars().mapToObj(c -> (char)c).collect(Collectors.toList());

            int sum = st.chars().sum();

            int[] arr = {1,5,3,2};

            int n = arr.length + 1;

            int actualSum = (n * (n+1)) /2;

            int expectedSum = Arrays.stream(arr).sum();

            int missingNum = actualSum - expectedSum;

            System.out.println(missingNum);


            int[] array = {2, 7, 4, 5, 3, 6, 1, 8, 0, 9};
            int targetSum = 9;

            Map<Boolean,List<Integer>> part = Arrays.stream(array).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));

            HashSet<Integer> seen = new HashSet<>();
            List<List<Integer>> pairs = IntStream.of(array)
                    .boxed()
                    .flatMap(number -> {
                        int complement = targetSum - number;
                        if (seen.contains(complement)) {
                            return Stream.of(Arrays.asList(complement, number));
                        } else {
                            seen.add(number);
                            return Stream.empty();
                        }
                    })
                    .collect(Collectors.toList());

            pairs.forEach(System.out::println);

            String binaryNumber = Integer.toBinaryString(12);
            System.out.println(binaryNumber);

            Integer i =90;
            System.out.println(i.intValue());


            String x = "programmingLanguage";

            Map<Character, Long> sortedCount = x.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(cha -> cha, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));


            System.out.println(sortedCount);

            List<String> listOfString = Arrays.asList("This is DB", "This is programming language");

            String targetWord = "is";
            long totalCount = listOfString.stream()
                    .flatMap(str -> Arrays.stream(str.split("\\s+")))
                    .filter(word -> word.equals(targetWord))
                    .count();

            int nn = 234;

            long productInt = String.valueOf(nn).chars()
                    .map(Character::getNumericValue).reduce((i1, i2) -> i1 * i2).orElse(0);

            long sumInt = String.valueOf(nn).chars().map(Character :: getNumericValue).reduce(Integer::sum).orElse(0);



            System.out.println(productInt - sumInt);

            int[][] ar4 = {{1,0}};

            System.out.println(":::::: " + Arrays.toString(findOrder(2, ar4)));

        }

        catch (Exception e)
        {

        }

        System.out.println(isValid("({{{{}}}))"));

        String[] sar = {"i","love","leetcode","i","love","coding"};

        System.out.println(topKFrequent(sar, 2));
    }
    public static boolean isValid(String s) {

        char[] charArray = s.toCharArray();

        Stack<Character> characterStack = new Stack<>();
        AtomicReference<Boolean> ab = new AtomicReference<>(false);

           s.chars().mapToObj(c -> (char)c).forEach(ca -> {
            if(Objects.equals(ca, '(') || Objects.equals(ca, '{') || Objects.equals(ca, '['))
            {
                characterStack.push(ca);
            }
            else {

                if(characterStack.isEmpty() || (Objects.equals(ca, ')') && !Objects.equals(characterStack.pop(), '(')) || (Objects.equals(ca, '}') && !Objects.equals(characterStack.pop(), '{')) || (Objects.equals(ca, ']') && !Objects.equals(characterStack.pop(), ']')))
                {
                    ab.set(Boolean.FALSE);

                }
                else
                {

                     if(Objects.equals(ab.get(), Boolean.FALSE))
                         ab.set(Boolean.FALSE);
                     else
                    ab.set(Boolean.TRUE);
                }
            }
        });

        return ab.get() && characterStack.isEmpty();
    }

    public static List<String> topKFrequent(String[] words, int k) {

        List<String> countWords = Arrays.stream(words).collect(Collectors.groupingBy(cnt -> cnt, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry::getKey)).map(e -> e.getKey()).collect(Collectors.toList());

        Map<String, Long> countWordsMap = Arrays.stream(words).collect(Collectors.groupingBy(cnt -> cnt, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry::getKey)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));

        System.out.println(countWordsMap);
        List<String> l = countWords.stream().limit(k).collect(Collectors.toList());

        System.out.println(l);

        return null;
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        if(prerequisites.length == 0)
        {
            int[] ar = new int[numCourses];

            for(int i =0 ; i<ar.length; i++)
            {
                ar[i] = i;
            }

            return Arrays.stream(ar).boxed().sorted(Comparator.reverseOrder()).mapToInt(m -> m).toArray();

        }

        Set<Integer> si = Arrays.stream(prerequisites).map(m -> {


            int[] arrr = Arrays.stream(m).boxed().sorted(Comparator.reverseOrder()).mapToInt(m12 -> m12).toArray();

            return arrr;
        }
    ).peek(System.out::println).flatMap(flatMp -> Arrays.stream(flatMp).boxed()).collect(Collectors.toSet());

        return si.stream().limit(numCourses).mapToInt(mi -> mi).toArray();

    }

    public static void anagram ()
    {
        List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "god", "dog");

        Map<String, List<String>> groupedAnagrams = words.stream().peek(System.out::println)
                .collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    System.out.println("::::::::::::::::::::---------> " + Arrays.toString(chars) + word);
                    return new String(chars);
                }));


        System.out.println(groupedAnagrams);
        List<List<String>> anagramGroups = new ArrayList<>(groupedAnagrams.values());
        System.out.println("Anagram Groups: " + anagramGroups);
    }
    }



