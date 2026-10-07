import java.util.Arrays;

public class Triangle {
    private double a, b, c;
    private static int count = 0;

    {
        a = b = c = 1;
    }

    public Triangle() {
        count++;
    }

    public Triangle(double side) {
        this(side, side, side);
    }

    public Triangle(double a, double b, double c) {
        if (!(a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a)) {
            System.out.println("Із цих сторін не можна створити трикутник.");
            System.exit(0);
        }
        double[] sides = {a, b, c};
        Arrays.sort(sides);
        this.a = sides[0];
        this.b = sides[1];
        this.c = sides[2];
        count++;
    }

    public static int getCount() {
        return count;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return java.lang.Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public void compareTo(Triangle other) {
        int result = Double.compare(getArea(), other.getArea());
        if(result == -1) {
            System.out.println("В другого трикутника менша площа");
        } else if (result == 0) {
            System.out.println("Площа однакова");
        } else {
            System.out.println("В другого трикутника площа більша");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Triangle)) System.out.println("Один з об'єктів не трикутник");
        Triangle other = (Triangle) obj;
        boolean equal = (a == other.a && b == other.b && c == other.c);
        if(equal) {
            System.out.println("Трикутники однакові");
        } else {
            System.out.println("Трикутники різні");
        } 
        return equal;
    }

    @Override
    public String toString() {
        return "Трикутник(" + a + ", " + b + ", " + c + ")";
    }
}