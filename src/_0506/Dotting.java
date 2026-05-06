package _0506;

class Dotting {
    public long solution(int k, int d) {
        long answer = 0;

        for (long x = 0; x <= d; x += k) {

            long canY = (long)Math.sqrt((long)d*d - x*x);
            answer += canY / k + 1;
        }
        return answer;
    }
}