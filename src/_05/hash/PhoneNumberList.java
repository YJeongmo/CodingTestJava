package _05.hash;

import java.util.*;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            String now = phone_book[i];
            String before = phone_book[i-1];

            if (now.startsWith(before)) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
