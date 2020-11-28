package runtime;

public class ClinitTest {
    int anInt;
    private static int num = 1;
    private static int number = 10;
    static
    {
        number = 20;
    }



    public static void main(String[] args) {
        System.out.println(number);

    }
}

