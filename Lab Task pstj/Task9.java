import java.util.*;

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class Task9 {

    // Unit test for addition
    static boolean testAddition() {
        Calculator calc = new Calculator();

        return calc.add(10, 20) == 30;
    }

    // Unit test for division
    static boolean testDivision() {
        Calculator calc = new Calculator();

        return calc.divide(20, 10) == 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String operator = sc.next();
        int b = sc.nextInt();

        Calculator calc = new Calculator();

        boolean passed = false;

        if (operator.equals("+")) {
            int result = calc.add(a, b);

            // Expected result
            int expected = a + b;

            passed = (result == expected);
        }

        else if (operator.equals("/")) {
            if (b != 0) {
                int result = calc.divide(a, b);

                int expected = a / b;

                passed = (result == expected);
            }
        }

        if (passed) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        sc.close();
    }
}