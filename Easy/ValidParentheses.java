/**
 * LeetCode problem 20. Valid Parentheses: https://leetcode.com/problems/valid-parentheses/
 */
public class Solution {

    /**
     * Determines whether each opening parenthesis has a correctly matching closing parenthesis
     * Time Complexity: O(N), where N = the length of the given string
     * The given string is only iterated through once, pushing or popping a character from the stack.
     * <p>
     * Space Complexity: (N), where N = the length of the given string
     * A Stack of Characters is used to keep track of the the corresponding closing parens of every opening paren. In
     * the worse case, the given string will consist of all opening parens, so a closing paren is pushed onto the stack
     * for each one, and nothing will be popped. Thus, the size of the stack can at most be equal to the size of the
     * given string.
     *
     * @param s the string to test matching parens in
     * @return whether the string has matching parens
     */
    public boolean isValid(String s) {
        Stack<Character> parenStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // check for opening parens, push correspnding closing paren onto stack
            if (s.charAt(i) == "(") {
                parenStack.push(")");
            } else if (s.charAt(i) == "[") {
                parenStack.push("]");
            } else if (s.charAt(i) == "{") {
                parenStack.push("}");
            } else if (parenStack.isEmpty() || !parenStack.pop() != s.charAt(i)) {
                return false;
            }
        }
        return parenStack.isEmpty();
    }

    /**
     * Time Complexity: O(N), where N = the length of the given string
     * The given string is only iterated through once
     * <p>
     * Space Complexity: O(N), where N = the length of the given string
     * A Stack is used to push corresponding closing parens for every opening paren. In the wrost case, if the given
     * string only consists of opening parens, the size of the stack will be equal to the size of this given string.
     * Additionally, in this implementation a HashMap is used to push correct closing parens onto the stack, however
     * since this uses constant space, it can be ignored.
     *
     * @param s the string to test matching parens in
     * @return whether the string has matching parens
     */
    public boolean isValidMap(String s) {
        // stack of parens to match
        Stack<String> parenStack = new Stack<>();
        Map<String, String> parens = new HashMap<>();
        parens.put("(", ")");
        parens.put("[", "]");
        parens.put("{", "}");
        for (int i = 0; i < s.length(); i++) {
            String curr = s.substring(i, i + 1);
            // check if the curr is an opening paren
            if (parens.keySet().contains(curr)) {
                // push the corresponding closing paren
                parenStack.push(parens.get(curr));
            } else { // curr is a closing paren
                // check if there is an extra closing paren (empty stack) or if the curr doesn't match
                if (parenStack.isEmpty() || !parenStack.peek().equals(curr)) {
                    return false;
                } else {
                    // the top of the stack matches, remove it
                    parenStack.pop();
                }
            }
        }
        // if stack isn't empty, there is a trailing open paren
        return parenStack.isEmpty();
    }
}