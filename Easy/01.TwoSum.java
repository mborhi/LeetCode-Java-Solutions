/**
 * LeetCode problem 1. Two Sum: https://leetcode.com/problems/two-sum/
 */
public class Solution {
    /**
     * Finds the positions in the given array of integers whose values add up to the given target
     * Time Complexity: O(N), where N = length of nums
     * There is a single iteration over the nums.
     * <p>
     * Space Complexity: O(N), where N = length of nums
     * The value-index pairs are stored in a HashMap. In the worst case, if the last index is the pair this will have a
     * size of N - 1, since all previous indices need to be stored. The output array will always be the same size.
     *
     * @param nums   the array to find the indices in
     * @param target the number two values in nums must add up to
     * @return an array of the two indices
     */
    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];
        Map<Integer, Integer> vals = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // check if there is a complementary value stored
            if (vals.containsKey(target - nums[i])) {
                // add indices to output array
                sol[0] = i;
                sol[1] = vals.get(target - nums[i]);
            } else {
                // the corresponding pair is not found, store the value and index
                vals.put(nums[i], i);
            }
        }
        return sol;
    }

    /**
     * Brute force solution for Two Sum
     * Time Complexity: O(N^2), where N = length of nums
     * There is an iteration over nums for every value in it.
     * <p>
     * Space Complexity: O(1)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] sol = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    sol[0] = i;
                    sol[1] = j;
                }
            }
        }
        return sol;
    }
}