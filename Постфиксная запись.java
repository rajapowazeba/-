import java.util.*;

public class PostfixEvaluator {

    public static int evaluatePostfix(String expression) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine().trim();
        System.out.println(evaluatePostfix(expression));
        scanner.close();
    }
}
