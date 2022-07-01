/**
 * LeetCode problem 1710. Maximum Units on a Truck: https://leetcode.com/problems/maximum-units-on-a-truck/
 */
public class Solution {
    /**
     * Finds the total units that the given truck can carry
     * Time Complexity: O(N + M), where N = length of boxTypes, and M = truckSize
     * <p>
     * Space Complexity: O(N), where N = length of boxTypes
     *
     * @param boxTypes  the boxes to be loaded (boxAmount, unitsPerBox)
     * @param truckSize the number of boxes that can be loaded
     * @return the total units that can be carried by the truck
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // get the largest of numberOfUnitsPerBox, add as many as possible, find the next largest etc. maximize
        // do this until all the boxes have been added or there isn't any space left on truck
        int spaceLeft = truckSize;
        int total = 0;
        Set<Integer> added = new HashSet<>();
        while (spaceLeft > 0 && added.size() != boxTypes.length) {
            // find the largest numberOfUnitsPerBox
            int largest = findLargestUnits(boxTypes, added);
            int noOfBoxes = boxTypes[largest][0];
            int units = boxTypes[largest][1];
            // increment total until possible
            while (noOfBoxes > 0 && spaceLeft > 0) {
                spaceLeft -= 1;
                noOfBoxes -= 1;
                total += units;
            }
            // mark this index as seen
            added.add(largest);
        }
        return total;
    }

    /**
     * Finds the index of the largest number of units per box
     *
     * @param boxTypes
     * @return
     */
    public int findLargestUnits(int[][] boxTypes, Set<Integer> added) {
        int largest = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (added.contains(largest)) largest = i;
            if (boxTypes[i][1] >= boxTypes[largest][1] && !added.contains(i)) {
                largest = i;
            }
        }
        return largest;
    }
}