/**
 * LeetCode problem 9. Palindrome Number: https://leetcode.com/problems/palindrome-number/
 */
public class Solution {
    /**
     * Determines whether the given number is a palindrome
     * Time Complexity: O(logN), where N = number of digits in the given number
     * <p>
     * Space Complexity: O(1)
     *
     * @param x the number to test
     * @return whether the number is a palindrome
     */
    public static boolean isPalindrome(int x) {
        // a negative number can't ba palindrome, a number can't begin with 0
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        // revert the last half of the number, reached half when remainder <= reverted
        int reverted = 0;
        while (x > reverted) {
            // calculate the value
            // multiplying by 10 increases digit count, add the last digit of x to it
            reverted = (reverted * 10) + (x % 10);
            // cut off the last digit of x
            x = x / 10;
        }
        // remove the middle digit if needed
        return (x == reverted) || (x == reverted / 10);
    }
}