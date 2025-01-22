import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grid2<E> {
    public class dir {
        public static final int N = 0;
        public static final int E = 1;
        public static final int S = 2;
        public static final int W = 3;

        public static int ccw(int dir) {
            return Math.floorMod(dir - 1, 4);
        }
    
        public static int cw(int dir) {
            return (dir + 1) % 4;
        }
    
        public static int rev(int dir) {
            return (dir + 2) % 4;
        }
    }
    private List<List<E>> grid;
    private int height, width;
    private Class<E> type;

    // public static List<Grid> split(List<String> in, String s) {
    //     List<Grid> grids = new ArrayList<>();
    //     while(in.indexOf(s) > 0) {
    //         grids.add(new Grid(in.subList(0, in.indexOf(s))));
    //         in = in.subList(in.indexOf(s)+1, in.size());
    //     }
    //     return grids;
    // }

    /**
     * Constructs a new Grid
     * @param file to read
     * @param type for casting
     * @throws FileNotFoundException when no file
     */
    public Grid2(File file, Class<E> type, String rowDel, String colDel) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String s = "";
        while(scan.hasNextLine()) { s += scan.nextLine() + "\n"; }
        String[] rows = s.split(rowDel);

        grid = new ArrayList<>();
        for(String str : rows) {
            List<E> list = new ArrayList<>();
            try {
                for(E e : (E[])str.split(colDel)) {
                    list.add(e);
                }
            } catch(Exception e) {
                throw new IllegalStateException("File cannot be put into Grid of type "+type.descriptorString());
            }
            grid.add(list);
        }
        updateSize();
        scan.close();
    }
    public Grid2(File file, Class<E> type) throws FileNotFoundException {
        this(file, type, "\n", "");
    }
    
    public static List<String> read(String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        List<String> input = new ArrayList<>();
        while(file.hasNextLine()) { input.add(file.nextLine()); }
        return input;
    }

    // public char get(int r, int c) { return grid.get(r).get(c); }
    // public char get(C coord) { return get(coord.v0, coord.v1); }
    // public C get(char get) {
    //     for(int r = 0; r < height; r++) {
    //         for(int c = 0; c < width; c++) {
    //             if(get(r, c) == get) {
    //                 return new C(r, c);
    //             }
    //         }
    //     }
    //     return new C(-1, -1);
    // }

    // public int height() { return height; }
    // public int width() { return width; }
    
    // public void set(int r, int c, char x) { grid.get(r).set(c, x); }
    // public void set(C coord, char x) { set(coord.v0, coord.v1, x); }

    // public boolean valid(int r, int c) { return 0 <= r && r < height && 0 <= c && c < width; }
    // public boolean valid(C coord) { return valid(coord.v0, coord.v1); }

    // public void rotateCW() {
    //     List<List<Character>> g = new ArrayList<>();
    //     for(int c = 0; c < width; c++) {
    //         List<Character> col = new ArrayList<>();
    //         for(int r = height-1; r >= 0; r--) {
    //             col.add(get(r, c));
    //         }
    //         g.add(col);
    //     }
    //     grid = g;
    //     updateSize();
    // }

    // public void rotateCCW() {
    //     List<List<Character>> g = new ArrayList<>();
    //     for(int c = width-1; c >= 0; c--) {
    //         List<Character> col = new ArrayList<>();
    //         for(int r = 0; r < height; r++) {
    //             col.add(get(r, c));
    //         }
    //         g.add(col);
    //     }
    //     grid = g;
    //     updateSize();
    // }

    // public void transpose() {
    //     List<List<Character>> g = new ArrayList<>();
    //     for(int c = 0; c < width; c++) {
    //         List<Character> toRow = new ArrayList<>();
    //         for(int r = 0; r < height; r++) {
    //             toRow.add(get(r, c));
    //         }
    //         g.add(toRow);
    //     }
    //     grid = g;
    //     updateSize();
    // }

    // public List<String> getRows() {
    //     List<String> out = new ArrayList<>();
    //     for(List<Character> c : grid) {
    //         out.add(c.toString().replaceAll("[\\[\\], ]", ""));
    //     }
    //     return out;
    // }

    // public List<Character> getRow(int row) {
    //     return grid.get(row);
    // }

    // public List<String> getCols() {
    //     List<String> out = new ArrayList<>();
    //     for(int col = 0; col < width; col++) {
    //         out.add(getCol(col).toString().replaceAll("[\\[\\], ]", ""));
    //     }
    //     return out;
    // }

    // public List<Character> getCol(int col) {
    //     List<Character> c = new ArrayList<>();
    //     for(List<Character> row : grid) { c.add(row.get(col)); }
    //     return c;
    // }

    public String toString() {
        String s = "";
        for(List<E> l : grid) {
            s += l.toString().replaceAll("[\\[\\],]", "") + "\n";
        }
        return s;
    }

    // public int hashCode() {
    //     return grid.hashCode();
    // }

    // public boolean equals(Object other) {
    //     return other instanceof Grid && Arrays.equals(((Grid)other).grid.toArray(), this.grid.toArray());
    // }

    private void updateSize() {
        width = grid.get(0).size();
        height = grid.size();
    }
}