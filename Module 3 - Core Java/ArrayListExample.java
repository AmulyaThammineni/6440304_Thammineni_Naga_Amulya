import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Enter a student name (or 'exit' to stop): ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("exit")) {
                names.add(input);
            }
        } while (!input.equalsIgnoreCase("exit"));

        System.out.println("Names entered:");
        for (String name : names) {
            System.out.println(name);
        }

        scanner.close();
    }
}
