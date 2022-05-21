import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

class Problem1 {
    static int[] hexToRgb(String Hex) {
        String[] digit = Hex.split("(?<=\\G.{2})");
        return Arrays.stream(digit).mapToInt(Integer::parseInt).toArray();
    }

    static String yourOrderPlease(String string) {
        return Arrays.stream(string.split(" "))
                .sorted(Comparator.comparing(e -> Integer.valueOf(e.replaceAll("\\D", ""))))
                .reduce((a, b) -> a + ' ' + b).get();
    }

    static String duplicateEncoder(String string) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (string.indexOf(string.charAt(i)) == string.lastIndexOf(string.charAt(i)))
                sb.append('(');
            else
                sb.append(')');
        }

        return sb.toString();
    }

    static String[] splitString(String string) {
        String[] splitted = string.split("(?<=\\G.{2})");
        if (string.length() % 2 != 0)
            splitted[splitted.length - 1] += '_';
        return splitted;
    }

    static List<Integer> sumConsecutive(List<Integer> list) {
        List<Integer> sumConsecutive = new ArrayList<>();
        int state = list.get(0), sum = 0;

        for (int integer : list) {
            if (integer == state)
                sum += integer;
            else {
                sumConsecutive.add(sum);
                state = sum = integer;
            }
        }
        sumConsecutive.add(sum);
        return sumConsecutive;
    }

    static int vowelCount(String string) {
        return string.replaceAll("[^aeiou]", "").length();
    }

    static int countTheSmileyFaces(List<String> arr) {
        return (int) arr.stream()
                .filter(s -> s.matches("[:;][-~][)D]"))
                .count();
    }

    static int persistenceBugger(long n) {
        String store = String.valueOf(n);
        int count = 0;

        while (store.length() > 0) {
            store = String.valueOf(Arrays.stream(store.split(""))
                    .mapToLong(Long::parseLong)
                    .reduce(1, (a, b) -> a * b));
            count++;
        }

        return count;
    }

    static boolean scramble(String s1, String s2) {
        String reset = s1.replaceAll("[" + s2 + "]", "");
        for (int i = 0; i < s2.length(); i++) {
            if (!(reset.contains(String.valueOf(s2.charAt(i)))))
                return false;
            else
                reset = reset.replaceFirst(String.valueOf(s2.charAt(i)), "");
        }
        return true;
    }

    static String stringMerge(String s1, String s2, char l) {
        return s1.substring(0, s1.indexOf(l)) + s2.substring(s2.indexOf(l));
    }

    static int[] sortOdd(int[] t) {
        int[] odd = Arrays.stream(t).filter(e -> e % 2 != 0).toArray();
        Arrays.sort(odd);

        for (int i = 0, c = 0; i < t.length; i++) {
            if ((t[i] % 2) != 0)
                t[i] = odd[c++];
        }
        return t;
    }

    static int[] arrayDiff(int[] t1, int[] t2) {
        List<Integer> l = Arrays.stream(t2).boxed().toList();
        return Arrays.stream(t1).filter(e -> !l.contains(e)).toArray();
    }

    static boolean isPerfectNumber(int n) {
        int square = (int) Math.sqrt(n);
        return square * square == n;
    }

    static String reverseWords(final String original) {
        if (original.trim().equals(""))
            return original;
        String[] words = original.split(" ");
        return Arrays.stream(words).map(w -> new StringBuilder(w).reverse()).collect(Collectors.joining(" "));
    }

    static /*List<Integer>*/ void buildUpToSquareSums(int n) {
        ArrayList<Integer> integers = new ArrayList<>();
        IntStream.range(1, n + 1).forEach(integers::add);
        List<Integer> built = new ArrayList<>();
        int operations = 0;
        int squared = 0;

//        integers.forEach(System.out::println);
        for (int j = 0; j < integers.size(); j ++) {
            operations = integers.get(j) + integers.get(0);
            squared = (int) Math.sqrt(operations);
            if (squared * squared == operations) {
                Collections.addAll(built, integers.get(0), integers.get(j));
                integers.remove(0);
                integers.remove(j);
                j = 0;
            }
        }

        built.forEach(System.out::println);
    }

    static int multipleOfThreeOrFive(int number) {
        return (int) IntStream.range(0, number).filter(e -> e % 3 == 0 || e % 5 == 0).sum();
    }

    static int digitalRoot(int n) {
        String s = String.valueOf(n);
        while (s.length() > 1) {
            s = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).reduce(Integer::sum).stream().mapToObj(String::valueOf).collect(Collectors.joining());
        }
        return Integer.parseInt(s);
    }

    static boolean detectPangram(String string) {
        string = string.toLowerCase().replaceAll("[\\W]", "");
        return Arrays.stream(string.split("")).distinct().count() == 26;
    }

    static String whereIsMyParent(final String text) {
        if (text.equals(""))
            return text;
        StringBuilder s = new StringBuilder();
        String string = Arrays.stream(text.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());

        char c = string.charAt(0);
        s.append(Character.toString(c).toUpperCase());

        for (int i = 1; i < string.length(); i ++) {
            if (c != string.charAt(i)) {
                c = string.charAt(i);
                s.append(Character.toString(c).toUpperCase());
            } else {
                s.append(string.charAt(i));
            }
        }
        return s.toString();
    }


    public static void main(String[] args) {
        System.out.println(whereIsMyParent("AaaaaZazzz"));
    }
}