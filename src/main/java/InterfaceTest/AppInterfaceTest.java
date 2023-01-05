package InterfaceTest;

public class AppInterfaceTest {
    static UseFunctions useFunctions = new UseFunctions();
    public static void main(String[] args) {
        useFunctions.add(3,4);
        System.out.println(useFunctions.sum(3,4));
    }
}
