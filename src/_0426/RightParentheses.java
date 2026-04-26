package _0426;

import java.util.*;

public class RightParentheses {
    public String solution(String p) {
        if (p.equals("")) {
            return "";
        }

        String[] uv = splitUV(p);
        String u = uv[0];
        String v = uv[1];

        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            sb.append(reverse(u.substring(1, u.length() - 1)));
            return sb.toString();
        }
    }


    // 4-4번 문자열 뒤집기
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '(' ? ')' : '(');
        }
        return sb.toString();
    }


    // 2번 문자열 분리
    public String[] splitUV(String s) {
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                String u = s.substring(0, i + 1);
                String v = s.substring(i + 1);
                return new String[]{u, v};
            }
        }
        return new String[]{"", ""};
    }


    // 3번 올바른 문자열 확인
    public boolean isCorrect(String s) {

        if (s.equals("")) {
            return true;
        }

        Deque<Character> deq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                deq.offerLast(c);
            } else {
                if (deq.isEmpty()) {
                    return false;
                }
                deq.pollLast();
            }

        }
        return deq.isEmpty();
    }

}
