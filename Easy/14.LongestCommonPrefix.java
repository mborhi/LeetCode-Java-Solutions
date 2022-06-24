/**
 * LeetCode problem 14. Longest Common Prefix: https://leetcode.com/problems/longest-common-prefix/
 */
public class Solution {
    /**
     * Finds the longest common prefix amongst all strings in a given array
     * Time Complexity: O(N*S), where N = the length of the array of strings and S = the length of the shortest string
     * in the given array.
     * <p>
     * Space Complexity: O(1)
     *
     * @param strs the array of strings
     * @return the longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        String longestCommon = "";
        int pos = 0;
        // check that iterator is not out of bounds for the shorest string amongst strs
        while (lessThanShortest(pos)) {
            // take the first unchecked character
            String comp = strs[0].substring(pos, pos + 1);
            // compare this to all strings
            for (String str : strs) {
                // the uncheck character doesn't match, return the previously computed longest common prefix
                if (!comp.equals(str.substring(pos, pos + 1))) {
                    return longestCommon;
                }
            }
            // all strings match, add the character to the current longest common prefix
            longestCommon += comp;
            pos += 1;
        }
        return longestCommon;
    }

    /**
     * Determines if given number is less than the length of every string in the given array of strings
     * Helper function for longestCommonPrefix()
     *
     * @param n    the number to check
     * @param strs the list of strings
     * @return whether n is less
     */
    public boolean lessThanShortest(int n, String[] strs) {
        for (String str : strs) {
            if (n >= str.length()) return false;
        }
        return true;
    }

    // binary search solution

}