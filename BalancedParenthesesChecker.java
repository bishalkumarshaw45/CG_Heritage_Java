import java.util.ArrayDeque;

public class BalancedParenthesesChecker {
    public static void main(String[] args) {
        String[] testInputs = {
            "((()))",           // only round brackets
            "[({})]",           // mixed brackets and valid
            "([)]",             // invalid sequence
            ""                  // empty string
        };

        for (String input : testInputs) {
            String displayInput = input.isEmpty() ? "<empty string>" : input;
            boolean balanced = isBalanced(input);
            System.out.println("Input: " + displayInput);
            System.out.println(balanced ? "Result: BALANCED" : "Result: NOT BALANCED");
            System.out.println();
        }
    }

    /**
     * Checks whether the input string has balanced parentheses using a stack.
     */
    private static boolean isBalanced(String input) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char ch : input.toCharArray()) {
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else if (isClosingBracket(ch)) {
                if (stack.isEmpty() || !matches(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpeningBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isClosingBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }
}
