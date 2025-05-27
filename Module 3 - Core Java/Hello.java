public class Hello {
    public void greet() {
        System.out.println("Hello, Bytecode!");
    }

    public static void main(String[] args) {
        Hello h = new Hello();
        h.greet();
    }
}

/*
 * Compile the file
 * 
 * javac Hello.java
 * 
 * 
 * Inspect bytecode
 * 
 * javap -c Hello
 */