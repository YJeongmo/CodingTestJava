package _05._0507;

class NumberBlock {
    final int MAX_BLOCK = 10_000_000;

    public int[] solution(long begin, long end) {

        int[] answer = new int[(int)(end - begin + 1)];

        int idx = 0;

        for (long i = begin; i <= end; i++) {

            if (i == 1) {
                answer[idx] = 0;
                idx++;
                continue;
            }

            int block = 1;

            for (long j = 2; j * j <= i; j++) {

                if (i % j == 0) {
                    long pair = i / j;

                    if (pair <= MAX_BLOCK) {
                        block = (int)pair;
                        break;
                    }
                    block = (int)j;
                }
            }

            answer[idx] = block;
            idx++;
        }

        return answer;
    }
}