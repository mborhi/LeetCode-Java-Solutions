/**
 * LeetCode problem 5. Longest Palindromic Substring: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class Solution {

    /**
     * Finds the longest palindrome in the given string
     * Time Complexity: O(N^2), where N = the length of the given string
     * <p>
     * Space Complexity: O(1)
     *
     * @param s the string to find the longest palindrome in
     * @return the longest palindrome
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * Finds the longest palindrome in the given string using a brute force method
     * Time Complexity: O(N^3), where N = the length of the given string
     * <p>
     * Space Complexity: O(N), where N = the length of the given string
     *
     * @param s the string to find the longest palindrome in
     * @return the longest palindrome
     */
    public String longestPalindromeBruteForce(String s) {
        if (s.equals("")) return "";
        Map<Character, ArrayList<Integer>> letters = new HashMap<>();
        String longest = "";
        int pos = 0;
        while (pos < s.length()) {
            if (letters.containsKey(s.charAt(pos))) {
                ArrayList<Integer> indices = letters.get(s.charAt(pos));
                for (Integer idx : indices) {
                    String sub = s.substring(idx, pos + 1);
                    if (isPalindorme(sub) && sub.length() > longest.length()) {
                        longest = sub;
                    }
                }
                indices.add(pos);
            } else {
                ArrayList<Integer> i = new ArrayList<>();
                i.add(pos);
                letters.put(s.charAt(pos), i);
            }
            pos += 1;
        }
        if (longest.length() == 0) return s.substring(0, 1);
        else
            return longest;
    }

    /**
     * Determines if the given string is a palindrome
     * Helper method for longestPalindromeBruteForce
     *
     * @param s the string to test
     * @return whether the given string is a palindrome
     */
    public boolean isPalindorme(String s) {
        if (s.length() == 1) return false;
        String l = s.substring(0, s.length() / 2);
        if (s.length() % 2 != 0) {
            String r = s.substring(s.length() / 2 + 1, s.length());
            String rev = reverse(r);
            return l.equals(r);
        } else {
            String r = s.substring(s.length() / 2, s.length());
            String rev = reverse(r);
            return l.equals(r);
        }
    }

    /**
     * Reverses the given string
     * Helper method for isPalindrome
     *
     * @param s the string to reverse
     * @return the given string reversed
     */
    public String reverse(String s) {
        String rev = "";
        for (int i = 0; i < s.length(); i++) {
            rev = s.substring(i, i + 1) + rev;
        }
        return rev;
    }
}