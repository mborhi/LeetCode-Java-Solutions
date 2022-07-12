/**
 * LeetCode problem 97. Interleaving String: https://leetcode.com/problems/interleaving-string/
 */
public class Solution {
    /**
     * Determines whether the first two given strings can be interleaved to make the third string
     * Time Complexity: O(M*N), where M = the length of the first string and N = the length of the second string
     * The array of boolean values needs to be filled, which has a size equivalent to M * N
     * <p>
     * Space Complexity: O(M*N)
     * @param s1 the first string
     * @param s2 the second string
     * @param s3 the string to combine to
     * @return whether the first two strings can be interleaved to make the third string
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        reutrn dp[s1.length()][s2.length()];
    }

    /**
     * Time Complexity: O(2^(M+N)), where M = the length of the first string and N = the length of the second string
     * <p>
     * Space Complexity: O(M+N)
     * This is because the size of the recursion stack can go up to M + N.
     */
    public boolean isInterleaveBruteForce(String s1, String s2, String s3) {
        if (s1.length() == 0 && s1.length() == 0) return s3.length() == 0;
        if (s1.length() == 0) return s2.equals(s3);
        if (s2.length() == 0) return s1.equals(s3);

        if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1.substring(1), s2, s3.substring(1)) || isInterleave(s1, s2.substring(1), s3.substring(1));
        } else if (s1.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1.substring(1), s2, s3.substring(1));
        } else {
            return isInterleave(s1, s2.substring(1), s3.substring(1));
        }
    }
}