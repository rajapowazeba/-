import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BracketSequence {
    public static String isValidBrackets(String seq) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char bracket : seq.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                deque.offerLast(bracket);
            } else {
                if (deque.isEmpty()) {
                    return "no";
                }
                char open = deque.pollLast();
                if ((bracket == ')' && open != '(') ||
                        (bracket == ']' && open != '[') ||
                        (bracket == '}' && open != '{')) {
                    return "no";
                }
            }
        }
        return deque.isEmpty() ? "yes" : "no";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine().trim();
        System.out.println(isValidBrackets(sequence));
        scanner.close();
    }
}
