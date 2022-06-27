/**
 * LeetCode problem 72. Edit Distance: https://leetcode.com/problems/edit-distance/
 */
public class Solution {
    /**
     * Finds the Edit Distance between the two given strings
     * Time Complexity: O(M*N), where M = the length of the first string, and N = the length of the second string
     * A 2D array with size M * N is built and iterated through.
     * <p>
     * Space Complexity: O(M*N)
     * To store the minimum number of operations at each position, a 2D array is built which has the size M * N
     *
     * @param word1 the first string
     * @param word2 the second string
     * @return the Edit Distance
     */
    public int minDistance(String word1, String word2) {
        int[][] distanceTable = new int[word1.length() + 1][word2.length() + 1];
        // init table:
        for (int i = 0; i <= word1.length(); i++) {
            distanceTable[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            distanceTable[0][j] = j;
        }
        // fill the table
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int c;
                if (word1.substring(i - 1, i).equals(word2.substring(j - 1, j))) {
                    c = 0;
                } else {
                    c = 1;
                }
                // choose the operation with the minimum cost
                int value = Math.min(distanceTable[i - 1][j] + 1, Math.min(distanceTable[i][j - 1] + 1, distanceTable[i - 1][j - 1] + c));
                distanceTable[i][j] = value;
            }
        }
        return distanceTable[word1.length()][word2.length()];
    }
}