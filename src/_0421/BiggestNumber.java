package _0421;

import java.util.*;

public class BiggestNumber {                                          
    
    public String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        for (String s : arr) {
            answer += s;
        }

        if (answer.startsWith("0")) {
            return "0";
        }

        return answer;
    }

}
