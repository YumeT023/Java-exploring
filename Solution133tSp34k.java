public class Solution133tSp34k {
    private static String parse(String v) {
        String c = v;
        v = v.toLowerCase();
        if (v.equals("a"))
            return "4";
        if (v.equals("e"))
            return "3";
        if (v.equals("l"))
            return "1";
        if (v.equals("m"))
            return "/^^\\";
        if (v.equals("o"))
            return "0";
        if (v.equals("u"))
            return "(_)";
        return c;
    }

    public static String encode(String source){
        // TODO - Encode the source string into a 133tSp34k string
        if (source == null)
            return "";
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            s.append(parse(Character.toString(source.charAt(i))));
        }
        return s.toString();
    }
}
