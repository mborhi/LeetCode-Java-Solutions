/**
 * LeetCode problem 88. Merge Sorted Array: https://leetcode.com/problems/merge-sorted-array/
 */
public class Solution {

    /**
     * Merges the two given sorted arrays
     * Time Complexity: O(N), where N = n (the size of nums2)
     * Since the size of nums2 is guranteed to be equal to less than the size of nums1, we only have to iterate through
     * nums2, copying the appropriate elements over to nums1.
     * <p>
     * Space Complexity: O(1)
     *
     * @param nums1 the first sorted array nums (size always >= size of nums2)
     * @param m     the number of elements in nums1
     * @param nums2 the second sorted array nums (size always <= size of nums1)
     * @param n     the number of elements in nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // index of the last "actual" element in nums1
        int pointerOne = m - 1;
        // index of the last element in nums2
        int pointerTwo = n - 1;
        // the index to insert values into (the last open index of nums1)
        int pos = m + n - 1;
        // while nums2 hasn't been iteratred over, iterate from the last elements in both arrays, inserting the larget
        // one into the last available position in nums1
        while (pointerTwo >= 0) {
            // check if the pointer is in range for nums1 and the value is larger
            if (pointerOne >= 0 && nums1[pointerOne] > nums2[pointerTwo]) {
                // assign the current value of nums1 to the last available position in nums1
                nums1[pos] = nums1[pointerOne];
                // decrement the pointers
                pos -= 1;
                pointerOne -= 1;
            } else { // the current values in nums1 is smaller than the curent value in nums2
                nums1[pos] = nums2[pointerTwo]; // insert nums2 value at last available
                // decrement the pointers
                pos -= 1;
                pointerTwo -= 1;
            }
        }
    }
}