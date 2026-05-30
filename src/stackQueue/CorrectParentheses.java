package stackQueue;

import java.util.*;

public class CorrectParentheses {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() && c == ')') {
                stack.pop();
                continue;
            }

            if (stack.isEmpty() && c == ')') {
                return false;
            }

            if (c == '(') {
                stack.push(c);
            }

        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
