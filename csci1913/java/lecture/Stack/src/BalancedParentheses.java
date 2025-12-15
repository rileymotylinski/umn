public class BalancedParentheses {

    // Test cases
    public static void main(String[] args) {
        String[] testCases = {
                "()",           // true
                "()[]{}",       // true
                "()[]{}",     // true
                "([{}])",       // true
                "([{}])",     // true
                "(]",           // false
                "([)]",         // false
                "(((",          // false
                "",             // true (empty string is balanced)
                "({[]})",       // true
                "((())",        // false
                "hello(world)", // true (ignores non-bracket chars)
                ")(",           // false
                "[(])"          // false
        };

        System.out.println("Testing Balanced Parentheses Checker:\n");
        for (String test : testCases) {
            boolean result = isBalanced(test);
            System.out.printf("'%s' -> %s%n", test, result);
        }
    }

    public static boolean isBalanced(String test) {
        // create stack
        Stack s = new Stack();
        // iterate characters in test

        for (char c : test.toCharArray()) {
            // if c is, push
            if (isOpenParentheses(c)) {
                s.push(c);
            } else if (isCloseParentheses((c)) ) {
                if (s.isEmpty()) {
                    return false;
                }
                char open = s.pop();
                // if char is close, pop stack to check match
                if (!isAMatch(open,c)) {
                    // if not match, return false
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isOpenParentheses(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isCloseParentheses(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean isAMatch(char open, char close) {
        return (int) (close - open) < 3 && (int) (close - open) > 0;
    }

}
