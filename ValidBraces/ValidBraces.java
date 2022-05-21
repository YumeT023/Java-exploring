package ValidBraces;


import java.util.*;

public class ValidBraces {

    private static String splice(String s, int begin) {
        if (s.length() <= 1)
            return "";
        else
            return new StringBuffer(s.substring(0, begin)).append(s.substring(begin + 2)).toString();
    }

    static boolean validParentheses(String p) {
        int i = 0, j = 1;
        while (j < p.length()) {
            if (p.charAt(i) == '(') {
                if (p.charAt(j) == ')') {
                    p = splice(p, i);
                    i = 0;
                    j = 1;
                } else {
                    i = j++;
                }
                continue;
            }
            return false;
        }

        return p.length() == 0;
    }

    static boolean validBraces(String p) {
        int i = 0, j = 1;
        Map<Character, Character> bracesComp = new HashMap<>();
        bracesComp.put('(', ')'); bracesComp.put('{', '}'); bracesComp.put('[', ']');

        while (j < p.length()) {
            if (Character.toString(p.charAt(i)).matches("[({\\[]")) {
                if (p.charAt(j) == bracesComp.get(p.charAt(i))) {
                    p = splice(p, i);
                    i = 0;
                    j = 1;
                } else if (p.charAt(j) != bracesComp.get(p.charAt(i))) {
                    if (Character.toString(p.charAt(j)).matches("[)}\\]]")) {
                        return false;
                    } else {
                        i = j ++;
                    }
                }
                continue;
            }
            return false;
        }

        return p.length() == 0;
    }
}