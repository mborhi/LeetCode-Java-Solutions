/**
 * LeetCode problem 13. Roman to Integer: https://leetcode.com/problems/roman-to-integer/
 */
public class Solution {
    /**
     * Coverts the given Roman numerals into a number
     * Time Complexity: Theta(N), where N = s.length()
     * The given string is always (at least and at most) iterated over once.
     * <p>
     * Space Complexity: O(1)
     * A HashMap of constant size is stored, two int variables are stored.
     *
     * @param s the Roman numeral
     * @return the converted number
     */
    public int romanToInt(String s) {
        // initialize a hashmap of values
        Map<String, Integer> values = new HashMap<String, Integer>();
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        int num = 0;
        int pos = 0;
        while (s.length() > 0 && pos < s.length() - 1) {
            String current = s.substring(pos, pos + 1);
            String adjacent = s.substring(pos + 1, pos + 2);
            // if the current value is less than the one to the right, add the subtracted value and skip over adajcent
            if (values.get(current) < values.get(adjacent)) {
                num += values.get(adjacent) - values.get(current);
                pos += 1;
            } else {
                num += values.get(current);
            }
            pos += 1;
        }
        // check if the last number needs to be added
        if (pos < s.length()) {
            return num + values.get(s.substring(pos, pos + 1));
        }
        return num;
    }
}