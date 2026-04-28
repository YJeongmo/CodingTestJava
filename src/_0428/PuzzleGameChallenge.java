package _0428;

class PuzzleGameChallenge {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        int left = 1;
        int right = 100_000;

        while(left <= right) {
            int mid = (left + right) / 2;

            long temp = runTime(diffs, times, limit, mid);

            if (temp >= 0) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    public long runTime (int[] diffs, int[] times, long limit, int level) {
        long total = 0;
        int prev = 1;

        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int time = times[i];
            
            if (diff <= level) {
                total += time;
                prev = time;
            } else {
                total += (prev + time) * (diff - level) + time;
                prev = time;
            }

            if (total > limit) {
                return -1;
            }
        }
        return total;
    }
}
