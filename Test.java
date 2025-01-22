import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Grid2<String> thing = new Grid2<>(new File("input.txt"), String.class);
        System.out.println(thing);
    }
}
