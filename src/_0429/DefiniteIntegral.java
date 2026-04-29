package _0429;

import java.util.*;

public class DefiniteIntegral {

    List<Double> y = new ArrayList<>();
    List<Double> prefix = new ArrayList<>();

    public double[] solution(int k, int[][] ranges) {

        calY(k);
        calArea();

        int n = ranges.length;
        double[] answer = new double[n];

        for (int i = 0; i < n; i++) {
            int s = ranges[i][0];
            int e = y.size() + ranges[i][1] - 1;

            if (s > e) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefix.get(e) - prefix.get(s);
            }
        }
        return answer;
    }


    public void calY(int k) {

        y.add((double) k);
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = 3 * k + 1;
            }
            y.add((double) k);
        }
    }


    public void calArea() {

        prefix.add(0.0);
        for (int i = 0; i < y.size() - 1; i++) {
            double area = (y.get(i) + y.get(i + 1)) / 2.0;
            prefix.add(prefix.get(i) + area);
        }
    }
}
