package _05._0507;

class DotBetweenTwoCircles {

    public long solution(int r1, int r2) {

        long answer = 0;

        for (long x = 1; x <= r2; x++) {

            long cnt1 = 0;
            long cnt2 = (long)Math.sqrt((long)r2 * r2 - x * x);

            if (x < r1) {
                cnt1 = (long)Math.ceil(Math.sqrt((long)r1 * r1 - x * x));
            }

            answer += (cnt2 - cnt1 + 1);
        }

        return answer * 4;
    }
}