import java.util.Arrays;

public class OnlyReadableOnceList {
    private int[] base;

    public OnlyReadableOnceList(int[] base) {
        this.base = base;
    }

    private void setBase(int[] newBase) {
        this.base = newBase;
    }

    public int get(int index) {
        int r = this.base[index];
        setBase(Arrays.stream(this.base).filter(e -> e != this.base[index]).toArray());
        return r;
    }

    public int size() {
        return this.base.length;
    }

    public String toString() {
        StringBuilder c = new StringBuilder();
        c.append("[");
        for (int i = 0; i < this.base.length; i++) {
            c.append(this.base[i]);
            if (i != this.base.length - 1)
                c.append(",");
        }
        c.append("]");
        setBase(new int[]{ });
        return c.toString();
    }
}
