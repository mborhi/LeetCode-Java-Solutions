/**
 * LeetCode solution for 169. Majority Element: https://leetcode.com/problems/majority-element/
 */
public class Solution {

    /**
     * Finds the element which occurs the moajority of the time (n / 2)
     * <p>
     * Time Complexity: O(N), where N = the number of elements in the given array
     * The array is iterated over once, adding all elements to a HashMap, clearly this takes N time. Next, the key with
     * the highest value in the HashMap is found, by iterating over all key-value pairs. Thus, the total complexity is
     * O(N).
     * <p>
     * Space Complexity: O(N), where N = the number of elements in the given array
     * All of the array elements are added to a HashMap. The array is guranteed to have at least N - N/2 unique
     * elements, so the maximum space is O(N).
     *
     * @param nums the array of numbers
     * @return the element which occurs the majority of the time
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (count.keySet().contains(nums[i])) {
                int val = count.get(nums[i]);
                count.put(nums[i], val + 1);
            } else {
                count.put(nums[i], 1);
            }
        }
        for (Integer n : count.keySet()) {
            if (count.get(n) > nums.length / 2) {
                return n;
            }
        }

        return nums[0];
    }
}