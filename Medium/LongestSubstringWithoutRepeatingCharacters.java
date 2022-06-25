/**
 * LeetCode problem 3. Longest Substring Without Repeating Characters:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {
    /**
     * Finds the length of the longest substring that has no repeating characters
     * Time Complexity: O(N), where N = the length of the given string
     * In the worst case, if the first character is repeated at the last index of the string, the entire string is
     * iteratred and restarted at index one. So, the time complexity is 2N-1, dropping constants we get O(N). In the
     * best case, the given string has no repeating characters so no element is revisted, so the string was iterated
     * over once: O(N).
     * <p>
     * Space Complexity: O(N), where N = the length of the given string
     * In the worst case, there is no repeating character in the given string, so every single character is added to the
     * counted HashMap. Thus, the maximum size of the HashMap will be equivalent to the length of the given string.
     *
     * @param s the string to find the substring in
     * @return the length of the longest substring with no repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int count = 0;
        // HashMap to keep track of the counted characters and their respective indices
        Map<Character, Integer> counted = new HashMap<>();
        int pos = 0;
        while (pos < s.length()) {
            if (counted.keySet().contains(s.charAt(pos))) {
                // already contains i.e. duplicate, set pos to be + 1 of stored idx, and clear HashMap
                if (count > longest) {
                    longest = count;
                }
                // restart from this pos (+1) to restart substring count
                pos = counted.get(s.charAt(pos));
                // remove all counted
                counted.clear();
                count = 0;
            } else {
                // increment count
                count += 1;
                // add the char at the curr index
                counted.put(s.charAt(pos), pos);
            }
            pos += 1;
        }
        // replace longest with count if needed
        if (count > longest) longest = count;
        return longest;
    }
}