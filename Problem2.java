import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.stream.Collectors;

public class Problem2 {
    static int twiceLinear(int n) {
        ArrayList<Integer> c = new ArrayList<>();
        c.add(1);
        int y, z, e = 0, f = 0;

        while (c.size() <= n) {
            y = 2 * c.get(e) + 1;
            z = 3 * c.get(f) + 1;

            if (y > z) {
                c.add(z);
                f ++;
            } else if (y < z) {
                c.add(y);
                e ++;
            } else {
                c.add(y);
                e ++;
                f ++;
            }
        }
        // 0 1 . 3 4 . 6 7 . 9 10 .

        return c.get(n);
    }

    static int parityOutlier(int[] integers) {
        int[] odd = Arrays.stream(integers).filter(e -> e % 2 != 0).toArray();
        if (odd.length == 1)
            return odd[0];
        return Arrays.stream(integers).filter(e -> e % 2 == 0).sum();
    }

    static String toJadenCase(String phrase) {
        if (phrase == null || phrase.length() == 0)
            return null;
        return Arrays.stream(phrase.split(" ")).map(e -> {
            String s = e.substring(0, 1).toUpperCase();
            return s + e.substring(1);
        }).collect(Collectors.joining(" "));
    }

    static List<Integer> treeByLevels(Btree node) {
        if (node == null)
            return List.of();
        Queue<Btree> queue = new ArrayDeque<>();
        List<Integer> v = new ArrayList<>();

        queue.add(node);
        while(!queue.isEmpty())
        {
            Btree tmp = queue.poll();
            v.add(tmp.data);

            if(tmp.left!=null)
                queue.add(tmp.left);
            if(tmp.right!=null)
                queue.add(tmp.right);
        }
        return v;
    }

    static String breakCamelCase(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }
    
    static String rangeExtraction(int[] args) {
        StringBuffer sb = new StringBuffer();

        return sb.toString();
    }
}
