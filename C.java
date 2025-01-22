// Coordinate
public class C extends T._2<Integer, Integer> {
    public final boolean ARRAY;

    public C(int v0, int v1, boolean array) {
        super(v0, v1);
        this.ARRAY = array;
    }
    public C(int v0, int v1) {
        this(v0, v1, true);
    }

    public void move(int dir) {
        switch(dir) {
            case Grid2.dir.N:
                if(ARRAY) { v0--; } else { v1++; }
                break;
            case Grid2.dir.E:
                if(ARRAY) { v1++; } else { v0++; }
                break;
            case Grid2.dir.S:
                if(ARRAY) { v0++; } else { v1--; }
                break;
            case Grid2.dir.W:
                if(ARRAY) { v1--; } else { v0--; }
                break;
        }
    }

    public C rel(int dir, int n) {
        C c = new C(v0, v1, ARRAY);
        for(int i = 0; i < n; i++) {
            c.move(dir);
        }
        return c;
    }

    public C rel(int dir) {
        return rel(dir, 1);
    }

    @Override
    public String toString() {
        return String.format(ARRAY ? "[%s][%s]" : "(%s, %s)", v0, v1);
    }

    @Override
    public int hashCode() {
        return 17*v0 + 31*v1;
    }
    
    @Override
    public boolean equals(Object other) {
        return other instanceof C && ((C)other).v0 == this.v0 && ((C)other).v1 == this.v1;
    }
}