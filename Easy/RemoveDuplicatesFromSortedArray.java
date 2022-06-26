/**
 * LeetCode problem 26. Remove Duplicates from Sorted Array:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {

    /**
     * Removes all duplicate elements in the given sorted array of integers and returns the number of unique elements
     * Time Complexity: O(N), where N = the size of the array of integers
     * The elements are shifted "in place", by replacing the newly found duplicate element at the index equal to the
     * number of unique elements counted so far. This is done in one iteration over the given list.
     * <p>
     * Space Complexity: O(1)
     *
     * @param nums the sorted array of integers
     * @return the number of unique elements
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count += 1;
            }
        }
        return count;
    }

    /**
     * Non-optimised shifting.
     * Time Complexity: O(N^2), where N = the size of nums
     * Shifts all elements down and sifts the duplicate to the end of the array every time a duplicate is found. So, in
     * the worst case, N * SUM(0 to N-1) steps are taken. Hence, O(N^2).
     * <p>
     * Space Complexity: O(1)
     */
    public int removeDuplicatesWithShift(int[] nums) {
        int count = nums.length;
        int pos = 0;
        while (pos < count - 1) {
            if (nums[i] == nums[i + 1]) {
                // set duplicate to null
                nums[i + 1] = Integer.MAX_VALUE;
                // shift elements
                nums = shiftElements(nums, i + 1);
                count -= 1;
            } else {
                pos += 1;
            }
        }
        return count;
    }

    /**
     * Brute-force solution using a nested for loop to check for duplicates
     * Time Complexity: O(N^2), where N = the size of nums
     * Space Complexity: O(1)
     */
    public int removeDuplicatesBruteForce(int[] nums) {
        // for every element, loop through arr, if there is duplicate, delete and shift
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    nums[j] = Integer.MAX_VALUE;
                    nums = shiftElements(nums, idx);
                }
            }
        }
    }

    /**
     * Shifts all the elements after the given index down
     *
     * @param arr the array to shift
     * @param idx the index to shift from
     * @return the shifted array
     */
    public int[] shiftElements(int[] arr, int idx) {
        for (int i = idx; i < arr.length - 1; i++) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        return arr;
    }
}