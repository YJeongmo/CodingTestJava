public class SkillTree {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (String tree : skill_trees) {
                String check = "";
                for (char c : tree.toCharArray()) {
                    if (skill.contains(String.valueOf(c))) {
                        check += c;
                    }
                }

                if (skill.startsWith(check)) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
