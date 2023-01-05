package InterfaceTest;

public class UseFunctions implements Functions{
    @Override
    public void add(int a, int b) {
        System.out.println(a+b);
    }

    @Override
    public int sum(int a, int b) {
        return a+b;
    }
}
