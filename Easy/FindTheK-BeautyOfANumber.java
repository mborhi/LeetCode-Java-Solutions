/**
 * LeetCode problem 2269. Find the K-Beauty of a Number: https://leetcode.com/problems/find-the-k-beauty-of-a-number/
 */
public class Solution {

    /**
     * Counts the number of substrings of num which have length of k and is a divisor of num
     * Time Complexity: O(N), where N = the number of digits of num
     * Space Complexity: O(1)
     *
     * @param num the integer to find the k-beauty of
     * @param k
     * @return the k-beauty of the number
     */
    public int divisorSubstrings(int num, int k) {
        // count number of substrings of num which have length of k, divisor of num
        int count = 0;
        String numStr = Integer.toString(num);
        for (int i = 0; i < numStr.length() + 1 - k; i++) {
            // substring always has length of k
            int numSub = Integer.parseInt(numStr.substring(i, i + k));
            // don't compute if the substring is 0
            if (numSub != 0 && num % numSub == 0) {
                count += 1;
            }
        }
        return count;
    }
}