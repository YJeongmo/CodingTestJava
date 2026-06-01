package sort;

import java.util.*;

class BiggestNumber {
    public String solution(int[] numbers) {
        int n = numbers.length;
        String answer = "";

        String[] sNumbers = new String[n];
        for (int i = 0; i < n; i++) {
            sNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(sNumbers, (a, b) -> (b + a).compareTo(a + b));

        for (String s : sNumbers) {
            answer += s;
        }

        if (answer.startsWith("0")) {
            return "0";
        } else {
            return answer;
        }

    }
}
