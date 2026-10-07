import java.util.Scanner;
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
        return (long) a / gcd() * b;
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
    public static void main(String[] args) {
        System.out.println("Тести Math:");
        Math numbers = new Math(12, 18);
        System.out.println("Числа: " + numbers);
        System.out.println("НСД: " + numbers.gcd()); // 6
        System.out.println("НСК: " + numbers.lcm()); // 36

        System.out.println("\nВведіть два натуральні числа:");
        Scanner scanner = new Scanner(System.in);
        Math entered = new Math(scanner.nextInt(), scanner.nextInt());
        System.out.println("Числа: " + entered);
        System.out.println("НСД: " + entered.gcd());
        System.out.println("НСК: " + entered.lcm());
        System.out.println("Кількість об'єктів: " + Math.getCount());
        scanner.close();
    }
}
