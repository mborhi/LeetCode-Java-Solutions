/**
 * LeetCode problem 2140. Solving Questions With Brainpower:
 * https://leetcode.com/problems/solving-questions-with-brainpower/
 */
public class Solution {

    /**
     * Uses DFS to find maximum possible points for exam.
     *
     * @param questions The matrix containing score, skip pairs
     * @return the maximum possible points
     */
    public long mostPointsDFS(int[][] questions) {
        Map<Integer, Long> memo = new HashMap<>();
        return mostPointsHelper(0, 0, memo, questions);
    }

    public long mostPointsHelper(int i, long most, Map<Integer, Long> memo, int[][] questions) {
        if (i >= questions.length) return most;
        // retrieve if already stored
        if (memo.keySet().contains(i)) {
            return memo.get(i);
        }
        // select max of skipping, taking
        long skip = mostPointsHelper(i + 1, most, memo, questions);
        int nextIdx = i + questions[i][1] + 1;
        long take = questions[i][0] + mostPointsHelper(nextIdx, most, memo, questions);
        most = Math.max(skip, take);
        memo.put(i, most);
        return most;
    }
}