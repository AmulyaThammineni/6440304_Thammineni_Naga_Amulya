import java.lang.reflect.*;

public class ReflectionExample {
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ReflectionExample");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter param : parameters) {
                System.out.println("  Param: " + param.getType());
            }

            // Invoke sayHello method
            if (method.getName().equals("sayHello")) {
                method.invoke(obj, "Amulya");
            }
        }
    }
}
