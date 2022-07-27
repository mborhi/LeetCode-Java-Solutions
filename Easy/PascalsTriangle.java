/**
 * LeetCode problem 118. Pascal's Triangle: https://leetcode.com/problems/pascals-triangle/
 */
public class Solution {

    /**
     * Creates a Pascal's Triangle with the given number of rows.
     * <p>
     * Time Complexity: O(N^2), where N = the number of rows specified
     * For each row, values are iterated through from 1 to N - 1, or simplified, N
     * <p>
     * Spaace Complexity: O(N^2), where N = the number of rows specified
     * All of the rows need to be stored, this is guranteed to be N^2
     *
     * @param numRows the number of rows of the Pascal's Triangle
     * @return the Pascal's Triangle
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            // first and last index of the list is always 1
            row.add(0, 1);
            row.add(row.size() - 1, 1);
            // fill the row
            for (int j = 1; j < i; j++) {
                List<Integer> rowAbove = triangle.get(i - 1);
                Integer aboveLeft = rowAbove.get(j - 1);
                Integer aboveRight = rowAbove.get(j);
                row.add(j, aboveLeft + aboveRight);
            }
            triangle.add(row);
        }
        return triangle;
    }

}