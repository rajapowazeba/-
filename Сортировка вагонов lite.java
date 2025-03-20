import java.util.*;

public class TrainCars {

    public static String canArrangeCars(int n, int[] cars) {
        Stack<Integer> stack = new Stack<>();
        int expected = 1;

        for (int car : cars) {
            stack.push(car);
            while (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            }
        }
        return expected == n + 1 ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cars = new int[n];

        for (int i = 0; i < n; i++) {
            cars[i] = scanner.nextInt();
        }

        System.out.println(canArrangeCars(n, cars));
        scanner.close();
    }
}