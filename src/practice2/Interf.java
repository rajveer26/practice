package practice2;
public interface Interf
{
    static void m1()
    {
        System.out.println("ok");
    }

    int sum(int m1, int m2);
    
    default void m2()
    {
        System.out.println("ok2");
    }
    public static void main(String[] args) {

        Interf.m1();

    }
}
