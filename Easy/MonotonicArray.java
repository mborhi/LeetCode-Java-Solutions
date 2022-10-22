/**
 * Solution for 896. Monotonic Array: https://leetcode.com/problems/monotonic-array/
 */
public class Solution {

    /**
     * Sequentially determines whether the given array is monotonically decreasing or increasing.
     * Time Complexity: O(N), Space Complexity: O(1)
     *
     * @param nums the array of numbers to test for being monotonic
     * @return whether the given array is monotonically increasing or decreasing
     */
    public boolean isMonotonic(int[] nums) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                inc = false;
            } else if (nums[i] <= nums[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }

    /**
     * Solution 2. Compare the first and last elements to see whether the array needs to monotonically decrease or
     * increase. This approach does not work if nums is a stream, since the first and last elements can't be compared.
     * Time Complexity: O(N), Space Complexity: O(1)
     *
     * @param nums the array of numbers to test for being monotonic
     * @return whether the given array is monotonically increasing or decreasing
     */
    public boolean isMonotonicTwo(int[] nums) {
        boolean dec = nums[0] <= nums[nums.length - 1];
        if (dec) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    }
}