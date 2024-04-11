package Programmers;

import java.util.Stack;

public class 괄호문제 {
    public static void main(String[] args) {
        String str = "(())()";
        System.out.print(solution(str));
    }

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
