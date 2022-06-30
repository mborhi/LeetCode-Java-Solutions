/**
 * LeetCode problem 58. Length of Last Word: https://leetcode.com/problems/length-of-last-word/
 */
public class Solution {
    /**
     * Finds the length of the last word in the given string
     * Time Complexity: O(N), where N = the length of the given string
     * Since the given string must contain at least one word, in the worst case, the entire string is a single word.
     * Thus, the time complexity is O(N).
     * <p>
     * Space Complexity: O(1)
     *
     * @param s the given string
     * @return the length of the last word
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        // since finding last word, start indexing from the end of the given string
        int idx = s.length() - 1;
        // move the index pointer towards 0 until there no longer is a space
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx -= 1;
        }
        // move the index pointer towards 0 until a space is encountered, counting the number of characters passed
        while (idx >= 0 && s.charAt(idx) != ' ') {
            idx -= 1;
            count += 1;
        }
        return count;
    }
}