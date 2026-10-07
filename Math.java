public class Math {
    private int a, b;
    private static int count = 0;

    {
        a = b = 1;
    }

    public Math() {
        count++;
    }

    public Math(int number) {
        this(number, number);
    }

    public Math(int a, int b) {
        if (a <= 0 || b <= 0) {
            System.out.println("Числа мають бути натуральними (більшими за нуль).");
            System.exit(0);
        }
        this.a = a;
        this.b = b;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public int gcd() {
        int x = a, y = b;
        while (y != 0) {
            int remainder = x % y;
            x = y;
            y = remainder;
        }
        return x;
    }

    public long lcm() {
        return a / gcd() * b;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Math)) return false;
        Math other = (Math) obj;
        return a == other.a && b == other.b;
    }

    @Override
    public String toString() {
        return "Math(" + a + ", " + b + ")";
    }
}