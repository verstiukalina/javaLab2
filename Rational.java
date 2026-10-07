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
}