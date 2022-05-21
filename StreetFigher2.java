public class StreetFigher2 {
    private static int[] getPos(String move, int[] pos) {
        if (move.equals("up"))
            return pos[0] == 0 ? pos : new int[]{0, pos[1]};
        if (move.equals("down")) {
            return pos[0] == 1 ? pos : new int[]{1, pos[1]};
        }
        if (move.equals("left")) {
            return pos[1] == 0 ? new int[]{pos[0], 5} : new int[]{pos[0], pos[1] - 1};
        }
        if (move.equals("right")) {
            return pos[1] == 5 ? new int[]{pos[0], 0} : new int[]{pos[0], pos[1] + 1};
        }

        return new int[]{ };
    }

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
        int[] res;
        String[] characters = new String[moves.length];

        for (int i = 0; i < moves.length; i ++) {
            res = getPos(moves[i], position);
            characters[i] = fighters[res[0]][res[1]];
            position = new int[]{res[0], res[1]};
        }
        return characters;
    }
}
