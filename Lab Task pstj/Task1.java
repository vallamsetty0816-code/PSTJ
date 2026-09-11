import java.util.*;
import java.util.stream.*;

public class Task1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] salary = new int[n];

        for (int i = 0; i < n; i++) {
            salary[i] = sc.nextInt();
        }

        Arrays.stream(salary)
              .map(s -> s + (s / 10))
              .forEach(s -> System.out.print(s + " "));
    }
}