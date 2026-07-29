/*Problem: Convert an infix expression to postfix notation using stack.

Input:
- Single line: infix expression (operands are single characters)

Output:
- Print the postfix expression*/
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Day33 {
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String convertToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); 
                }
            }
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String expression = scanner.nextLine().trim();
            System.out.println(convertToPostfix(expression));
        }
        scanner.close();
    }
}