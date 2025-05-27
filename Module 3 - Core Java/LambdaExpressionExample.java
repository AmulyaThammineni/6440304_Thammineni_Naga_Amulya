import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Amulya");
        names.add("Zara");
        names.add("John");
        names.add("Alice");

        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));

        for (String name : names) {
            System.out.println(name);
        }
    }
}
