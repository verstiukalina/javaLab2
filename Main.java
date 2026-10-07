public class Main {
    public static void main(String[] args) {
        Rational zero = new Rational();
        Rational whole = new Rational(3);
        Rational x = new Rational(2, 4);
        Rational y = new Rational(1, 3);
        Rational same = new Rational(1, 2);
        Rational negative = new Rational(1, -2);

        System.out.println("Без параметрів: " + zero); // 0/1
        System.out.println("Ціле число: " + whole);    // 3/1
        System.out.println("Скорочення: " + x);       // 1/2
        System.out.println("Від'ємний дріб: " + negative); // -1/2
        System.out.println("Чисельник: " + x.getChyselnyk());
        System.out.println("Знаменник: " + x.getZnamennyk());

        System.out.println("Сума: " + new Rational(1, 2).add(y));          // 5/6
        System.out.println("Різниця: " + new Rational(1, 2).vidniaty(y)); // 1/6
        System.out.println("Добуток: " + new Rational(1, 2).pomnozhyty(y)); // 1/6
        System.out.println("Частка: " + new Rational(1, 2).podilyty(y));     // 3/2

        System.out.println("Рівні: " + x.isEqual(same)); // true
        System.out.println("Більше: " + x.isGreater(y)); // true
        System.out.println("Менше: " + y.isLess(x));     // true
        System.out.println("equals: " + x.equals(same)); // true
        System.out.println("equals для різних: " + x.equals(y)); // false
        System.out.println("toString: " + x.toString()); // 1/2
        System.out.println("Кількість об'єктів: " + Rational.getCount()); // 10

        System.out.println("\nТрикутники:");
        Triangle unit = new Triangle();
        Triangle equilateral = new Triangle(2);
        Triangle triangle = new Triangle(3, 4, 5);
        Triangle equalTriangle = new Triangle(5, 3, 4);
        Triangle large = new Triangle(6, 8, 10);

        System.out.println("Без параметрів: " + unit);
        System.out.println("Рівносторонній: " + equilateral);
        System.out.println("toString: " + triangle.toString());
        System.out.println("Периметр: " + triangle.getPerimeter()); // 12.0
        System.out.println("Площа: " + triangle.getArea());         // 6.0
        System.out.println("Менша площа: ");
        triangle.compareTo(large); 
        System.out.println("Однакова площа: ");
        triangle.compareTo(equalTriangle); 
        System.out.println("Більша площа: ");
        large.compareTo(triangle);
        System.out.println("equals: " + triangle.equals(equalTriangle)); // true
        System.out.println("equals для різних: " + triangle.equals(large)); // false
        System.out.println("Кількість трикутників: " + Triangle.getCount()); // 5

        System.out.println("\nМатематичні обчислення:");
        Math numbers = new Math(12, 18);
        Math sameNumbers = new Math(12, 18);

        System.out.println("Без параметрів: " + new Math());
        System.out.println("Один параметр: " + new Math(12));
        System.out.println("toString: " + numbers.toString());
        System.out.println("НСД: " + numbers.gcd()); // 6
        System.out.println("НСК: " + numbers.lcm()); // 36
        System.out.println("equals: " + numbers.equals(sameNumbers)); // true
        System.out.println("Кількість об'єктів: " + Math.getCount()); // 4

        new Triangle(1, 2, 3); // Попередження та завершення програми.
    }
}