import java.util.List;
import java.util.stream.Collectors;

public class RecordsExample {
    record Person(String name, int age) {
    }

    public static void main(String[] args) {
        Person p1 = new Person("Amulya", 22);
        Person p2 = new Person("John", 17);
        Person p3 = new Person("Alice", 25);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        List<Person> people = List.of(p1, p2, p3);
        List<Person> adults = people.stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.toList());

        adults.forEach(System.out::println);
    }
}
