import java.util.Scanner;
public class Rational {
    private int a; // Чисельник
    private int b; // Знаменник
    private static int count = 0;

    {
        a = 0;
        b = 1;
    }

    public Rational() {
        count++;
    }

    public Rational(int a) {
        this(a, 1);
    }

    public Rational(int a, int b) {
        if (b == 0) {
            System.out.println("Знаменник не може бути нулем.");
            System.exit(0);
        }
        this.a = a;
        this.b = b;
        reduce();
        count++;
    }

    public static int getCount() {
        return count;
    }

    public int getChyselnyk() {
        return a;
    }

    public int getZnamennyk() {
        return b;
    }

    public Rational add(Rational other) {
        int chyselnyk = a * other.b + other.a * b;
        b *= other.b;
        a = chyselnyk;
        reduce();
        return this;
    }

    public Rational vidniaty(Rational other) {
        int chyselnyk = a * other.b - other.a * b;
        b *= other.b;
        a = chyselnyk;
        reduce();
        return this;
    }

    public Rational pomnozhyty(Rational other) {
        a *= other.a;
        b *= other.b;
        reduce();
        return this;
    }

    public Rational podilyty(Rational other) {
        if (other.a == 0) {
            System.out.println("Ділити на нуль не можна.");
            System.exit(0);
        }
        int chyselnyk = a * other.b;
        b *= other.a;
        a = chyselnyk;
        reduce();
        return this;
    }

    public boolean isEqual(Rational other) {
        return a * other.b == other.a * b;
    }

    public boolean isGreater(Rational other) {
        return a * other.b > other.a * b;
    }

    public boolean isLess(Rational other) {
        return a * other.b < other.a * b;
    }

    private void reduce() {
        int x = java.lang.Math.abs(a);
        int y = java.lang.Math.abs(b);

        // Знаходимо найбільший спільний дільник.
        while (y != 0) {
            int remainder = x % y;
            x = y;
            y = remainder;
        }

        a /= x;
        b /= x;

        if (b < 0) {
            a = -a;
            b = -b;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rational)) return false;
        Rational other = (Rational) obj;
        return a == other.a && b == other.b;
    }

    @Override
    public String toString() {
        return a + "/" + b;
    }
    public static void main(String[] args) {
        System.out.println("Тести Rational:");
        Rational x = new Rational(2, 4);
        Rational y = new Rational(1, 3);
        System.out.println("Скорочення: " + x); // 1/2
        System.out.println("Сума: " + new Rational(1, 2).add(y)); // 5/6
        System.out.println("Більше: " + x.isGreater(y)); // true

        System.out.println("\nВведіть чисельник і знаменник першого дробу:");
        Scanner scanner = new Scanner(System.in);
        Rational first = new Rational(scanner.nextInt(), scanner.nextInt());
        System.out.println("Введіть чисельник і знаменник другого дробу:");
        Rational second = new Rational(scanner.nextInt(), scanner.nextInt());

        System.out.println("Перший дріб: " + first);
        System.out.println("Другий дріб: " + second);
        System.out.println("Чисельник першого: " + first.getChyselnyk());
        System.out.println("Знаменник першого: " + first.getZnamennyk());
        System.out.println("Сума: " + new Rational(first.a, first.b).add(second));
        System.out.println("Різниця: " + new Rational(first.a, first.b).vidniaty(second));
        System.out.println("Добуток: " + new Rational(first.a, first.b).pomnozhyty(second));
        if (second.getChyselnyk() != 0) {
            System.out.println("Частка: " + new Rational(first.a, first.b).podilyty(second));
        } else {
            System.out.println("Частка: ділити на нуль не можна.");
        }
        System.out.println("Більше: " + first.isGreater(second));
        System.out.println("equals: " + first.equals(second));
        System.out.println("Кількість об'єктів: " + Rational.getCount());
        scanner.close();
    }
}
