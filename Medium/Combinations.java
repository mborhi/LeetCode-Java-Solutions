/**
 * LeetCode 77. Combinations: https://leetcode.com/problems/combinations/
 */

public class Solution {

    /**
     * Returns all combinations of k numbers chosen from the range 1 to n
     * <p>
     * Time Complexity: O(N^K)
     * <p>
     * Space Complexity: O(N!/(K!(N-K)!)) = O(N^K) , i.e. N choose K, the total number of combinations
     *
     * @param n the range of numbers
     * @param k the amount of numbers in each combination
     * @return the combinations
     */
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<Integer>(), n, k, 1);
        return combinations;
    }

    public void backtrack(ArrayList<List<Integer>> combs, ArrayList<Integer> comb, int range, int size, int start) {
        if (comb.size() == size) {
            combs.add(new ArrayList<Integer>(comb));
        } else {
            for (int i = start; i <= range; i++) {
                comb.add(i);
                backtrack(combs, comb, range, size, i + 1);
                comb.remove(Integer.valueOf(i));
            }
        }
    }
}