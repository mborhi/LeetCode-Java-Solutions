/**
 * LeetCode problem 27. Remove Element: https://leetcode.com/problems/remove-element/
 */
public class Solution {

    /**
     * Removes the specified value from the given array of numbers, returning the new length of the array
     * Time Complexity: O(N), where N = the size of the given array
     * <p>
     * Space Complexity: O(1)
     *
     * @param nums the array to remove from
     * @param val  the value to remove from the array
     * @return the new length of the array
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count += 1;
            }
        }
        return count;
    }
}